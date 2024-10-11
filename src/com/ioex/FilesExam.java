package com.ioex;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * java.nio package 에 있는 향상된 파일 관리 객체 알아보기
 * Files, Path, Paths 등의 API가 모여있는 패키지임.
 * 기존File 클래스보다 더 향상된 기능의 메소드가 Files 에 있고,
 * 경로등을 관리하는 Path 객체 등을 이용해서 File, Files 등을 사용할 수 있음.
 */
public class FilesExam {
	public static void main(String[] args) throws Exception{
		Path path = Paths.get("D:"+File.separator+"test"+File.separator+"myFolder"+File.separator+"sub"+File.separator+"submit.png");
		path = Paths.get("D:"+File.separator+"test"+File.separator+"myFolder"+File.separator+"sub"+File.separator+"test.txt");
		
		//파일의 컨텐트타입을 확인하는 메소드 이용.
		System.out.println(Files.probeContentType(path));
		
		//Files 에는 스트림을 사용할 수 있는 메소드도 있음
		Files.writeString(path, "Hello World", Charset.forName("UTF-8"));
		System.out.println(Files.readString(path));
	}
}
