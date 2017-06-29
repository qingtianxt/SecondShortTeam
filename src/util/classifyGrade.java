package util;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;

import bean.Contestant;
import bean.EventTypeGrade;
import bean.competitionEvent;
import bean.department;
import bean.totalClass;
import bean.unitGrade;

public class classifyGrade {
	
	public classifyGrade(){
		
	}
	
	public List<unitGrade> getListByunitGrade(){
		List<totalClass> list = totalClass.readtotalClass();
		List<department> list2 = FileIO.readDepartment();
		List<unitGrade> list3 = new ArrayList<>();
		
		for(int i=0;i<list2.size();i++){
			unitGrade u = new unitGrade();
			department d = list2.get(i);
			List<totalClass> tl = new ArrayList<>();
			u.setNum(d.getDepartmentNum());
			u.setName(d.getDepartmentName());
			int countgrade=0;//计算一个单位的总成绩
			for(totalClass t : list){
				if(t.getDepartmentNum().equals(d.getDepartmentNum())){
					countgrade +=t.getGrade();
					
					
					tl.add(t);
				}
			}
			u.setList(tl);
//			System.out.println(countgrade);
		
			u.setGrade(countgrade);
			
			
			
			list3.add(u);
		}
		List<unitGrade> list4 = orderbyunit(list3);
		return list4;
	}
	//根据比赛类型产生成绩单
	
	public List<EventTypeGrade> getListByEventTypeGrade(){
		List<totalClass> list = totalClass.readtotalClass();
		List<competitionEvent> list2 = FileIO.readCompetitionEvent();
		List<EventTypeGrade> list3 = new ArrayList<>();
		
		for(int i=0;i<list2.size();i++){
			EventTypeGrade u = new EventTypeGrade();
			competitionEvent d = list2.get(i);
			List<totalClass> tl = new ArrayList<>();
			
			u.setEventType(d.getEventName());
			for(totalClass t : list){
				if(t.getEventName().equals(d.getEventName())){
					tl.add(t);
				}
			}
			
			totalClass[] t2 = new totalClass[tl.size()];
			for(int j = 0;j < t2.length;j++){
				t2[j] = tl.get(j);
			}
			for(int j = 0;j < t2.length - 1;j++){
				for(int k = 0;k < t2.length - 1 - j;k++){
					if(t2[k].getGrade() < t2[k+1].getGrade()){
						totalClass t = t2[k];
						t2[k] = t2[k + 1];
						t2[k+1] = t;
					}
				}
			}
			List<totalClass> t3 = new ArrayList<>();
			for(int j = 0;j < t2.length;j++){
				t2[j].setOrder(j + 1);
				t3.add(t2[j]);
			}
			
			u.setList(t3);
			list3.add(u);
		}
		return list3;
	}
	/**
	 * 根据单位总成绩进行排序
	 * @param list
	 * @return
	 */
	public List<unitGrade> orderbyunit(List<unitGrade> list){
		List<unitGrade> list1 = new ArrayList<>();
		unitGrade[] u1 = new unitGrade[list.size()];
		for(int i = 0;i < list.size();i++){
			u1[i] = list.get(i);
		}
		for(int i=0;i<u1.length - 1;i++){
			for(int j=0;j<list.size() - i - 1;j++){
				if(u1[j].getGrade() < u1[j + 1].getGrade()){
					unitGrade t = u1[j];
					u1[j] = u1[j + 1];
					u1[j + 1] = t;
				}
			}
		}
		for(int i = 0;i < u1.length;i++){
			u1[i].setOrder(i + 1);
			list1.add(u1[i]);
		}
		return list1;
		
	}
	public List<totalClass> geren(List<totalClass> list,String name){
		List<totalClass> list1 = new ArrayList<totalClass>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getName().equals(name)){
				list1.add(list.get(i));
			}
		}
		return list1;
	}
	
}
