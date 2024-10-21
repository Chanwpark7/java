package com.clsex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

public class GameMain {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		GameAccount ga = null;
		GamePlay game = new GamePlay();
		boolean run = true;
		boolean isStarted = false;
		int count = 0;
		boolean forgot = true;
		boolean checkRank = true;
		
		//실행시 user 폴더 생성
		File dirs = new File("E:"+File.separator+"user");
		dirs.mkdirs();

		//폴더 내 존재하는 모든 유저들의 정보를 담은 파일 배열 객체 생성
		File[] files = new File("E:"+File.separator+"user").listFiles();
		
		//랭킹 메소드 사용시 이용되는 랭킹 클래스 객체 생성
		GameRanking gr = new GameRanking();
		
		while(run) {//게임 실행
			System.out.println("1.로그인\n2.회원가입\n3.비번 변경\n4.내 전적보기\n5.순위 보기\n6.종료");
			String strX = sc.nextLine();
			int intX = Integer.parseInt(strX);
			
			if(intX==1) {//로그인 선택시
				System.out.println("아이디(Email)를 입력하세요.");
				String id = sc.nextLine();
		
				System.out.println("비밀번호를 입력하세요.");
				String pw = sc.nextLine();
				
				//입력받은 id 와 pw 로 로그인한 유저의 계정 객체 생성
				ga = new GameAccount(id, pw);
				
				//입력받은 id 의 파일 객체 생성
				File file = new File("E:"+File.separator+"user"+File.separator+id);
				
				if(file.exists()) {//존재 여부 확인
					//입력받은 id 의 파일이 폴더내에 존재한다면
					try {
						//로그인한 유저의 데이터 read
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						JSONObject json = new JSONObject(br.readLine());
						//업데이트 될 json 객체 생성
						JSONObject jsonGame = new JSONObject();
						
						if(json.get("pw").equals(ga.getPW())){//read 한 유저의 pw와 입력받은 pw가 같은지 확인
							//마지막 로그인 시각(현재 시각) 출력
							Calendar now = Calendar.getInstance();
							System.out.println("마지막으로 로그인 한 시각 : "+now.get(Calendar.YEAR)+"년 "+(now.get(Calendar.MONTH)+1)+"월 "+now.get(Calendar.DATE)+"일 "+now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND));
							
							//같다면 게임 시작 flag true로 설정
							isStarted = true;

							System.out.println("1.가위바위보 게임하기\n2.전체 랭크 보기");
							String strY = sc.nextLine();
							int intY = Integer.parseInt(strY);
							if(intY == 1) {//가위바위보 게임 시작
								System.out.println("게임 시작\n---------------------\n");
								while(isStarted) {
									//새로 쓸 json 객체에 입력 받은 id, pw 입력
									jsonGame.put("id", id);
									jsonGame.put("pw", pw);
									jsonGame = game.isPlayed(json,file); //게임 진행 및 게임 결과 json 객체 리턴
									
									Writer w = new FileWriter(file,Charset.forName("UTF-8"));
									BufferedWriter bw = new BufferedWriter(w);
									bw.write(jsonGame.toString()); //리턴된 새로운 json 객체 유저 파일에 write.
									bw.flush();
									bw.close();
									
									//계속 할건지
									System.out.println("---------------------\n계속 하시겠습니까? y|n");
									String strC = sc.nextLine();
									if("n".equals(strC)) {//n 을 입력 받으면 시스템 종료.
										game.GameEnd();
										System.out.println("프로그램을 종료합니다.");
										System.exit(0);
									}
								}
							}else if(intY == 2) {//전체 랭크 보기
								System.out.println("1. 승률로 정렬\n2. 게임수로 정렬\n3.내 순위 보기");
								String strR = sc.nextLine();
								int intR = Integer.parseInt(strR);

								//전체 랭킹을 파일이 10개 이하라면 파일의 수만큼만, 10개 이상이라면 10개만 출력시키기 위해 count 변수에 갯수 저장
								if(files.length<10) {
									count = files.length;
								}else {
									count = 10;
								}
								
								if(intR == 1) {//승률로 정렬
									System.out.println("1. 오름차순 정렬\n2. 내림차순 정렬");
									String strRR = sc.nextLine();
									int intRR = Integer.parseInt(strRR);
									if(intRR == 1) {//승률 오름차순
										//파일 배열 객체(만들어진 순서대로 정렬돼있는) 메소드로 보내서 오름차순으로 정렬하여 리스트 객체로 리턴받음. 
										List<JSONObject> jList = gr.winRateRankAsc(files);
										
										//전체 랭킹을 파일이 10개 이하라면 파일의 수만큼만, 10개 이상이라면 10개만 출력시킴.
										for(int i=0;i<count;i++) {//랭킹 출력
											System.out.println((i+1)+"위 : "+jList.get(i).get("id")+" 승률 : "+jList.get(i).get("winrate")+"%");
										}
									}else if(intRR == 2) {//내림차순. 오름차순과 동일.
										List<JSONObject> jList = gr.winRateRankDesc(files);
										for(int i=0;i<count;i++) {
											System.out.println((files.length - i)+"위 : "+jList.get(i).get("id")+" 승률 : "+jList.get(i).get("winrate")+"%");
										}
									}else {
										System.out.println("메인 메뉴로 돌아갑니다.");
									}
								}else if(intR == 2) {//총 게임수로 정렬. 승률과 동일
									System.out.println("1. 오름차순 정렬\n2. 내림차순 정렬");
									String strRR = sc.nextLine();
									int intRR = Integer.parseInt(strRR);
									if(intRR == 1) {//총 게임수 오름차순. 승률과 동일
										List<JSONObject> jList = gr.totalRankAsc(files);
										for(int i=0;i<count;i++) {
											System.out.println((i+1)+"위 : "+jList.get(i).get("id")+" 총 게임수 : "+jList.get(i).get("winrate"));
										}
									}else if(intRR == 2) {//총 게임수 내림차순. 승률과 동일
										List<JSONObject> jList = gr.totalRankDesc(files);
										for(int i=0;i<count;i++) {
											System.out.println((files.length - i)+"위 : "+jList.get(i).get("id")+" 총 게임수 : "+jList.get(i).get("winrate"));
										}
									}else {
										System.out.println("메인 메뉴로 돌아갑니다.");
									}
								}else if(intR == 3) {//내 순위 보기
									//전체 유저 승률 오름차순 정렬
									List<JSONObject> jList = gr.winRateRankAsc(files);
									
									for(int i = 0;i<files.length;i++) {
										if((jList.get(i).get("id")).equals(ga.getID())) {//내순위가 몇번째인지 검증, 출력
											System.out.println("내 순위 : " + (i+1) +"위");
										}
									}
								}else {
									System.out.println("메인 메뉴로 돌아갑니다.");
								}
							}
						}else {//비밀번호를 틀릴경우
							count++;//비밀번호를 틀린 횟수 카운트
							if(count>2) {//틀린횟수가 3회 이상이라면 시스템 종료
								System.out.println("비밀번호를 3회 틀렸습니다. 프로그램을 종료합니다.");
								System.exit(0);
							}
							System.out.println("비밀번호가 다릅니다. "+count+"/3");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}else {//id 파일이 존재하지 않는다면
					System.out.println("일치하는 계정이 없습니다.\n아이디를 생성해주세요.");
				}
				
			}else if(intX==2) {//새로운 계정 생성
				//입력받은 정보 저장할 json 객체 생성
				JSONObject root = new JSONObject();
				
				System.out.println("아이디(Email)를 입력하세요.");
				String newId = sc.nextLine();
		
				System.out.println("비밀번호를 입력하세요.");
				String newPw = sc.nextLine();

				File file = new File("E:"+File.separator+"user"+File.separator+newId);
				if(file.exists()) {//동일한 id 파일이 이미 있다면 
					System.out.println("이미 존재하는 아이디입니다.");
				}else {//동일한 id 파일이 없다면 정보 저장
					root.put("id", newId);
					root.put("pw", newPw);
					root.put("total", 0);
					root.put("win", 0);
					root.put("lose", 0);
					root.put("draw", 0);
					root.put("winrate", 0);

					String json = root.toString();
					
					try {//저장받은 정보 새로운 파일에 입력
						Writer w = new FileWriter("E:"+File.separator+"user"+File.separator+newId,Charset.forName("UTF-8"));
						if(file.exists()) {//파일 생성 되었다면 정보 입력
							w.write(json);
							w.flush();
							w.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					System.out.println("아이디가 생성되었습니다.");
				}
			}else if(intX==3) {
				
				while(forgot) {
					System.out.println("아이디(Email)를 입력하세요.");
					String id = sc.nextLine();
			
					System.out.println("비밀번호를 입력하세요.");
					String pw = sc.nextLine();
					
					//입력받은 id의 유저 객체 생성
					ga = new GameAccount(id, pw);
					
					//입력받은 id의 파일 객체 생성
					File file = new File("E:"+File.separator+"user"+File.separator+id);
					
					if(file.exists()) {//입력받은 아이디의 파일이 실제로 존재 한다면
						FileReader fr;
						try {
							//입력받은 id 파일 내의 정보 read
							fr = new FileReader(file);
							BufferedReader br = new BufferedReader(fr);
							JSONObject json = new JSONObject(br.readLine());
							
							if(json.get("pw").equals(ga.getPW())){//입력받은 pw 가 파일 내 pw 와 같다면
								
								System.out.println("새로운 비밀번호를 입력해주세요");
								//받아온 json 객체에 비번만 새로운걸로 put 후 forgot flag false로 변경.
								String newPw = sc.nextLine();
								json.get("pw");
								json.put("pw", newPw);
								
								//새로 입력 받은 json 객체를 파일에 write
								Writer w = new FileWriter(file,Charset.forName("UTF-8"));
								w.write(json.toString());
								w.flush();
								w.close();
								
								System.out.println("비밀번호가 변경되었습니다.");
								
								//while문 종료
								forgot = false;
							}else {//비밀번호를 틀릴경우
								count++;//비밀번호를 틀린 횟수 카운트
								if(count>2) {//틀린횟수가 3회 이상이라면 시스템 종료
									System.out.println("비밀번호를 3회 틀렸습니다. 메인메뉴로 돌아갑니다.");
									forgot = false;
								}
								System.out.println("비밀번호가 다릅니다. "+count+"/3");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else {//실제로 아이디가 존재하지 않는다면
						System.out.println("존재하지 않는 아이디입니다.");
					}
				}
			}else if(intX==4) {//내 랭크 보기
				while(checkRank) {
					System.out.println("로그인 해주세요.");
					System.out.println("아이디(Email)를 입력하세요.");
					String id = sc.nextLine();
			
					System.out.println("비밀번호를 입력하세요.");
					String pw = sc.nextLine();

					//게임 계정 객체 생성
					ga = new GameAccount(id, pw);
					
					//리스트 객체 생성
					List<JSONObject> jList;
					
					//입력받은 id의 파일 객체 생성
					File file = new File("E:"+File.separator+"user"+File.separator+id);
					
					if(file.exists()) {//입력받은 아이디의 파일이 실제로 존재 한다면
						FileReader fr;
						try {
							//입력받은 id 파일 내의 정보 read
							fr = new FileReader(file);
							BufferedReader br = new BufferedReader(fr);
							JSONObject json = new JSONObject(br.readLine());
							
							if(json.get("pw").equals(ga.getPW())){//입력받은 pw 가 파일 내 pw 와 같다면
								//리스트 내의 데이터 승률 오름차순 정렬 후 입력받은 유저의 순위 출력
								jList = gr.winRateRankAsc(files);
								for(int i = 0;i<files.length;i++) {
									if((jList.get(i).get("id")).equals(ga.getID())) {
										System.out.println("내 순위 : " + (i+1) +"위");
									}
								}
								
								//while 문 종료
								checkRank = false;
							}else {//비밀번호를 틀릴경우
								count++;//비밀번호를 틀린 횟수 카운트
								if(count>2) {//틀린횟수가 3회 이상이라면 시스템 종료
									System.out.println("비밀번호를 3회 틀렸습니다. 메인메뉴로 돌아갑니다.");
									checkRank = false;
								}
								System.out.println("비밀번호가 다릅니다. "+count+"/3");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else {//실제로 아이디가 존재하지 않는다면
						System.out.println("존재하지 않는 아이디입니다.");
					}
				}
				
			}else if(intX==5) {//전제 랭크 보기
				System.out.println("1. 승률로 정렬\n2. 게임수로 정렬");
				String strR = sc.nextLine();
				int intR = Integer.parseInt(strR);
				if(intR == 1) {//승률로 정렬
					System.out.println("1. 오름차순 정렬\n2. 내림차순 정렬");
					String strRR = sc.nextLine();
					int intRR = Integer.parseInt(strRR);
					if(intRR == 1) {//오름차순 정렬
						List<JSONObject> jList;
						try {
							jList = gr.winRateRankAsc(files);
							for(int i=0;i<files.length;i++) {
								System.out.println((i+1)+"위 : "+jList.get(i).get("id")+" 승률 : "+jList.get(i).get("winrate")+"%");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}else if(intRR == 2) {//내림차순 정렬
						List<JSONObject> jList;
						try {
							jList = gr.winRateRankDesc(files);
							for(int i=0;i<files.length;i++) {
								System.out.println((files.length - i)+"위 : "+jList.get(i).get("id")+" 승률 : "+jList.get(i).get("winrate")+"%");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}else {
						System.out.println("메인 메뉴로 돌아갑니다.");
					}
				}else if(intR == 2) {//총 게임수
					System.out.println("1. 오름차순 정렬\n2. 내림차순 정렬");
					String strRR = sc.nextLine();
					int intRR = Integer.parseInt(strRR);
					if(intRR == 1) {//오름차순 정렬
						List<JSONObject> jList;
						try {
							jList = gr.totalRankAsc(files);
							for(int i=0;i<files.length;i++) {
								System.out.println((i+1)+"위 : "+jList.get(i).get("id")+" 총 게임수 : "+jList.get(i).get("winrate"));
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}else if(intRR == 2) {//내림차순 정렬
						List<JSONObject> jList;
						try {
							jList = gr.totalRankDesc(files);
							for(int i=0;i<files.length;i++) {
								System.out.println((files.length - i)+"위 : "+jList.get(i).get("id")+" 총 게임수 : "+jList.get(i).get("winrate"));
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}else {
						System.out.println("메인 메뉴로 돌아갑니다.");
					}
				}else {
					System.out.println("메인 메뉴로 돌아갑니다.");
				}
			}else {
				System.out.println("프로그램을 종료합니다.");
				run=false;
			}
		}
	}
}
