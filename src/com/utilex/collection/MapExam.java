package com.utilex.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Map 타입 : Key = value 로 객체로 저장. 키가 중복되면 value 를 덮어쓰는 특징을 갖고 있음.
 * 대표적인 구현체(구현클래스)로는 HashMap, HashTable 이 있으며, thread 와 연관이 없는 경우엔 HashMap을,
 * 연관이 있다면 Table을 사용.
 */
public class MapExam {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("아", 94);
		map.put("오", 99);
		map.put("거", 98);
		map.put("지", 97);
		map.put("같", 96);
		map.put("네", 95);
		map.put("아", 99);
		
		System.out.println("저장된 객체 "+ map.size());
		System.out.println(map.get("아"));
		
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Integer v = map.get(key);
			System.out.println("key "+key+" value "+v);
		}
		
		Set<Entry<String, Integer>> ent =  map.entrySet();
		Iterator<Entry<String, Integer>> itr = ent.iterator();
		while(itr.hasNext()) {
			Entry<String, Integer> entry = itr.next();
			String key = entry.getKey();
			Integer v = entry.getValue();
			System.out.println(key+" : "+v);
		}
	}
}
