package com.clsex.nested;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/*
 * 중첩 인터페이스 : 클래스 내부에 멤버로 참여하도록 선언된 인터페이스를 말함.
 * 주로 설계되는 목적은 외부 클래스의 특정 기능을 구현토록 정의함.
 * 예를 들어, 안드로이드에서 사용되는 컴포넌트 중 버튼 같은  경우, UI 를 구현한 클래스와
 * 이 UI 에 발생되는 이벤트를 처리하도록 내부적으로 인터페이스를 적용해서 버튼의 이벤트핸들러를
 * 이 내부 인터페이스가 담당하도록 설계하는 것.
 * 
 * 이렇게 되면, 특정 버튼이 수행해야 할 이벤트 핸들러를 따로 정의할 필요 없이 버튼에 할당된
 * 메서드를 통해 내부 인터페이스의 구현 객체가 그 핸들러 역할을 할 수 있어서 편리한 장점이 생김.
 * 
 * 내부 인터페이스는 외부 클래스의 멤버로만 존재할 때는 private 으로 선언하거나 외부에 노출을 시킬때는 public, default로 선언 가능
 * static 또한 인터페이스 목적에 따라서 선언할 수 있다.
 * 
 * [public or private][static] interface InterfaceName{...}
 * 인터페이스 내부에는 일반 인터페이스처럼 상수, 추상메소드, 디폴트 메소드, 정적 메소드 모두 선언 가능하다.
 */

//class MyFrame extends Frame{
//	
//	Button button;
//	
//	public MyFrame() {
//		super("이건 자바 프레임");
//		init();
//	}
//	
//	void init() {
//		button = new Button("this is a Button");
//		this.add(button);
//		button.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showConfirmDialog(button, "프로그램 종료");
//				System.exit(0);
//			}
//		});
//		this.setSize(300,300);
//		this.setLocation(300, 300);
//		this.setVisible(true);
//	}
//}

//내가 Button 클래스를 만든다고 가정하고 정의.
class MyButton{
	/*
	 * 버튼에 이벤트가 오면, 이벤트를 핸들링 할 수 있도록 하는 Listener 를 내부에 정의.
	 * 자바에서는 모든 Listener 는 인터페이스 타입.
	 */
	private MyClickListener myClickListener;
	
	//이 번트에 이벤트가 발생하면 리스너가 알 수 있도록 리스너 setter 정의
	public void setMyClickListener(MyClickListener myClickListener) {
		this.myClickListener = myClickListener;
	}
	
	public void click() {
		this.myClickListener.onClick();//버튼에 클릭 발생하면 핸들러로 inner inter 의 클릭을 호출함.
	}
	
	public static interface MyClickListener{
		void onClick();
	}
}

public class NestedInterEx {
	
	public static void main(String[] args) {
		//new MyFrame();
		
		MyButton okButton = new MyButton();
		
		//지역 클래스로 클릭리스너의 구현 클래스로 정의.
		class OkListener implements MyButton.MyClickListener{
			@Override
			public void onClick() {
				System.out.println("Ok Button Clicked");
			}
		}
		okButton.setMyClickListener(new OkListener());
		okButton.click();
		
		MyButton cancelBtn = new MyButton();
		class cancelListener implements MyButton.MyClickListener{
			@Override
			public void onClick() {
				System.out.println("Cancel Button Clicked");
			}
		}
		cancelBtn.setMyClickListener(new cancelListener());
		cancelBtn.click();
	}
}
