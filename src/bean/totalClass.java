package bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.FileIO;
import util.classifyGrade;

public class totalClass {
	private String eventNum;//项目编号
	private String eventName;//项目名
	private String departmentNum;//部门编号
	private String departmentName;//部门名
	private String studentId;//学号
	private int order;//名次
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	private String name;//姓名
	private String sex;//性别
	private int grade;//成绩
	private String eventType;//项目的类型，例如个人或者团体

	public totalClass(){
		
	}
	
	public totalClass(String eventNum,String eventName,String departmentNum,String departmentName,String studentId,String name,String sex,int grade,String eventType,int order)
	{
		this.eventNum = eventNum;
		this.eventName = eventName;
		this.eventType = eventType;
		this.departmentNum = departmentNum;
		this.departmentName = departmentName;
		this.studentId = studentId;
		this.name =name;
		this.sex = sex;
		this.grade = grade;
		this.order  = order;
		
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
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	
	

	@Override
	public String toString() {
		return "项目编号:" + eventNum + ", 项目名:" + eventName + ",单位编号:" + departmentNum
				+ ", 单位名:" + departmentName + ", 参赛选手学号:" + studentId + ",姓名:"
				+ name + ", 性别:" + sex + ",成绩:" + grade + ", 名次:" + order +", 参赛类型:" + eventType;
	}

	
	public void readData(Scanner sc){
		this.eventNum = sc.next();
		this.eventName = sc.next();
		this.eventType = sc.next();
		this.departmentNum = sc.next();
		this.departmentName = sc.next();
		this.studentId = sc.next();
		this.name =sc.next();
		this.sex = sc.next();
		this.grade = sc.nextInt();
		this.order = sc.nextInt();
	}
//	@Override
//	public String toString() {
//		return "totalClass [eventNum=" + eventNum + ", eventName=" + eventName + ", departmentNum=" + departmentNum
//				+ ", departmentName=" + departmentName + ", studentId=" + studentId + ", order=" + order + ", name="
//				+ name + ", sex=" + sex + ", grade=" + grade + ", eventType=" + eventType + "]";
//	}

	public void writeData(PrintWriter out){
		out.println(eventNum+" "+eventName+" "+eventType+" "+departmentNum+" "+departmentName+" "+studentId+" "+name+" "+sex+" "+grade+" "+order);
	}
	//成绩总单
	public static List<totalClass> readtotalClass() {
		List<totalClass> list = new ArrayList<>();
		File f = new File("totalClass.txt");

		if (!f.exists()) {
			// 文件不存在
			writetotalClass(list);
			return list;
		}
		Scanner scan;
		try {
			scan = new Scanner(f);
			String nStr = scan.nextLine();
			int n = Integer.parseInt(nStr);
			for (int i = 0; i < n; i++) {
				totalClass c = new totalClass();
				c.readData(scan);
				list.add(c);
			}
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//成绩单	2.写入的方法：调用3中的list，将内容写入到文件中
	public static void writetotalClass(List<totalClass> list) {
		File f = new File("totalClass.txt");

		if (!f.exists()) {
			// 文件不存在
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			PrintWriter out = new PrintWriter(f);
			out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				list.get(i).writeData(out);
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//3.获取list（成绩总单）
	//思路：通过文件读入从各个表中找出有用的数据，将数据匹配以后放到成绩总单中
	public List<totalClass> write(){
		List<totalClass> list = new ArrayList<>();
		List<Contestant> list1 = new ArrayList<>();
		List<department> list2 = new ArrayList<>();
		List<competitionEvent> list3 = new ArrayList<>();
		List<scoringList> list4 = new ArrayList<>();
		
		list1= FileIO.readConTestant();
		list2= FileIO.readDepartment();
		list3=FileIO.readCompetitionEvent();
		list4=FileIO.readScoringList();
		
		//最外层遍历（参赛成绩表的遍历）
		for(int i=0;i<list4.size();i++){
			totalClass t1 = new totalClass();
			
			//内层遍历1 参赛成绩的项目编号和参赛项目的编号是一致的
			for(int j=0;j<list3.size();j++){
				if(list3.get(j).getEventNum().equals(list4.get(i).getEventNum())){
					t1.setEventNum(list3.get(j).getEventNum());
					t1.setEventName(list3.get(j).getEventName());
					t1.setEventType(list3.get(j).getEventCharacter());
					t1.setOrder(list4.get(i).getMatchOrder());
				}
			}
			
			//内层遍历2 参赛选手的学号和参赛成绩的学生的学号是一致的
			for(int j=0;j<list1.size();j++){
				if(list1.get(j).getStudentId().equals(list4.get(i).getStudentId())){
					t1.setStudentId(list1.get(j).getStudentId());
					t1.setName(list1.get(j).getName());
					t1.setSex(list1.get(j).getSex());
					
					
					//内层遍历3 由参赛选手的基本信息表 找到所在单位的信息
					for(int k=0;k<list2.size();k++){
						if(list2.get(k).getDepartmentName().equals(list1.get(j).getProfession())){
							t1.setDepartmentName(list2.get(k).getDepartmentName());
							t1.setDepartmentNum(list2.get(k).getDepartmentNum());
						}
					}
				}
			}
			//判断如果以上所有的信息不为空，添加上成绩,将该条信息添加到成绩总表中
			if(t1.getDepartmentNum()!=null&&t1.getEventNum()!=null&&t1.getStudentId()!=null){
				t1.setGrade(list4.get(i).getGrade());
			}
			
			list.add(t1);
			
			
		}
		
		
		
		return list;
	}
}
