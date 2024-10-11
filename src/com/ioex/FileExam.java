package com.ioex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileExam {
	public static void main(String[] args) throws Exception{
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		File dirs = new File("D:"+File.separator+"test"+File.separator+"myFolder");
		System.out.println(dirs);
		
		BufferedWriter bw = null;
		
		if(dirs.exists()) {//존재 여부 확인
			System.out.println(dirs.mkdirs());
			File file = new File(dirs,"test.dat");
			
			if(file.createNewFile()) {//파일 생성 되었다면
				bw = new BufferedWriter(new FileWriter(file));
				
				bw.write("Hello World");
				bw.close();
				//file.delete();
			}
		}
		
		//파일에 대한 모든 정보 얻어내기
		System.out.println(dirs.getParent());
		File root = new File(dirs.getParent());
		
		List<File> files = listFiles(root.getPath());
		files.forEach(System.out::println);
	}
	
	//보통 특정 폴더 내부에 어떤 파일들이 존재하는지의 여부는 메소드로 정의하는데, 재귀 호출을 이용함.(이건 개발자 마음)
	//재귀호출은 자신이 자신을 호출하는 형태를 뜻함. 여기서는 메소드 내부에 메소드를 호출해서 처리함.
	private static List<File> listFiles(String path){
		//폴더 및 파일등 모든 하위 파일을 담는 list 생성
		List<File> fileList = new ArrayList<File>();
		File[] files = new File(path).listFiles();//폴더내의 모든 파일을 file[] 로 리턴하는 메소드 호출
		for(File file : files) {
			//폴더라면 다시 하위로 내려가서 모든 파일 가져옴. 그러기 위해 자신을 다시 호출함.
			if(file.isDirectory()) {
				fileList.addAll(listFiles(file.getPath()));
			}else {
				fileList.add(file);
			}
		}
		return fileList;
	}
}
