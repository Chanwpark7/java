package com.netex;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonTest {
	public static void main(String[] args) throws Exception{
		JSONObject root = new JSONObject();

		root.put("id", "jason");
		root.put("pw", "1234");
		
		//Json 에 속성 추가
		JSONObject	info = new JSONObject();
		info.put("phone", "010-5686-5107");
		info.put("add", "경기 김포시");
		
		JSONArray skils = new JSONArray();
		skils.put("java");
		skils.put("script");
		
		root.put("skils", skils);
		
		//Json 정보 얻기
		String json = root.toString();
		System.out.println(json);
		
		Writer w = new FileWriter("myinfo.json",Charset.forName("UTF-8"));
		w.write(json);
		w.flush();
		w.close();
		
		JSONObject jobj = new JSONObject(json);
		JSONArray jarr = jobj.getJSONArray("skils");
		for(int i = 0;i<jarr.length();i++) {
			System.out.println(jarr.get(i));
		}
	}
}
