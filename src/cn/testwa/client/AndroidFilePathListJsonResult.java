package cn.testwa.client;

import java.util.ArrayList;

public class AndroidFilePathListJsonResult {

	private int mobileResultID;
	private String commandType;
	private String returnFileType="";
	private String logcatFileFullPath="";
	private String logcatFileName="";
	private ArrayList<String> screenRecordFilePathList=new ArrayList<String>();
	
	
	public String getLogcatFileName() {
		return logcatFileName;
	}
	public void setLogcatFileName(String logcatFileName) {
		this.logcatFileName = logcatFileName;
	}
	public int getMobileResultID() {
		return mobileResultID;
	}
	public void setMobileResultID(int mobileResultID) {
		this.mobileResultID = mobileResultID;
	}
	public String getCommandType() {
		return commandType;
	}
	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}
	public String getReturnFileType() {
		return returnFileType;
	}
	public void setReturnFileType(String returnFileType) {
		this.returnFileType = returnFileType;
	}
	
	public String getLogcatFileFullPath() {
		return logcatFileFullPath;
	}
	public void setLogcatFileFullPath(String logcatFileFullPath) {
		this.logcatFileFullPath = logcatFileFullPath;
	}
	public ArrayList<String> getScreenRecordFilePathList() {
		return screenRecordFilePathList;
	}
	public void setScreenRecordFilePathList(
			ArrayList<String> screenRecordFilePathList) {
		this.screenRecordFilePathList = screenRecordFilePathList;
	}
	
	
}
