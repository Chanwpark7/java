package com.utilex.collection;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetEx {
	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		ts.add((int)(Math.random()*100));
		ts.add((int)(Math.random()*100));
		ts.add((int)(Math.random()*100));
		ts.add((int)(Math.random()*100));
		ts.add((int)(Math.random()*100));
		ts.add((int)(Math.random()*100));
		ts.add((int)(Math.random()*100));
		ts.add((int)(Math.random()*100));
		ts.add((int)(Math.random()*100));
		ts.add((int)(Math.random()*100));
		
		for(Integer s : ts) {
			System.out.println(s);
		}
		
		System.out.println(ts.first());
		System.out.println(ts.last());
		System.out.println("특정 범위 아래 : "+ts.lower(80));
		System.out.println("특정 범위 위 : "+ts.higher(80));
		
		NavigableSet<Integer> nvs =  ts.descendingSet();
		
		for(Integer s : nvs) {
			System.out.println(s);
		}
		System.out.println("=======================");
		
		//특정범위 검색
		nvs = ts.subSet(50, true, 80, false);
		for(Integer s : nvs) {
			System.out.println(s);
		}
	}
}
