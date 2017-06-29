package bean;

import java.io.PrintWriter;
import java.util.Scanner;

//这个类用来实现参赛单位的基本信息的初始化，读写

public class department {
	private String departmentNum;//部门编号
	private String departmentName;//部门名
	private String contestantsNum;//参赛人数
	
	public department(){
		
	}
	
	public department(String departmentNum,String departmentName,String contestantsNum){
		this.departmentNum = departmentNum;
		this.departmentName = departmentName;
		this.contestantsNum = contestantsNum;
	}
	
	
	public String getDepartmentNum() {
		return departmentNum;
	}
	public void setDepartmentNum(String departmentNum) {
		this.departmentNum = departmentNum;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getContestantsNum() {
		return contestantsNum;
	}
	public void setContestantsNum(String contestantsNum) {
		this.contestantsNum = contestantsNum;
	}
	
	@Override
	public String toString() {
		return "department [departmentNum=" + departmentNum + ", departmentName=" + departmentName + ", contestantsNum="
				+ contestantsNum + "]";
	}

	//读写一行
	public void writeData(PrintWriter out){
		out.println(departmentNum+" "+departmentName+" "+contestantsNum);
	}
	
	public void readData(Scanner sc){
		this.departmentNum = sc.next();
		this.departmentName = sc.next();
		this.contestantsNum = sc.next();
	}
}
