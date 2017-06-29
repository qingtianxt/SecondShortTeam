package bean;

import java.io.PrintWriter;
import java.util.Scanner;

//这个方法用来实现参赛选手的基本信息的初始化，读写


public class Contestant {
	private String studentId;//学号
	private String name;//姓名
	private String sex;//性别
	private String classes;//班级
	private String profession;//专业
	
	public Contestant(){
		
	}
	public Contestant(String studentId,String name,String sex,String classes,String profession){
			this.studentId = studentId;
			this.name = name;
			this.sex= sex;
			this.classes = classes;
			this.profession = profession;
		}
	
	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getClasses() {
		return classes;
	}


	public void setClasses(String classes) {
		this.classes = classes;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	@Override
	public String toString() {
		return "ContestantInfo [studentId=" + studentId + ", name=" + name + ", sex=" + sex + ", classes=" + classes
				+ ", profession=" + profession + "]";
	}
	
	//读写操作
	
	public void writeData(PrintWriter out){
		out.println(studentId+" "+name+" "+sex+" "+classes+" "+profession);
	}
	
	public void readData(Scanner sc){
		this.studentId = sc.next();
		this.name = sc.next();
		this.sex = sc.next();
		this.classes = sc.next();
		this.profession = sc.next();
	}
	
}
