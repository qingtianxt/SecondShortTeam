package bean;

import java.util.List;

public class unitGrade {
	private String num;// 对按单位排序的成绩单进行编号
	private String name;// 单位名
	private List<totalClass> list; // 将所有相同单位成绩单的信息放到这个list中
	private int grade;// 总成绩
	private int order;// 排名

	

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
