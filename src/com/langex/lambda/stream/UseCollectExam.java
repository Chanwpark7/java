package com.langex.lambda.stream;
/*
 * Stream 의 collect(Collector(T,A,R)) : Collector 를 이용해서, T 요소를 A 누적기를 통해(함수형태), R 요소에
 * 넣어두는 작업을 하는 메소드. 실제 변환 작업은 Collector 객체가 하는데, 얘는 Collectors 클래스를 이용해서 얻을 수 있음.
 * 
 * 위 collect()를 이용하면, 특정 타입의 컬렉션을 다른 타입으로 변경해서 리턴할 수 있음.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
class CollectUser{
	private String name;
	private String gender;
	private int score;
}

public class UseCollectExam {
	public static void main(String[] args) {
		List<CollectUser> userList = new ArrayList<CollectUser>();
		userList.add(new CollectUser("1호기","남성",3));
		userList.add(new CollectUser("2호기","여성",16));
		userList.add(new CollectUser("3호기","남성",94));
		userList.add(new CollectUser("4호기","여성",67));
		userList.add(new CollectUser("5호기","남성",25));
		userList.add(new CollectUser("6호기","여성",84));

		//성별이 남성인 유저만 추출해서 List로 만듦.
		List<CollectUser> maleList = userList.stream()
				.filter(t -> t.getGender().equals("남성"))
				.toList();
		maleList.forEach(t -> System.out.println(t));
		
		System.out.println();
		
		//유저 이름을 key, 점수를 value 로 갖는 Map 으로 요소를 변환
		Map<String, Integer> map = userList.stream()
			.collect(Collectors.toMap(t -> t.getName(), t -> t.getScore()));
		System.out.println(map);
	}
}
