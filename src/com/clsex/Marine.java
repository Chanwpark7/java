package com.clsex;

public class Marine {
	private int hp;
	UnitHpInfo info;
	
	public void attacked(int damage) {
		this.hp -= (int)(Math.random()*10);
		
		if(this.hp == 0) {
			System.out.println("Marine has been died");
		}
	}
	
	public void getHealed(int hp) {
		if(this.hp > new UnitHpInfo().MARIN_MAX) return;
		this.hp += hp;
	}
	
	//가변형 파라미터 : 같은 타입의 값을 하나 이상, 갯수제한 없이(배열 포함) 전달할 수 있는 기능
	public void doSome2(int ...a) {
		//a는 내부적으로 int[] 로 자동 변환되고, 넘겨지는 파라미터의 값을 자동으로 배열 값으로 넣어서 처리해버림.
		for(int x:a) {
			System.out.println(x);
		}
	}
	
	public void doSome(int a) {//int 타입의 값 하나만 받을 수 있음.
		
	}
	
	public static void main(String[] args) {
		Marine m = new Marine();
		m.doSome2(1,2,3,4);
		m.doSome2(new int[] {10,20,30,40});
		
	}
}
