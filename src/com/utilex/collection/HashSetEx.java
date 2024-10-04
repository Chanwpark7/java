package com.utilex.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Student{//학생 클래스 정의
	//각 학생은 고유한 객체이기 때문에, 객체가 공통으로 갖는 속성(값은 다름) 을 정의함.
	public String name;
	public String stnNum;
	
	public Student(String name, String stnNum) {
		this.name = name;
		this.stnNum = stnNum;
	}
	
	//학번이 같으면 Set에 저장하지 않도록 정의할 예정.
	//이때 학번의 해쉬를 얻어서 확인하도록 오버라이드
	@Override
	public int hashCode() {
		return stnNum.hashCode();
	}
	
	//객체가 들어갈때 학번이 같은지를 검증해야 하기 때문에 object의 equals 를 오버라이드해서
	//해당 객체의 학번이 같으면 true 를 리턴.
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student st) {
			return st.stnNum.equals(this.stnNum);
		}else {
			return false;
		}
	}
}

public class HashSetEx {
	public static void main(String[] args) {
		//사용자 객체의 특정 필드값이 같은 경우엔 중복 저장 않는 set 생성.
		Set<Student> studentSet = new HashSet<Student>();
		
		//학생 둘 생성 후 add
		Student st1 = new Student("하", "132");
		Student st2 = new Student("짜", "123");
		Student st3 = new Student("증", "132");
		Student st4 = new Student("나", "123");
		Student st5 = new Student("네", "132");
		
		studentSet.add(st1);
		studentSet.add(st2);
		studentSet.add(st3);
		studentSet.add(st4);
		studentSet.add(st5);
		
		System.out.println(studentSet.size());
		
		Set<String> set = new HashSet();
		
		set.add("JAVA");
		set.add("JSP");
		set.add("Spring");
		set.add("java");
		set.add("JAVA");
		
		System.out.println(set.size());
		
		/*
		 * Iterator : 내부 순환자 객체. 순서없이 객체를 저장하는 컬렉션의 일종.
		 * 배열형식의 데이터 저장이 아니기 때문에 끝을 알 수 없음. 당연히 index도 없음.
		 * 따라서 요소가 존재하는지 여부를 리ㅓㄴ하는 메소드와 요소를 반환하는 메소드를 통해서
		 * 각 요소를 get 할 수 있음.
		 */
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String ele = itr.next();
			System.out.println(ele);
		}
		
		List<String> list = new ArrayList<String>(set);
		System.out.println(list);
	}
}
