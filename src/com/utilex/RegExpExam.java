package com.utilex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpExam {
	public static void main(String[] args) {
		/*
		 * 정규화 표현식 : 특정 문자를 패턴화 시킨 후 비교할 값을 넣어서 값을 주고, 해당 패턴과 일치하는지의 여부를 확인하는 것.
		 * 자바에서는 Pattern, Match 클래스를 이용해서 이 정규호 식을 처리함.
		 * 
		 * 패턴 문자의 의미(자주 사용하는것)
		 * 
		 * 1. \\(역슬래쉬)를 이용해서 문자열로 패턴을 생성함.
		 * 
		 * 2. 패턴을 구성하는 패턴문자
			 * 2-1. w : 문자만 허용한다는 의미(0~9,A-Z,a-z, 등의 글자들) : () 는 그룹 표시임.
			 * 2-2. W : 문자가 아닌것만 허용(공백, tab, space, new line 등) = !(0~9,A-Z,a-z, 등의 글자들)
			 * 2-3. d : 숫자만 허용(0~9)
			 * 2-4. D : 숫자가 아닌것만 허용(!0~9)
			 * 2-5. s : 공백문자만 허용(\t, \n, space, \f, \r)
			 * 2-6. S : 공백문자가 아닌것만 허용 [^s]
		 * 
		 * 3. 보통 패턴의 첫머리와 끝에 자주 사용하는 패턴문자가 있는데,
		 * ^ : 패턴의 처음이 ...로 시작하니? 처음을 의미. 단, 괄호 내부에 사용되면 반전의 의미로 사용됨.
		 * ex) ^[\\w] : 값이 문자로 시작하니?
		 * $ : 끝이 ...로 끝나니? 보통은 괄호밖에 반복 연산자와 같이 사용됨.
		 * ex) ^[\\w]$ : 문자열로 시작해서 끝나니?
		 * 
		 * 4. 반복 수량 한정자(X 값이)
			 * 4-1. X? : 0회 또는 1회 반복
			 * 4-2. X* : 0회 또는 그 이상 반복
			 * 4-3. X+ : 1회 이상 반복
			 * 4-4. X{n} : 정확히 n번 반복
			 * 4-5. X{n,} : 적어도 n번 반복
			 * 4-6. X{n,m} : 최소 n번부터 최대 m번까지 반복
		 * 
		 * 5. 그룹 문자
			 * 5-1. () : 그룹
			 * 5-2. [] : 문자셋, []내부의 어떤 문자(들)를 의미함.
			 * 5-3. [^] : 부정 문자셋. 괄호 내부의 어떤 문자가 아닐때
		 */
		
		String exp = "(02)|(010)-\\d{3,4}-\\d{4}";
		String data = "010-1234-4567";
		//Pattern 클래스의 비교 메소드를 이용하여 검증.
		boolean res = Pattern.matches(exp, data);
		
		if(res) {
			System.out.println("fit");
		}else {
			System.out.println("babo");
		}
		
		String pw = "1234";
		String pw2 = "A1234";
		
		String pwPattern = "^[\\d]*$";
		
		System.out.println(Pattern.matches(pwPattern, pw));
		System.out.println(Pattern.matches(pwPattern, pw2));
		
		String pattern = Pattern.compile(pwPattern).pattern();
		System.out.println(pattern);
		
		Matcher matcher = Pattern.compile(pwPattern).matcher(pw);
		System.out.println(matcher.find());
		System.out.println(Pattern.compile(pwPattern).matcher(pw2).find());
		
		String strPattern = "^[\\w]*$";
		
		String str1 = "hello";
		String str2 = "A하나";
		String str3 = "A하나 둘 셋넷 다섯13";
		
		System.out.println(Pattern.matches(strPattern, str1));
		
		//^[a-z|A-Z]*$ : 영대소문 구분없이 영문자만 조합하기
		//^[ㄱ-ㅎ|가-힣]*$ : 한글만 허용하는 패턴식.
		String pattern1 = "^[^ ][a-z|A-Z|ㄱ-ㅎ|가-힣 ]*$";
		System.out.println(Pattern.matches(pattern1, str2));
		
		//공백을 허용하면서 숫자를 포함 모든 문자를 허용하는 패턴
		// -(대쉬) 는 범위를 뜻함.
		String allowSpacePattern = "^[0-9a-zA-Zㄱ-ㅎ가-힣 ]*$";
		System.out.println(Pattern.matches(allowSpacePattern, str3));
	}
}
