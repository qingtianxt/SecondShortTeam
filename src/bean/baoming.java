package bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baoming {
	private String studentId;//����ѡ�ֵı��
	private String eventNum;//��Ŀ���
	private String date;//��������
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "baoming [studentId=" + studentId + ", eventNum=" + eventNum + ", date=" + date + "]";
	}
	public void  writedata(PrintWriter out){
		out.print(studentId+" "+eventNum+" "+date);
	}
	public void readdata(Scanner sc){
		this.studentId = sc.next();
		this.eventNum =sc.next();
		this.date = sc.next();
	}
	
	
	
	//������Ϣ�Ķ�д
		public static List<baoming> readbaoming() {
			List<baoming> list = new ArrayList<>();
			File f = new File("baoming.txt");

			if (!f.exists()) {
				// �ļ�������
				writebaoming(list);
				return list;
			}
			Scanner scan;
			try {
				scan = new Scanner(f);
				String nStr = scan.nextLine();
				int n = Integer.parseInt(nStr);
				for (int i = 0; i < n; i++) {
					baoming c = new baoming();
					c.readdata(scan);
					list.add(c);
				}
				scan.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		public static void writebaoming(List<baoming> list) {
			File f = new File("baoming.txt");

			if (!f.exists()) {
				// �ļ�������
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
					list.get(i).writedata(out);
				}
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
//		
//		public List<baoming> write(){
//			
//		}
}
