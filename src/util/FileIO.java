package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bean.Contestant;
import bean.baoming;
import bean.competitionEvent;
import bean.department;
import bean.scoringList;

public class FileIO {
	public static void main(String[] args) {
		 readConTestant();
	}
	
	
	
	
	
	
	//����ѡ�ֻ�����Ϣ�Ķ�д
	public static List<Contestant> readConTestant() {
		List<Contestant> list = new ArrayList<>();
		File f = new File("Contestant.txt");

		if (!f.exists()) {
			// �ļ�������
			writeContestant(list);
			return list;
		}
		Scanner scan;
		try {
			scan = new Scanner(f);
			String nStr = scan.nextLine();
			int n = Integer.parseInt(nStr);
			for (int i = 0; i < n; i++) {
				Contestant c = new Contestant();
				c.readData(scan);
				list.add(c);
			}
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void writeContestant(List<Contestant> list) {
		File f = new File("Contestant.txt");

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
				list.get(i).writeData(out);
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//��ص�λ������Ϣ�Ķ�д
		public static List<department> readDepartment() {
			List<department> list = new ArrayList<>();
			File f = new File("department.txt");

			if (!f.exists()) {
				// �ļ�������
				writeDepartment(list);
				return list;
			}
			Scanner scan;
			try {
				scan = new Scanner(f);
				String nStr = scan.nextLine();
				int n = Integer.parseInt(nStr);
				for (int i = 0; i < n; i++) {
					department c = new department();
					c.readData(scan);
					list.add(c);
				}
				scan.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		public static void writeDepartment(List<department> list) {
			File f = new File("department.txt");

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
					list.get(i).writeData(out);
				}
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		
		//������Ŀ������Ϣ�Ķ�д
				public static List<competitionEvent> readCompetitionEvent() {
					List<competitionEvent> list = new ArrayList<>();
					File f = new File("competitionEvent.txt");

					if (!f.exists()) {
						// �ļ�������
						writeCompetitionEvent(list);
						return list;
					}
					Scanner scan;
					try {
						scan = new Scanner(f);
						String nStr = scan.nextLine();
						int n = Integer.parseInt(nStr);
						for (int i = 0; i < n; i++) {
							competitionEvent c = new competitionEvent();
							c.readData(scan);
							list.add(c);
						}
						scan.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					return list;
				}

				public static void writeCompetitionEvent(List<competitionEvent> list) {
					File f = new File("competitionEvent.txt");

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
							list.get(i).writeData(out);
						}
						out.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				
				
				//�����嵥������Ϣ�Ķ�д
						public static List<scoringList> readScoringList() {
							List<scoringList> list = new ArrayList<>();
							File f = new File("scoringList.txt");

							if (!f.exists()) {
								// �ļ�������
								writeScoringList(list);
								return list;
							}
							Scanner scan;
							try {
								scan = new Scanner(f);
								String nStr = scan.nextLine();
								int n = Integer.parseInt(nStr);
								for (int i = 0; i < n; i++) {
									scoringList c = new scoringList();
									c.readData(scan);
									list.add(c);
								}
								scan.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
							return list;
						}

						public static void writeScoringList(List<scoringList> list) {
							File f = new File("scoringList.txt");

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
									list.get(i).writeData(out);
								}
								out.close();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
						}
				
						
	
}