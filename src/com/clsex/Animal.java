package com.clsex;

//이 클래스는 개, 고양이, 오리의 부모 클래스로 정의될 예정.
//원래는 부모 클래스를 먼저 정의하고 자식을 확장(extends) 해야 하는데, 강의 흐름상 거꾸로 함.
/*
 * 상송(Inheritance) : 객체 지향에서 상속은 매우 중요.
 * 상속은 기본적으로 부모가 가진 모든것을 자식이 내려받는 형태. 하지만 내려받는 것중 안되는것이 있는데,
 * 1. 생성자는 상속이 되지 않음.
 * 2. private 으로 선언된 것 또한 상속되지 않음.(정확히는 접근 불가)
 * 
 * 이외에는 모두 상속을 받음.
 * 
 * 상속이라는 개념은 실제적으로 확장이라는 개념으로 생각해야 편함.
 * 부모가 가진 속성과 메소드 외에 나중에 추가될 속성과 메소드가 있다면 기존 클래스를 뜯어 고치는게 아니라, 연관성이 분명 하다면
 * 상속을 통해 자식이 그 확장 개념을 정의 한다라고 생각하면 편함.
 * 
 * 이렇게 상속을 통해 클래스를 확장할 수 있는데, 하나의 부모는 하나 이상의 자식 클래스를 둘 수 있지만, 자식은 반드시 하나의 부모 클래스만
 * 상속 받을 수 있음.
 * 
 * 상속은 자식이 부모를 상속하겠다는 키워드로 선언하는데, extends 를 사용함.
 */
public class Animal {

}
