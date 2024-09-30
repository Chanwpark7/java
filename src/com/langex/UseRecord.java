package com.langex;

public class UseRecord {
	public static void main(String[] args) {
		Member2 member = new Member2("Jason", "찬우", 52);
		System.out.println(member.id());
		System.out.println(member.name());
		System.out.println(member.age());
		System.out.println(member);
		
		System.out.println(member.toString());
	}
}
