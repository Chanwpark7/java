package com.utilex.collection;

import java.util.Stack;

public class StackExam {
	public static void main(String[] args) {
		Stack<String> st = new Stack<String>();
		
		st.push("1");
		st.push("2");
		st.push("3");
		st.push("4");
		st.push("5");
		
		System.out.println(st);
		
		System.out.println(st.get(0));
		
		while(!st.isEmpty()) {
			System.out.println(st.pop());
			System.out.println(st);
		}
	}
}
