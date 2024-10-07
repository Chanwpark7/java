package com.langex.lambda;

class MyButton{
	
	@FunctionalInterface
	public static interface ClickListener{
		void onClick();
	}
	
	private ClickListener clickListener;
	
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	public void click() {
		this.clickListener.onClick();
	}
}

public class LambdaEx3 {
	public static void main(String[] args) {
		MyButton myBtn = new MyButton();
		myBtn.setClickListener(()->{
			System.out.println("밥밥콩밥밥밥초밥밥밥");
		});
		
		myBtn.click();
		
		MyButton cancel = new MyButton();
		cancel.setClickListener(()->{
			System.out.println("캔슬");
		});
		cancel.click();
	}
}
