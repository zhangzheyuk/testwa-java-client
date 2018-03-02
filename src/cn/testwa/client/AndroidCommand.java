package cn.testwa.client;
/**
 * 
 * 〈
 * 〈CtsMonkey与testwa交互的动作Json协议〉
 *
 * @author 
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AndroidCommand {
	/** 新增步骤类型，用于区分是StepMonkey or StepAuto，静态值定义在TeaConstants中*/
	private String stepType;
	private String actionType;
	private String actionMessage;
	private String packageName;
	private String commandType;
	private String atcServerIp;
	/** 新增步骤执行结果，Monkey步骤只要下发出去，就默认为Succces，静态值定义在：TeaDaoStatic中*/
	private String testStepResult;
	/** 每个Step关联的截图，最终上报平台时，需要通过WebDav上传，生成URL连接*/
	private String relateImage;
	private int mobileResultID;
	private String udid;
	private String intervalTime;
	
	public String getAtcServerIp() {
		return atcServerIp;
	}
	public void setAtcServerIp(String atcServerIp) {
		this.atcServerIp = atcServerIp;
	}
	public int getMobileResultID() {
		return mobileResultID;
	}
	public void setMobileResultID(int mobileResultID) {
		this.mobileResultID = mobileResultID;
	}
	public String getUdid() {
		return udid;
	}
	public void setUdid(String udid) {
		this.udid = udid;
	}
	public String getRelateImage() {
		return relateImage;
	}
	public void setRelateImage(String relateImage) {
		this.relateImage = relateImage;
	}
	public String getTestStepResult() {
		return testStepResult;
	}
	public void setTestStepResult(String testStepResult) {
		this.testStepResult = testStepResult;
	}
	public String getStepType() {
		return stepType;
	}
	public void setStepType(String stepType) {
		this.stepType = stepType;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getActionMessage() {
		return actionMessage;
	}
	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getCommandType() {
		return commandType;
	}
	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}
	public String getIntervalTime() {
		return intervalTime;
	}
	public void setIntervalTime(String intervalTime) {
		this.intervalTime = intervalTime;
	}
}
