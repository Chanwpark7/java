package com.langex;

public class StringBuilderEx {
	public static void main(String[] args) {
		String data = new StringBuilder()
			//메소드 체이닝. 메소드의 리턴이 뭕 ㅣ알고 잇는 경우 메소드만 연속으로 호출해서 코딩하는 기법
			.append("DEF")
			.insert(0, "ABC")
			.delete(3, 4)
			.toString();
		
		
		System.out.println(data);
	}
}
