package bean;

import java.util.List;
//����������ͬ�������͵ĳɼ�����ʹ��
public class EventTypeGrade {
	private String eventType;
	private List<totalClass> list; //��������ͬ�������͵ĳɼ�������Ϣ�ŵ����list��
	
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
