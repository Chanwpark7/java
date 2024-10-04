package com.utilex.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

import lombok.AllArgsConstructor;
import lombok.Data;

//게시판을 예로 들자면, 게시글을 관리하는 list를 사용함.

@AllArgsConstructor
@Data
class Board{
	private String subject;
	private String content;
	private String writter;
}


public class ListExam {
	public static void main(String[] args) {
		
		List<Board> list = new ArrayList();
		list.add(new Board("1번 제목","내용1","노잼1"));
		list.add(new Board("2번 제목","내용2","노잼2"));
		list.add(new Board("3번 제목","내용3","노잼3"));
		
		Board bo = new Board("4번 제목","내용4","노잼4");
		
		list.add(0, bo);
		
		System.out.println(list.indexOf(bo));
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());

		//2번 객체 get
		Board board = list.get(2);
		System.out.println(board);
		
		for(Board brd : list) {
			System.out.println(brd);
		}
		
		
		//list.clear();
		System.out.println(list.size());
		
		List<Board> vList = new Vector<Board>();
		Board b1 = new Board("벡터1","벡터 내용1","벡사장1");
		Board b2 = new Board("벡터2","벡터 내용2","벡사장2");
		Board b3 = new Board("벡터3","벡터 내용3","벡사장3");
		vList.add(b1);
		vList.add(b2);
		vList.add(b3);
		
		List<Board> merge = new ArrayList<Board>(list);
		merge.addAll(vList);
		
		System.out.println(merge.size());
		
		System.out.println(merge.containsAll(vList));
		
		//큐는 인터페이스라서 구조체를 생성하려면 LinkedList 를 이용해야함.
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(1);
		q.offer(2);
		q.offer(3);
		
		System.out.println(q);
		
		System.out.println(q.peek());
		System.out.println(q);
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
			System.out.println(q);
		}
	}
}
