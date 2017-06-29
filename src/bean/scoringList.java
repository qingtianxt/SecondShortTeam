package bean;

import java.io.PrintWriter;
import java.util.Scanner;

//比赛得分清单的基本信息和读写
public class scoringList {
	private String studentId;//参赛选手的编号
	private String eventNum;//项目编号
	private int grade;//比赛得分
	private int matchOrder;//比赛排名
	public int getMatchOrder() {
		return matchOrder;
	}
	public void setMatchOrder(int matchOrder) {
		this.matchOrder = matchOrder;
	}
	public scoringList(){
		
	}
	public scoringList(String studentId,String eventNum,int grade,int matchOrder){
		this.studentId = studentId;
		this.eventNum = eventNum;
		this.grade = grade;
		this.matchOrder = matchOrder;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getEventNum() {
		return eventNum;
	}
	public void setEventNum(String eventNum) {
		this.eventNum = eventNum;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "scoringList [studentId=" + studentId + ", eventNum=" + eventNum + ", grade=" + grade + ", matchOrder="
				+ matchOrder + "]";
	}
	public void writeData(PrintWriter out){
		out.println(studentId+" "+eventNum+" "+grade+" "+matchOrder);
	}
	public void readData(Scanner sc){
		this.studentId = sc.next();
		this.eventNum = sc.next();
		this.grade = sc.nextInt();
		this.matchOrder = sc.nextInt();
	}
	
	
}
