package bean;

import java.io.PrintWriter;
import java.util.Scanner;

//�����������ʵ�ֲ���ѡ�ֵĻ�����Ϣ�ĳ�ʼ������д


public class Contestant {
	private String studentId;//ѧ��
	private String name;//����
	private String sex;//�Ա�
	private String classes;//�༶
	private String profession;//רҵ
	
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
	
	//��д����
	
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
