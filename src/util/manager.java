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
			System.out.println("��ӭʹ���˶���ɼ�����");
			System.out.println("------------------");
			System.out.println("1.����");
			System.out.println("2.��ѯ");
			System.out.println("3.�˳�");
			int sr = scan.nextInt();

			if (sr == 1) {
				System.out.println("��ѡ�����������");
				System.out.println("1.��Ŀ�嵥");
				System.out.println("2.����ѡ���嵥");
				System.out.println("3.������λ�嵥");
				System.out.println("4.�����÷��嵥");
//				System.out.println("5.����");

				int c1 = scan.nextInt();

				switch (c1) {
				case 1: {
					System.out.println("������������Ŀ����Ŀ��ţ���Ŀ������Ŀ��ţ���Ŀ����(���˻����Ŷ�)");

					competitionEvent cm = new competitionEvent();
					cm.setEventNum(scan.next());
					cm.setEventName(scan.next());
					cm.setEventSerialnumber(scan.next());
					cm.setEventCharacter((scan.next()));
					List<competitionEvent> list11 = FileIO.readCompetitionEvent();
					list11.add(cm);
					FileIO.writeCompetitionEvent(list11);
					System.out.println("�����Ŀ��Ϣ�ɹ�");
					break;
				}
				case 2: {
					System.out.println("���������ѡ�ֵ�ѧ�ţ��������Ա𣬰༶��רҵ");
					Contestant co = new Contestant();
					co.setStudentId(scan.next());
					co.setName(scan.next());
					co.setSex(scan.next());
					co.setClasses(scan.next());
					co.setProfession(scan.next());
					List<Contestant> list22 = FileIO.readConTestant();
					list22.add(co);
					FileIO.writeContestant(list22);
					System.out.println("��Ӳ���ѡ�ֳɹ�");
					break;
				}
				case 3: {
					System.out.println("�����������λ�Ĳ��ű�ţ��������Ͳ�������");
					department d = new department();
					d.setDepartmentNum(scan.next());
					d.setDepartmentName(scan.next());
					d.setContestantsNum(scan.next());
					List<department> list33 = FileIO.readDepartment();
					list33.add(d);
					FileIO.writeDepartment(list33);
					System.out.println("��Ӳ�����λ�ɹ�");
					break;
				}
				// 10,8,6,5,4,3,2,1
				// 20,16,12,10,8,6,4,2
				case 4: {
					System.out.println("����������ɼ���Ϣ��ѧ�ţ���Ŀ��źͳɼ�");
					scoringList sl = new scoringList();
					sl.setStudentId(scan.next());
					sl.setEventNum(scan.next());
					sl.setGrade(scan.nextInt());
					sl.setMatchOrder(getOrder(sl.getGrade()));
					List<scoringList> list44 = FileIO.readScoringList();
					list44.add(sl);
					FileIO.writeScoringList(list44);
					System.out.println("��ӳɼ��ɹ�");
					break;
				}
//				case 5:{
//					System.out.println("��������Ҫ������ѧ��ѧ�ź���Ŀ���");
//					baoming sl = new baoming();
//					sl.setStudentId(scan.next());
//					sl.setEventNum(scan.next());
//					List<baoming> list44 = FileIO.readbaoming();
//					list44.add(sl);
//					FileIO.writebaoming(list44);
//					System.out.println("��ӱ�����Ϣ�ɹ�");
//					
//					break;
//				}
				default:
					break;
				}
			} else if (sr == 2) {
				System.out.println("���������ѡ���ѯ����");
				System.out.println("1.��λ��ѯ");
				System.out.println("2.���˲�ѯ");
				System.out.println("3.�Ա��ѯ");
				System.out.println("4.��Ŀ���Ͳ�ѯ");

				int c1 = scan.nextInt();
				switch (c1) {
				case 1: {
					System.out.println("��ѡ����");
					System.out.println("-------------");
					System.out.println("1.���ݵ�λ��ʾ���еĳɼ�");
					System.out.println("2.���յ�λ���в�ѯ");
					int c2 = scan.nextInt();
					if (c2 == 1) {
						showbydepartment();
					} else {
						System.out.println("��������Ҫ��ѯ�ĵ�λ");
						String department = scan.next();

						selectbydepartment(department);
					}
					break;

				}
				case 2: {
					System.out.println("���������ѧ��");
					String studentId = scan.next();
					showbystudentId(studentId);
					break;
				}
				case 3: {
					System.out.println("��������Ҫ���ҵ��Ա�1,�У�2 Ů");
					int sex = scan.nextInt();
					showbysex(sex);
					break;
				}
				case 4: {
					System.out.println("��������Ҫ��ѯ�ķ�ʽ 1����ѯȫ�� 2����ѯ������Ŀ");
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
					System.out.println("�˳��ɹ�");
					break;
				}
				default: {
					System.out.println("�����������������");
				}
				}

			} else {
				ch = 's';
				System.out.println("�˳��ɹ�");
			}
		}

	}

	/**
	 * ������ɼ���ʱ�򣬸�����������
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
			System.out.println("��Ŀ��:"+eventGrade.getEventType());
			List<totalClass> list2 = eventGrade.getList();
			for (totalClass totalClass : list2) {
				System.out.println(totalClass.toString());
			}

		}
	}


	/**
	 * ������Ŀ������ʾ��Ϣ
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
				System.out.println("��Ŀ��:"+eventGrade.getEventType());
				List<totalClass> list2 = eventGrade.getList();
				for (totalClass totalClass : list2) {
					System.out.println(totalClass.toString());
				}
			}
		}
	}

	/**
	 * �����Ա���ʾ�ɼ���Ϣ
	 * 
	 * @param sex
	 */
	private static void showbysex(int sex) {
		List<totalClass> list = totalClass.readtotalClass();
		if(sex==1){
			System.out.println("���������гɼ�");
			for (totalClass c : list) {
				if(c.getSex().equals("��")){
					System.out.println(c.toString());
				}
			}
		}
		else{
			System.out.println("Ů�������гɼ�");
			for (totalClass c : list) {
				if(c.getSex().equals("Ů")){
					System.out.println(c.toString());
				}
			}
		}
	}

	/**
	 * ����ѧ�Ų�ѯ��Ϣ
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
	 * ���ҵ�����λ�ĳɼ���
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
				System.out.println("��λ���:" + unitGrade.getNum() + "\t��λ��:" + unitGrade.getName() + "\t�ܳɼ�:"
						+ unitGrade.getGrade() + "\t������" + unitGrade.getOrder());
				List<totalClass> list2 = unitGrade.getList();
				for (totalClass totalClass : list2) {
					System.out.println(totalClass.toString());
				}
				j++;
			}
			
		}
		
		if(j==0){
			System.out.println("û�������λ");
		}
	}

	/**
	 * ���ݵ�λ��ʾ���е�λ�ı����ɼ���
	 */
	private static void showbydepartment() {
		totalClass t1 = new totalClass();
		List<totalClass> list = t1.write();
		t1.writetotalClass(list);
		classifyGrade c = new classifyGrade();

		List<unitGrade> listByunitGrade = c.getListByunitGrade();
		for (unitGrade unitGrade : listByunitGrade) {
			System.out.println("��λ���:" + unitGrade.getNum() + "\t��λ��:" + unitGrade.getName() + "\t�ܳɼ�:"
					+ unitGrade.getGrade() + "\t������" + unitGrade.getOrder()+"\n");
			List<totalClass> list2 = unitGrade.getList();
			for (totalClass totalClass : list2) {
				System.out.println(totalClass.toString());
			}
			System.out.println("\n\n\n");
		}
		
	}
}
