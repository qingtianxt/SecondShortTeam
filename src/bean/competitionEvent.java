package bean;

import java.io.PrintWriter;
import java.util.Scanner;

//������Ŀ�Ļ�����Ϣ�Ͷ�д
public class competitionEvent {
	private String eventNum;//��Ŀ���
	private String eventName;//��Ŀ��
	private String eventSerialnumber;//��Ŀ��ţ�Ҳ���Ǳ�����˳��
	private String eventType;//��Ŀ�����ͣ������ﾶ����Ŀ
	private String eventCharacter;//���������ʣ��Ǹ��˻���������
	
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
