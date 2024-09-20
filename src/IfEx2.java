
public class IfEx2 {
	public static void main(String[] args) {
		/*
		 * 아스키코드의 범위 만큼의 랜덤 숫자를 생성해서 문자(char)로 변환해 출력.
		 */

		char ran=(char)(Math.random()*128);
		char numBefore=(char)(Math.random()*48);
		char num=(char)(57-Math.random()*10);
		char numAfter=(char)(64-Math.random()*6);
		char upperL=(char)(90-Math.random()*26);
		char upAfter=(char)(96-Math.random()*6);
		char lowerL=(char)(122-Math.random()*26);
		char lowAfter=(char)(127-Math.random()*5);

		System.out.println(numBefore);
		System.out.println(num);
		System.out.println(numAfter);
		System.out.println(upperL);
		System.out.println(upAfter);
		System.out.println(lowerL);
		System.out.println(lowAfter);
		
		//wrapper 클래스를 이용해서 로직을 간편하게 정리할 수 있음.
		boolean isDigit = Character.isLetterOrDigit(ran);
		System.out.println(isDigit);
	}
}