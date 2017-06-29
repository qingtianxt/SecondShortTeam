package bean;

import java.io.PrintWriter;
import java.util.Scanner;

//参赛项目的基本信息和读写
public class competitionEvent {
	private String eventNum;//项目编号
	private String eventName;//项目名
	private String eventSerialnumber;//项目序号，也就是比赛的顺序
	private String eventType;//项目的类型，例如田径等项目
	private String eventCharacter;//比赛的性质，是个人或者是团体
	
	public competitionEvent(){
		
	}
	public competitionEvent(String eventNum,String eventName,String eventSerialnumber,String eventType,String eventCharacter){
			this.eventNum = eventNum;
			this.eventName = eventName;
			this.eventSerialnumber = eventSerialnumber;
			this.eventType = eventType;
			this.eventCharacter = eventCharacter;
	}
	public String getEventNum() {
		return eventNum;
	}
	public void setEventNum(String eventNum) {
		this.eventNum = eventNum;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventSerialnumber() {
		return eventSerialnumber;
	}
	public void setEventSerialnumber(String eventSerialnumber) {
		this.eventSerialnumber = eventSerialnumber;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventCharacter() {
		return eventCharacter;
	}
	public void setEventCharacter(String eventCharacter) {
		this.eventCharacter = eventCharacter;
	}
	

	public void writeData(PrintWriter out){
		out.println(eventNum+" "+eventName+" "+eventSerialnumber+" "+eventType+" "+eventCharacter);
	}
	public void readData(Scanner sc){
		this.eventNum = sc.next();
		this.eventName = sc.next();
		this.eventSerialnumber = sc.next();
		this.eventType = sc.next();
		this.eventCharacter = sc.next();
	}
}
