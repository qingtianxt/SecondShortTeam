package bean;

import java.util.List;
//用于所有相同比赛类型的成绩单的使用
public class EventTypeGrade {
	private String eventType;
	private List<totalClass> list; //将所有相同比赛类型的成绩单的信息放到这个list中
	
	public EventTypeGrade(){
		
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public List<totalClass> getList() {
		return list;
	}

	public void setList(List<totalClass> list) {
		this.list = list;
	}
	
}
