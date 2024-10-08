package com.langex.lambda.stream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class NIOStreamEx {
	public static void main(String[] args) {
		//File 객체를 이용해서 스트림을 연결, 데이터를 read 했지만
		//nio 패키지에 paths 객체를 이용해서 InputStream 을 연결.
		
		try {
			Path path = Paths.get(NIOStreamEx.class.getResource("data.txt").toURI());
			Stream<String> data = Files.lines(path);
			data.forEach(t -> System.out.println(t));
			data.close();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
