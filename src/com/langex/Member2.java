package com.langex;
/* 
 * DTO (Data Transfer Object)
 * 자바를 이용해서 DB 작업을 할때, 데이터를 갖고있는 실제 객체를 통틀어 DTO 라고 함.
 * 이 DTO 가 여러 자바 프레임워크에서 사용되다 보니, 이에 대응해서 Record 라는 타입을 지원함.
 * 하지만 실제 업무에서는 이 레코드보다 DTO 를 더 많이 사용함.
 */
public record Member2(String id, String name, int age) {
	
}
