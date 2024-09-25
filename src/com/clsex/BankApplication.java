package com.clsex;

import java.util.Scanner;

public class BankApplication {
	public static void main(String[] args) {
		int count = 0;
		boolean run = true;
		//Rtype 배열은 값으로 해당 타입이나 해당 타입의 자식타입의 객체를 값으로 관리하겠다는 의미
		Account[] accounts = new Account[100];
		
		while(run) {
			System.out.println("-----------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
			System.out.println("-----------------------");
			
			
			Scanner scanner = new Scanner(System.in);
			String strX = scanner.nextLine();
			int x = Integer.parseInt(strX);
			
			System.out.println("선택 : "+x);
			
			if(x==1) {
				System.out.println("이름을 입력하세요");
				String strN = scanner.nextLine();
				accounts[count] = new Account(count+1,strN,(int)(Math.random()*10000));
				System.out.println("계좌가 생성되었습니다.\n--------------\n"+accounts[count]);
				count++;
			}
			
			if(x==2) {
				System.out.println("계좌 목록 : ");
				for(int i = 0;i<count;i++) {
					System.out.println(accounts[i]);
					System.out.println("------------------");
				}
				System.out.println("계좌번호를 입력하세요.");
				String strAcc = scanner.nextLine();
				int acco = Integer.parseInt(strAcc);
				if(acco<count+1&&acco>0) {
					System.out.println("선택된 계좌 : "+accounts[acco-1]);
					System.out.println("1.예금|2.출금|3.처음으로");
					String strChoice = scanner.nextLine();
					int choice = Integer.parseInt(strChoice);
					
					if(choice==1) {
						System.out.println("예금\n예금할 금액을 입력하세요.");
						String strY = scanner.nextLine();
						int y = Integer.parseInt(strY);
						System.out.println("계좌번호 : "+ accounts[acco-1].getAccountNumb() + "\n예금액 : " + y);
						accounts[acco-1].setDeposit(y);
					}else if(choice==2) {
						System.out.println(" 출금\n출금할 금액을 입력하세요.");
						String strZ = scanner.nextLine();
						int z = Integer.parseInt(strZ);
						System.out.println("계좌번호 : "+ accounts[acco-1].getAccountNumb() + "\n출금액 : " + z);
						accounts[acco-1].setWithdraw(z);
					}else if(choice==3){
						
					}else{
						System.out.println("숫자를 정확히 입력해 주세요.");
					}
				}else {
					System.out.println("계좌번호를 정확히 입력해주세요.");
				}
			}
			
			if(x==3) {
				if(count==0) {
					System.out.println("계좌를 생성해주세요.");
				}else {
					System.out.println("계좌 목록 : ");
					for(int i = 0;i<count;i++) {
						System.out.println(accounts[i]);
						System.out.println("------------------");
					}
					System.out.println("예금할 계좌의 계좌번호를 입력하세요.");
					String strAcc = scanner.nextLine();
					int accou = Integer.parseInt(strAcc);
					if(accou<count+1&&accou>0) {
						System.out.println("선택된 계좌 : "+accounts[accou-1]);
						System.out.println("예금할 금액을 입력하세요.");
						String deposit11 = scanner.nextLine();
						int deposit1 = Integer.parseInt(deposit11);
						System.out.println("계좌번호 : "+ accounts[accou-1].getAccountNumb() + "\n예금액 : " + deposit1);
						accounts[accou-1].setDeposit(deposit1);
					}else {
						System.out.println("계좌번호를 정확히 입력해주세요.");
					}
				}
			}
			
			if(x==4) {
				if(count==0) {
					System.out.println("계좌를 생성해주세요.");
				}else {
					System.out.println("계좌 목록 : ");
					for(int i = 0;i<count;i++) {
						System.out.println(accounts[i]);
						System.out.println("------------------");
					}
					System.out.println("출금할 계좌의 계좌번호를 입력하세요.");
					String strAcc = scanner.nextLine();
					int accoun = Integer.parseInt(strAcc);
					if(accoun<count+1&&accoun>0) {
						System.out.println("선택된 계좌 : "+accounts[accoun-1]);
						System.out.println("출금할 금액을 입력하세요.");
						String withdraw11 = scanner.nextLine();
						int withdraw1 = Integer.parseInt(withdraw11);
						System.out.println("계좌번호 : "+ accounts[accoun-1].getAccountNumb() + "\n출금액 : " + withdraw1);
						accounts[accoun-1].setWithdraw(withdraw1);
					}else {
						System.out.println("계좌번호를 정확히 입력해주세요.");
					}
				}
			}
			
			if(x==5) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
		}
	}
}

