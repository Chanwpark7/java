package com.utilex.collection;
/*
 * Comparable 인터페이스 : 자바에서 정렬의 대상이 되려면 무조건 이 인터페이스를 구현해야 함.
 * String, Integer 등의 이 하위 타입이라 정렬이 가능했음.
 * 우리가 만든 클래스가 정렬의 기준이 되려면, 먼저 이 인터페이스를 구현 하고, compare()를 오버라이드 해줘야 함.
 * 이 때 정렬의 대상이 되는 필드의 값을 비교해서 리턴해주면 됨.
 * 리턴은 -1, 0, 1 임.
 */

import java.util.TreeSet;

class Person implements Comparable<Person>{
	public String name;
	public int score;
	
	public Person(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public int compareTo(Person person) {
		if(this.score < person.score) return -1;
		else if(this.score == person.score) return 0;
		else return 1;
	}
}

public class CompareEx1 {
	public static void main(String[] args) {
		TreeSet<Person> ts = new TreeSet<Person>();
		
		ts.add(new Person("아",(int)(Math.random()*100)));
		ts.add(new Person("오",(int)(Math.random()*100)));
		ts.add(new Person("짜",(int)(Math.random()*100)));
		ts.add(new Person("증",(int)(Math.random()*100)));
		ts.add(new Person("나",(int)(Math.random()*100)));
		ts.add(new Person("ㅡㅡ",(int)(Math.random()*100)));
		
		for(Person p : ts) {
			System.out.println(p.name+" : "+p.score);
		}
		
	}
}
