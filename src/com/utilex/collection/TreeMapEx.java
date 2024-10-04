package com.utilex.collection;

import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMapEx {
	public static void main(String[] args) {
		//TreeMap 의 정렬 기준은 key 를 기준으로 함.
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		
		tm.put("jae", 90);
		tm.put("neung", 91);
		tm.put("i", 92);
		tm.put("a", 93);
		tm.put("gga", 94);
		tm.put("wo", 95);
		
		Set<Entry<String, Integer>> entSet = tm.entrySet();
		for(Entry<String, Integer> entry : entSet) {
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}
		
		System.out.println("=============================");
		
		Entry<String, Integer> entry = tm.firstEntry();
		
		System.out.println(entry.getKey() + entry.getValue());
	}
}
