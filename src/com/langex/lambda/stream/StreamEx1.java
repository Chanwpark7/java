package com.langex.lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * java.util.stream : 내부 반복자(순환자)를 적용한 컬렉션의 요소 처리 패키지.
 * 
 * 중간처리 스트림, 최종 스트림 : 스트림은 연속적으로 메소드를 이용해서 확장 가능함.
 * 이때 중간에 추가되는 스트림 종류는 Mapper, 변환 등 여러 스트림이 존재하는데, 이 스트림을 이용하면
 * 오리지널 스트림으로부터의 데이터를 변환 등을 거쳐 다른 스트림으로 보내게 됨.
 * 이 추가된 스트림으로부터 데이터를 받아서 최종 처리하는 스트림을 이용해서 원하는 데이터를 완성시킬 수 있음.
 * 단, 주의해야할 점은, 중간 스트림을 생성해서 얻어내 스트림을 이용하는 최종 스트림이 생략되면,
 * 스트림 전체가 처리가 안되는 상태에 빠짐. 따라서 중간에 변환 스트림을 이용하면, 반드시 최종 스트림을 처리해야 함.
 */

@AllArgsConstructor
@Data
class Player implements Comparable<Player>{
	private String name;
	private int score; //최종 승률
	
	@Override
	public int compareTo(Player player) {
//		if(this.score < player.getScore()) return -1;
//		else if(this.score == player.getScore()) return 0;
//		else return 1;
//		
		return Integer.compare(score, player.score);
	}
	
	
}
public class StreamEx1 {
	static int sum = 0;
	public static void main(String[] args) {
//		Set<String> set =new HashSet<String>();
//
//		set.add("a");
//		set.add("b");
//		set.add("c");
//		set.add("d");
//		
//		Stream<String> stream = set.stream();
//		stream.forEach(t -> System.out.println(t));
//
//		List<Integer> list = Arrays.asList(1,2,3,4,5,6,77,8,9);
//		System.out.println(list);
//		
//		Stream<Integer> st = list.stream();
//		st.forEach(t -> System.out.println(t));
		
		//List를 생성해서 각 요소에 3명의 Player 를 add 시킴
		List<Player> players = Arrays.asList(
			new Player("1호기",85),
			new Player("2호기",56),
			new Player("3호기",13),
			new Player("4호기",94)
		);
		Stream<Player> pStream = players.stream();
		
		//player의 랭크를 기준으로 하는 score 를 얻어내서 int 스트림으로 확장함.
		IntStream is = pStream.mapToInt(player -> player.getScore());
		long[] a = is.asLongStream().sorted().toArray();
		System.out.println(Arrays.toString(a));
		
		//double avg = is.asLongStream().average().getAsDouble();
		
		double avg2 = players.stream()
				.mapToInt(value -> value.getScore())
				.average()
				.getAsDouble();
		
		//IntStream 의 range()를 이용해서 특정 범위 만큼의 int 를 스트림으로부터 get 하기
		
		IntStream.range(0, 100)//100미만
			.forEach(value -> {
				sum += value;
				System.out.println(value);
			});
		System.out.println(sum);
	}
}
