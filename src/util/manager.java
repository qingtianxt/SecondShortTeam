package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bean.Contestant;
import bean.EventTypeGrade;
import bean.baoming;
import bean.competitionEvent;
import bean.department;
import bean.scoringList;
import bean.totalClass;
import bean.unitGrade;

public class manager {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		char ch = 'x';
		while (ch == 'x') {
			System.out.println("欢迎使用运动会成绩管理");
			System.out.println("------------------");
			System.out.println("1.输入");
			System.out.println("2.查询");
			System.out.println("3.退出");
			int sr = scan.nextInt();

			if (sr == 1) {
				System.out.println("请选择输入的内容");
				System.out.println("1.项目清单");
				System.out.println("2.参赛选手清单");
				System.out.println("3.参赛单位清单");
				System.out.println("4.比赛得分清单");
//				System.out.println("5.报名");

				int c1 = scan.nextInt();

				switch (c1) {
				case 1: {
					System.out.println("请依次输入项目的项目编号，项目名，项目序号，项目类型(个人或者团队)");

					competitionEvent cm = new competitionEvent();
					cm.setEventNum(scan.next());
					cm.setEventName(scan.next());
					cm.setEventSerialnumber(scan.next());
					cm.setEventCharacter((scan.next()));
					List<competitionEvent> list11 = FileIO.readCompetitionEvent();
					list11.add(cm);
					FileIO.writeCompetitionEvent(list11);
					System.out.println("添加项目信息成功");
					break;
				}
				case 2: {
					System.out.println("请输入参赛选手的学号，姓名，性别，班级和专业");
					Contestant co = new Contestant();
					co.setStudentId(scan.next());
					co.setName(scan.next());
					co.setSex(scan.next());
					co.setClasses(scan.next());
					co.setProfession(scan.next());
					List<Contestant> list22 = FileIO.readConTestant();
					list22.add(co);
					FileIO.writeContestant(list22);
					System.out.println("添加参赛选手成功");
					break;
				}
				case 3: {
					System.out.println("请输入参赛单位的部门编号，部门名和参赛人数");
					department d = new department();
					d.setDepartmentNum(scan.next());
					d.setDepartmentName(scan.next());
					d.setContestantsNum(scan.next());
					List<department> list33 = FileIO.readDepartment();
					list33.add(d);
					FileIO.writeDepartment(list33);
					System.out.println("添加参赛单位成功");
					break;
				}
				// 10,8,6,5,4,3,2,1
				// 20,16,12,10,8,6,4,2
				case 4: {
					System.out.println("请输入参赛成绩信息的学号，项目编号和成绩");
					scoringList sl = new scoringList();
					sl.setStudentId(scan.next());
					sl.setEventNum(scan.next());
					sl.setGrade(scan.nextInt());
					sl.setMatchOrder(getOrder(sl.getGrade()));
					List<scoringList> list44 = FileIO.readScoringList();
					list44.add(sl);
					FileIO.writeScoringList(list44);
					System.out.println("添加成绩成功");
					break;
				}
//				case 5:{
//					System.out.println("请输入需要报名的学生学号和项目编号");
//					baoming sl = new baoming();
//					sl.setStudentId(scan.next());
//					sl.setEventNum(scan.next());
//					List<baoming> list44 = FileIO.readbaoming();
//					list44.add(sl);
//					FileIO.writebaoming(list44);
//					System.out.println("添加报名信息成功");
//					
//					break;
//				}
				default:
					break;
				}
			} else if (sr == 2) {
				System.out.println("请输入序号选择查询类型");
				System.out.println("1.单位查询");
				System.out.println("2.个人查询");
				System.out.println("3.性别查询");
				System.out.println("4.项目类型查询");

				int c1 = scan.nextInt();
				switch (c1) {
				case 1: {
					System.out.println("请选择功能");
					System.out.println("-------------");
					System.out.println("1.根据单位显示所有的成绩");
					System.out.println("2.按照单位进行查询");
					int c2 = scan.nextInt();
					if (c2 == 1) {
						showbydepartment();
					} else {
						System.out.println("请输入需要查询的单位");
						String department = scan.next();

						selectbydepartment(department);
					}
					break;

				}
				case 2: {
					System.out.println("请输入你的学号");
					String studentId = scan.next();
					showbystudentId(studentId);
					break;
				}
				case 3: {
					System.out.println("请输入需要查找的性别：1,男，2 女");
					int sex = scan.nextInt();
					showbysex(sex);
					break;
				}
				case 4: {
					System.out.println("请输入需要查询的方式 1，查询全部 2，查询单个项目");
					int choose = scan.nextInt();
					if(choose==1){
						showevent();	
						
					}
					else{
						String type = scan.next();
						showbyeventType(type);
					}
					break;
				}
				case 5: {
					ch = 'y';
					System.out.println("退出成功");
					break;
				}
				default: {
					System.out.println("输入错误，请重新输入");
				}
				}

			} else {
				ch = 's';
				System.out.println("退出成功");
			}
		}

	}

	/**
	 * 当输入成绩的时候，给出他的排名
	 * 
	 * @param grade
	 * @return
	 */
	private static int getOrder(int grade) {
		int a1[] = { 10, 8, 6, 5, 4, 3, 2, 1 };
		int z = 0;
		for (int i = 0; i < 8; i++) {
			if (grade == a1[i]) {
				z = i + 1;
			}
		}
		return z;
	}

	
	private static void showevent() {
		totalClass t1 = new totalClass();
		List<totalClass> list = t1.write();
		t1.writetotalClass(list);
		classifyGrade c = new classifyGrade();
		
		List<EventTypeGrade> listByEventGrade = c.getListByEventTypeGrade();
		for (EventTypeGrade eventGrade : listByEventGrade) {
			System.out.println("项目名:"+eventGrade.getEventType());
			List<totalClass> list2 = eventGrade.getList();
			for (totalClass totalClass : list2) {
				System.out.println(totalClass.toString());
			}

		}
	}


	/**
	 * 根据项目类型显示信息
	 * 
	 * @param type
	 */
	private static void showbyeventType(String type) {
		totalClass t1 = new totalClass();
		List<totalClass> list = t1.write();
		t1.writetotalClass(list);
		classifyGrade c = new classifyGrade();
		
		List<EventTypeGrade> listByEventGrade = c.getListByEventTypeGrade();
		for (EventTypeGrade eventGrade : listByEventGrade) {
			if(type.equals(eventGrade.getEventType()))
			{
				System.out.println("项目名:"+eventGrade.getEventType());
				List<totalClass> list2 = eventGrade.getList();
				for (totalClass totalClass : list2) {
					System.out.println(totalClass.toString());
				}
			}
		}
	}

	/**
	 * 根据性别显示成绩信息
	 * 
	 * @param sex
	 */
	private static void showbysex(int sex) {
		List<totalClass> list = totalClass.readtotalClass();
		if(sex==1){
			System.out.println("男生的所有成绩");
			for (totalClass c : list) {
				if(c.getSex().equals("男")){
					System.out.println(c.toString());
				}
			}
		}
		else{
			System.out.println("女生的所有成绩");
			for (totalClass c : list) {
				if(c.getSex().equals("女")){
					System.out.println(c.toString());
				}
			}
		}
	}

	/**
	 * 根据学号查询信息
	 * 
	 * @param studentId
	 */
	private static void showbystudentId(String studentId) {
		List<totalClass> list = totalClass.readtotalClass();
		for (totalClass c : list) {
			if(c.getStudentId().equals(studentId)){
				System.out.println(c.toString());
			}
		}
	}

	/**
	 * 查找单个单位的成绩单
	 * 
	 * @param department
	 */
	private static void selectbydepartment(String department) {
		totalClass t1 = new totalClass();
		List<totalClass> list = t1.write();
		t1.writetotalClass(list);
		classifyGrade c = new classifyGrade();

		List<unitGrade> listByunitGrade = c.getListByunitGrade();
		
		int j=0;
		for (unitGrade unitGrade : listByunitGrade) {
			if (unitGrade.getName().equals(department)) {
				System.out.println("单位编号:" + unitGrade.getNum() + "\t单位名:" + unitGrade.getName() + "\t总成绩:"
						+ unitGrade.getGrade() + "\t总名次" + unitGrade.getOrder());
				List<totalClass> list2 = unitGrade.getList();
				for (totalClass totalClass : list2) {
					System.out.println(totalClass.toString());
				}
				j++;
			}
			
		}
		
		if(j==0){
			System.out.println("没有这个单位");
		}
	}

	/**
	 * 根据单位显示所有单位的比赛成绩单
	 */
	private static void showbydepartment() {
		totalClass t1 = new totalClass();
		List<totalClass> list = t1.write();
		t1.writetotalClass(list);
		classifyGrade c = new classifyGrade();

		List<unitGrade> listByunitGrade = c.getListByunitGrade();
		for (unitGrade unitGrade : listByunitGrade) {
			System.out.println("单位编号:" + unitGrade.getNum() + "\t单位名:" + unitGrade.getName() + "\t总成绩:"
					+ unitGrade.getGrade() + "\t总名次" + unitGrade.getOrder()+"\n");
			List<totalClass> list2 = unitGrade.getList();
			for (totalClass totalClass : list2) {
				System.out.println(totalClass.toString());
			}
			System.out.println("\n\n\n");
		}
		
	}
}
