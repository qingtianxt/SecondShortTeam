package bean;

import java.io.PrintWriter;
import java.util.Scanner;

//���������ʵ�ֲ�����λ�Ļ�����Ϣ�ĳ�ʼ������д

public class department {
	private String departmentNum;//���ű��
	private String departmentName;//������
	private String contestantsNum;//��������
	
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

	//��дһ��
	public void writeData(PrintWriter out){
		out.println(departmentNum+" "+departmentName+" "+contestantsNum);
	}
	
	public void readData(Scanner sc){
		this.departmentNum = sc.next();
		this.departmentName = sc.next();
		this.contestantsNum = sc.next();
	}
}
