package com.ioex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

import lombok.AllArgsConstructor;

/*
 * 객체를 in-out 시키는 ObjectInput/OutputStream
 * 
 * 말 그대로 객체를 통째로 입/출력하도록 고안된 API
 * 
 * 만약 객체를 output 할 경우엔, static 과 메소드를 제외한 필드만 쓰여짐.
 * 
 * 메소드를 안쓰는 이유는 객체가 생성시엔 필드만 복사해서 보유하기 때문.
 * 
 * 메소드는 메소드 메모리영역(상수가 저장되는 영역)에 저장되었다가 호출될 때 찾아서 호출하는 방식을 자바에서는 사용하기 때문.
 * 
 * 여튼, 객체를 쓰면 필드가 직렬화(Serialize) 되어서 스트림을 통해 나가는데, 이때 static 필드와 transient(휘발성데이터)
 * 
 * 로 선언된 필드는 직렬화에서 제외된다.
 * 
 * 이렇게 객체가 직렬화 되어지려면, 반드시 Serializable 인터페이스를 상속해야만 한다.
 * 
 * 쓰여진 객체는 다시 역직렬화(Deserialize) 되어서 스트림으로 읽을 수 있다.
 * 이땐 반드시 원 클래스 타입으로 매핑해줘야 함. (Object)타입으로 리턴되어지기 때문.
 * 
 * 단, 처음 보내진 객체의 클래스와 역직렬화 되어진 객체의 클래스에서 필드가 변경되었다면 역직렬화 실패되는데,
 * 이는 시리얼번호가 같다면 부시되어 역직렬화가 가능하다.
 */
class MyUser implements Serializable{
	private String id;
	private transient String pw;//직렬화에서 제외
	private String name;
	private String addr;
	
	public MyUser(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return id + " : " + pw + " : " + name;
	}
}


class MyItem implements Serializable{
	private static final long serialVersionUID = -5054693353313702648L;
	
public MyItem(String pName, int price) {
		super();
		this.pName = pName;
		this.price = price;
	}

	private String company;
	private String pName;
	private int price;
	
	@Override
		public String toString() {
			return pName + " : " + price;
		}
}

public class ObjStreamEx {
	public static void main(String[] args) throws Exception{
//		FileOutputStream fos = null;
//		ObjectOutputStream oos = null;
		String filePath = "D:\\ioRoot\\objStream.data";
//		
//		fos = new FileOutputStream(filePath);
//		oos = new ObjectOutputStream(fos);
//		
//		//사용자 객체 생성
//		MyUser me = new MyUser("chanwpark","1234","박찬우");
//		MyItem item = new MyItem("999inch TV", 200000000);
//		int[] arr = {1,2,3};
//		
//		oos.writeObject(me);
//		oos.writeObject(item);
//		oos.writeObject(arr);
//		
//		oos.flush();
//		oos.close();
		
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//파일에서 객체를 읽고 역직렬화 처리
		MyUser mu = (MyUser)ois.readObject();
		MyItem mi = (MyItem)ois.readObject();
		int[] arr2 = (int[])ois.readObject();
		
		ois.close();
		
		System.out.println(mu);
		System.out.println(mi);
		System.out.println(Arrays.toString(arr2));
	}
}
