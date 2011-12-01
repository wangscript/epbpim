package com.ryxx.bpim.user.action.main;

import java.util.Comparator;

import com.ryxx.bpim.user.entity.AdminMenu;

public class MyComparator implements Comparator{
	public int compare(Object o1, Object o2){
		AdminMenu m1 = (AdminMenu)o1;
		AdminMenu m2 = (AdminMenu)o2;
		if(m1.getId() < m2.getId()){
			return -1;
		}else if(m1.getId() == m2.getId()){
			return 0;
		}else{
			return 1;
		}
	}
}
