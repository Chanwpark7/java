package com.langex.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

/*
 * distinct() : 객체인 경우 Hash 비교 후 같으면 제거, 나머지 p type 은 값 같은 경우 제거
 * filter() : Predicate 타입의 함수 객체를 이용해서 filter 할 조건을 정의 후, 해당 조건에 맞게 filtering 후 stream 리턴
 */
public class FilterStreamEx {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("AO");
		list.add("BB");
		list.add("BO");
		list.add("AB");
		list.add("OO");
		list.add("AA");
		list.add("AO");
		list.add("BB");
		list.add("BO");
		list.add("AB");
		list.add("OO");
		
		//distinct
		list.stream()
			.distinct()
			.forEach(t -> System.out.println(t));
		
		System.out.println();
		
		//특정 조건을 부여한 predicate 함수를 적용한 filter 잡업
		list.stream()
			.filter(t -> t.startsWith("A"))
			.forEach(t -> System.out.println(t));

		System.out.println();
		
		//중복 제거 후 특정 조건 입력.
		list.stream()
			.distinct()
			.filter(t -> t.startsWith("A"))
			.forEach(t -> System.out.println(t));
		
		//변환 method 인 mapto...()를 이용해서 변환.
		//이 map은 주어진 A -> C 로(타입은 준 경우) 변환해서, 변환된 요소를 갖는 스트링을 리턴함.
		
		List<Player> list2 = new ArrayList<Player>();
		
		list2.add(new Player("1호기", 100));
		list2.add(new Player("2호기", 63));
		list2.add(new Player("3호기", 25));
		list2.add(new Player("4호기", 92));
		list2.add(new Player("5호기", 87));
		list2.add(new Player("6호기", 16));
		
		//Player 를 score 로 변환하도록 함.
		list2.stream()
			.mapToInt(value -> value.getScore())
			.sorted()
			.forEach(value -> System.out.println("플레이어의 점수 "+value));
		
		int[] intArr= {1,2,3,4,5};
		//위 int 배열을 스트림을 이용하여 double 로 변환 후 출력.
		Arrays.stream(intArr)
			.asDoubleStream()
			.forEach(value -> System.out.println(value));
		
		Arrays.stream(intArr)
			.boxed()
			.forEach(t -> t.intValue());
		
		//요소를 정렬하는 스트림 ex)sorted()
		//...sort...()은 모두 정렬 기반 스트림을 리턴하는 메소드임.
		//만약 정렬의 대상인 객체들은 모두 Comparable 을 구현한 객체이여야 함.
		//안그럼 예외 발생함.
		
		//사용자 객체 정렬
		list2.stream()
			.sorted()
			.forEach(value -> System.out.println("플레이어의 점수 "+value.getScore()));
		
		list2.stream()
			.sorted((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()))
			.forEach(t -> System.out.println(t.getName()+" : "+t.getScore()));
		
		//filter 에 조건을 더한 요소의 개별 처리 방법 알아보기
		System.out.println(Arrays.toString(intArr));
		
		Arrays.stream(intArr)
			.filter(value -> value%2==0)
			.peek(res -> System.out.println(res))
			.sum();
		//peek() 은 중간처리 요소. 이 결과를 최종처리해야 하는 최종처리요소가 나와야 실행됨.
		//반면에 forEach 는 최종처리 요소임.
		
		//match() 관련 처리 방법
		boolean isAllEven = Arrays.stream(intArr)
			.allMatch(value -> value%2==0);
		System.out.println("배열의 값은 모두 짝수? "+isAllEven);
		
		//최종 요소함수 즉 peek() 처럼 중간 처리 함수가 아닌, 최종 결과를 리턴하는 함수를 뜻함.
		//이 최종함수는 대부분 집계함수(합, 평균 등)로 구성되어있음.
		/*
		 * 종류로는 다음과 같음 : count, findFirst, maxCompartion, max, min, average, sum 등
		 * 위 함수들은 대부분 스트림 내부에 데이터를 내부적으로 연산처리한 결과를 담은 Optional 함수등과 같다고 볼 수 잇음.
		 */
		
		long cnt = Arrays.stream(intArr)
			.filter(value -> value%2 == 0)
			.count();
		System.out.println(cnt);
		
		cnt = Arrays.stream(intArr)
			.filter(value -> value%2 == 0)
			.max()
			.getAsInt();
		System.out.println(cnt);
			
		//Optional 클래스 : 컬렉션의 요소를 stream 을 통해 get 했을 때, 이 타입객체로 리턴하는 메소드가 있음
		//그럼 이 클래스의 여러 메소드를 이용해서 요소가 존재하는지의 여부와,
		//집계된 결과에 따른 조건을 사용한다던지 등의 작업을 수행할 수 있는 클래스
		//대표적인 메소드로는 isPresent() 가 있음. 요소가 존재하는지의 여부를 리턴.
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		
		//아래는 요소가 비워진 상태에서 연산이 이뤄지므로 예외 발생.
//		double avg = al.stream()
//			.mapToInt(Integer::valueOf)
//			.average()
//			.getAsDouble();
		
		//위처럼 처리된 스트림의 최종 함수를 이용할 때는 요소의 존재 여부가 매우 중요함.
		//이때 이를 처리하는 클래스가 Optional 임.
		OptionalDouble od = al.stream()
			.mapToInt(Integer::valueOf)
			.average();
		if(od.isPresent()) {
			System.out.println(od.getAsDouble());
		}else {
			System.out.println("od.getAsDouble() 실행불가(처리할 요소 없음)");
		}
		
		//if else 처럼 요소가 있고 없고에 따른 기본값도 처리 할 수 있음.
		double avg = al.stream()
					.mapToInt(Integer::intValue)
					.average()
					.orElse(0.0);
		System.out.println(avg);
		
		//요소 수집 : 스트림을 통해 처리된 요소를 최종 집계하는 대표적인 메소드가 collect()임.
		//이 메소드를 이용해서 수집된 요소 중 필요한 부분만을 담을 수 있고, 이를 그룹화한 후 최종 요소처리함수를
		//이용해서 집계등에도 활용할 수 있음.
		
		
	}
}
