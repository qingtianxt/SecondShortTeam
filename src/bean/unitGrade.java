package bean;

import java.util.List;

public class unitGrade {
	private String num;// �԰���λ����ĳɼ������б��
	private String name;// ��λ��
	private List<totalClass> list; // ��������ͬ��λ�ɼ�������Ϣ�ŵ����list��
	private int grade;// �ܳɼ�
	private int order;// ����

	

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<totalClass> getList() {
		return list;
	}

	public void setList(List<totalClass> list) {
		this.list = list;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}


}
