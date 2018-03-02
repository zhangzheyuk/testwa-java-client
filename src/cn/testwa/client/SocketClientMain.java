package cn.testwa.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;  
import java.io.InputStreamReader;
import java.io.ObjectInputStream;  
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;  
import java.net.UnknownHostException; 

import com.android.ddmlib.AdbCommandRejectedException;
import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;
import com.android.ddmlib.TimeoutException;
import com.google.gson.Gson;

public class SocketClientMain {
	private Socket socket;  
    private PrintWriter out;  
    private BufferedReader in;
    
    public SocketClientMain(){  
        try {  
        	AndroidDebugBridge.init(false);
			AndroidDebugBridge adbBridge = AndroidDebugBridge.createBridge();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			IDevice[] devices = adbBridge.getDevices();
			IDevice oTargetDevice = devices[0];
			oTargetDevice.createForward(4008, 8011);
			socket = new Socket("127.0.0.1", 4008);
            out=new PrintWriter(socket.getOutputStream());
            ReadThread readThread=new ReadThread();  
            readThread.start();  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AdbCommandRejectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }  
    public void shutdown(){
    	if (socket == null) {
			return;
		}
    	try {
			socket.shutdownInput();
			socket.shutdownOutput();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
      
    public void sendMessage(String msg) throws IOException{  
        System.out.println("send message:"+msg);  
        out.println(msg);  
		out.flush();  
    }  
      
    class ReadThread extends Thread{  
        boolean runFlag=true;  
        public void run(){  
            try {  
            	in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
               // in=new BufferedReader(socket.getInputStream());  
	            String line=null;
	            while(runFlag  &&(line=in.readLine())!=null){  
	                if(socket.isClosed()){  
	                    return;  
	                } 
	                if (!runFlag) {
						break;
					}
					if (line.length() == 0) {
						continue;
					}
					if (line.contains("LOGCATRETURN")) {
						try {
							 System.out.println("Client recive:"+line); 
							AndroidFilePathListJsonResult command = new Gson().fromJson(line, AndroidFilePathListJsonResult.class);
							Runtime.getRuntime().exec("adb -s 3HX0217623002414 pull "+command.getLogcatFileFullPath()+" "+"");
						} catch (Exception e) {
							System.out.println(e.getLocalizedMessage());
						}
					}
                    
	            } 
            } catch (IOException e1) {  
                e1.printStackTrace();  
            } 
        }  
          
        public void exit(){  
            runFlag=false;  
        }  
    }  
      
    public static void main(String[] args) throws InterruptedException, IOException {  
        SocketClientMain socketClient=new SocketClientMain();  
        System.out.println("build socketClient");  
        try {  
            Thread.sleep(1000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } 
        
        
//        for (int i = 0; i <5; i++) {
//        	AndroidCommand command = new AndroidCommand();
//    		command.setCommandType(AndroidCommandType.LOGCATSTART.name());
//    		socketClient.sendMessage(new Gson().toJson(command));
//    		 try {  
//    	            Thread.sleep(5000);  
//    	        } catch (InterruptedException e) {  
//    	            e.printStackTrace();  
//    	        }
//    		command = new AndroidCommand();
//    		command.setCommandType(AndroidCommandType.LOGCATEND.name());
//    		socketClient.sendMessage(new Gson().toJson(command));
//    		 try {  
//    	            Thread.sleep(5000);  
//    	        } catch (InterruptedException e) {  
//    	            e.printStackTrace();  
//    	        }
//		}
		
		
		
		
        AndroidCommand command = new AndroidCommand();
		command.setCommandType(AndroidCommandType.START.name());
		command.setPackageName("com.csii.zybk.ui");
		String tmp=new Gson().toJson(command);
		socketClient.sendMessage(new Gson().toJson(command));
//		
//		 AndroidCommand command1 = new AndroidCommand();
//		command1.setCommandType(AndroidCommandType.END.name());
//		command1.setPackageName("com.csii.zybk.ui");
//		socketClient.sendMessage(new Gson().toJson(command1));
//		
		
		
		
    }  
  
}  
