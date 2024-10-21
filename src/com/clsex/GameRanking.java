package com.clsex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class GameRanking {
	
	public List<JSONObject> winRateRankAsc(File[] files) throws Exception{
		List<JSONObject> fileList = new ArrayList<JSONObject>();
		JSONArray jList = new JSONArray();
		
		for(int i = 0;i<files.length;i++) {
			FileReader fr = new FileReader(files[i]);
			BufferedReader br = new BufferedReader(fr);
			JSONObject json = new JSONObject(br.readLine());

			fileList.add(json);
		}
		
		//file 의 winrate 를 가져와서 정렬, 정렬한 것들 중 상위 10개 list 에 파일로 add 후 리턴
		
		fileList.sort((o1, o2) -> (int)o2.get("winrate") - (int)o1.get("winrate"));
		
		return fileList;
	}
	
	public List<JSONObject> winRateRankDesc(File[] files) throws Exception{
		List<JSONObject> fileList = new ArrayList<JSONObject>();
		JSONArray jList = new JSONArray();
		
		for(int i = 0;i<files.length;i++) {
			FileReader fr = new FileReader(files[i]);
			BufferedReader br = new BufferedReader(fr);
			JSONObject json = new JSONObject(br.readLine());

			fileList.add(json);
		}
		
		//file 의 winrate 를 가져와서 정렬, 정렬한 것들 중 하위 10개 list 에 파일로 add 후 리턴
		
		fileList.sort((o1, o2) -> (int)o1.get("winrate") - (int)o2.get("winrate"));
		
		return fileList;
	}
	
	public List<JSONObject> totalRankAsc(File[] files) throws Exception{
		List<JSONObject> fileList = new ArrayList<JSONObject>();
		JSONArray jList = new JSONArray();
		
		for(int i = 0;i<files.length;i++) {
			FileReader fr = new FileReader(files[i]);
			BufferedReader br = new BufferedReader(fr);
			JSONObject json = new JSONObject(br.readLine());

			fileList.add(json);
		}
		
		//file 의 total 를 가져와서 정렬, 정렬한 것들 중 상위 10개 list 에 파일로 add 후 리턴
		
		fileList.sort((o1, o2) -> (int)o2.get("total") - (int)o1.get("total"));
		
		return fileList;
	}
	
	public List<JSONObject> totalRankDesc(File[] files) throws Exception{
		List<JSONObject> fileList = new ArrayList<JSONObject>();
		JSONArray jList = new JSONArray();
		
		for(int i = 0;i<files.length;i++) {
			FileReader fr = new FileReader(files[i]);
			BufferedReader br = new BufferedReader(fr);
			JSONObject json = new JSONObject(br.readLine());

			fileList.add(json);
		}
		
		//file 의 total 를 가져와서 정렬, 정렬한 것들 중 하위 10개 list 에 파일로 add 후 리턴
		
		fileList.sort((o1, o2) -> (int)o1.get("total") - (int)o2.get("total"));
		
		return fileList;
	}
	
	
}
