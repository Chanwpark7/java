/*
 * 지금 작성하는 이론은 기억해두면 좋음
 * 
 * 자바에는 데이터 타입이 존재하는데, 큰 범위로는 P(Primitive type-원시자료형)과 R(Reference-참조형 즉 객체) 타입으로 구분됨.
 * 
 * P 타입은 원시 자료형으로, 숫자, 문자, boolean 을 크기별로 세분화 하여 메모리를 사용하도록 되어있음.
 * 이 타입을 정한 이유는, 자바 스크립트는 모든 데이터를 64byte 로 사용하는데, 이렇게 사용하면 불필요한 메모리 누수가 많이 발생 할 수 있음.
 * 따라서 값의 범위에 맞도록 메모리를 적절히 할당하도록 하게끔 데이터 타입을 사용.
 * 
 * P 타입은 좀 더 세분화 하면 숫자는 정수와 실수, 문자는(문자열 아님) 정수 타입으로, boolean 은 1byte 의 boolean 으로만
 * 사용되도록 규정되어있음.
 * 
 * 수치형(메모리 할당크기) : 	byte(1byte-정수연산시 사용안함/주로 문자열처리등을 위해 사용됨.),
 * 						short(2byte-사용안함), int(4byte default), long(8byte) 이상 정수
 * 						float(4byte), double(8byte default) 이상 실수.
 * 
 * 실수는 정수를 표현할 수 있지만, 정수를 실수로 표현할 수 는 없음. 때문에 메모리 크기와는 상관없이 실수가 정수보다 항상 큰 타입으로 생각.
 * 
 */
public class DataTypeEx1 {
	public static void main(String[] args) {
		//같은 타입의 변수를 선언.
		byte b, b1, b2; // 모두 main 내부의 지역변수로 byte type 으로 선언함. 절대 타입 변경 불가능함.
		b=1;
		b1= 100;
		b2= -128;

		System.out.println("byte 의 Max 와 Min " + Byte.MAX_VALUE + " : " + Byte.MIN_VALUE);
		System.out.println("short 의 Max 와 Min " + Short.MAX_VALUE + " : " + Short.MIN_VALUE);
		//System.out.println("int 의 Max 와 Min " + Int.MAX_VALUE + " : " + Int.MIN_VALUE);
		System.out.println("long 의 Max 와 Min " + Long.MAX_VALUE + " : " + Long.MIN_VALUE);
		
		b=b2;//같은 type끼리 값 대입 가능.
		b1 = b;
		
		b=1;
		
		short s1=1;
		
		s1=b; 	//작은타입을 큰 타입에 대입. 문제 없음.
				//Promotion: 작은 타입을 큰 타입에 대입할 때 나타나는 현상. 값이 복제가 되면서 타입이 변하게 됨.
		
		b= (byte)s1;	//큰 타입을 작은 타입에 대입 -> 오류. => 타입 캐스팅(하위 타입으로 타입 변형을 수행하라는 연산자) 을 통해 s1의 값을 byte 타입의 메모리를 생성후 값을 복제하고
						//복제된 값을 b에 대입을 해주게 됨.
		
		//캐스팅 시 상위 비트가 절삭. 부호비트부터 모두 절삿됨
		
		s1=10000;
		System.out.println(Integer.toBinaryString(s1));
		System.out.println("10011100010000".length());
		b=(byte)s1;
		System.out.println(b+" : "+Integer.toBinaryString(b));
		
		//캐스팅 연산자 : (type)value, 우선순위는 2번이고, 우측의 항 하나에만 영향을 미침.
		
		//정수 연산을 할때는 기본적으로 int 를 사용하되 (int 범위내의 값이라면) 범위가 큰 경우엔 Long 사용.
		// 그런데, int 가 default 인 데에는 또 다른 의미가 있음.
		//int 이하의 정수를 연산(+ * / 등)을 할때와, 리터럴 데이터(ex 10, 1, -100 등)는 모두 int 로 메모리를 생성 후 연산
		//위에서 int 이하라 했으니, byte 와 short 도 포함.
		//만약 int 보다 더 큰 타입과 연산이 되면 무조건 큰 타입으로 먼저 메모리를 생성, 값 복사, 연산 후 리턴.
		//즉, 연산 후의 리턴타입은 항상 큰 타입.
		
		byte b3=1;
		short s3=2;
		int res=b3+s3;
		short s4=(short)(b3+s3);
		System.out.println(s4);
		
		s4=1;
		int i= s4+1;
		
		//Long 타입. 무한대의 정수를 담는 타입. 값과 상관없이 long 으로 선언하면 값의 끝에 소문자 또는 대문자로 L표시를 해줘야 Long으로 인식함.
		
		long lo=1L;
		long i2 = i + lo;
		
		//정수는 진법으로도 값을 표현할 수 있음. 하지만 잘 쓰진 않음.
		//2진수는 0b or 0B 로 시작해서 값을 비트로 주고
		//8진수는 0으로 시작해서 0~7까지의 값으로 구성.
		//16진수는 0x로 시작해서 0~9,A~F 까지로 표현함.
		
		int bin = 0b1011;
		System.out.println(bin);
		
		int oct = 0234;
		System.out.println(oct);
		
		int hex = 0xA123;
		System.out.println(hex);
	}
}
