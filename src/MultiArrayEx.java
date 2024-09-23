
public class MultiArrayEx {
	public static void main(String[] args) {
		/*
		 * 다중 배열 : 배열의 내부에 배열을 위치하도록 하는 문법
		 * 일반적으로는 2차원 배열정도만 자주 사용하고, 특별한 경우가 아닌 경우엔 그 이상은 사용하지 않음.
		 * 다중 배열은 Outer 배열의 index 에 내부(inner) 배열을 ref 하는 형태를 뜻함.
		 * 머릿속에 Ref 를 생각하면서 이해하면 됨.
		 */
		
		int[] multiArr[] = {{1,2,3},{10,20,30}}; //Outer 는 2개의 length, inner 은 3개의 length 를 갖는 배열 생성.
		
		//outer 배열 접체를 접근 하도록 함.
		for(int i = 0; i<multiArr.length; i++) {
			for(int j = 0; j<multiArr[i].length; j++) {
				System.out.println(multiArr[i][j]);
			}
		}
		
		//배열의 [] 표식자는 어떤 위치에 오던 상관 없음.
		int[][] scores = {{80,90,96},{76,88}};
		
		//위 점수 배열을 기준으로 아래의 결과를 도출하도록 작성하세요.
		
		//각 배열의 값은 하나의 반 학생들의 점수로 가정.
		//1. 첫번째 반과 두번째 반 학생들의 평균 점수를 각각 출력하세요.
		//2. 전체학생의 평균 점수를 구해서 출력하도록 하세요.
		
		double avg1 = 0;
		double avg2 = 0;
		double avg = 0;
		
		for(int i = 0; i<scores[0].length; i++) {
			avg1 += scores[0][i];
		}
		for(int i = 0; i<scores[1].length; i++) {
			avg2 += scores[1][i];
		}
		for(int i = 0; i<scores.length; i++) {
			for(int j = 0; j<scores[i].length; j++) {
				avg += scores[i][j];
			}
		}
		avg1 = avg1/scores[0].length;
		avg2 = avg2/scores[1].length;
		avg = avg/(scores[0].length+scores[1].length);
		
		System.out.println(avg1);
		System.out.println(avg2);
		System.out.println(avg);
		
		int[][] mArr = new int[2][3];//outer 2개 inner 각 3개의 멀티배열 생성
		
		mArr[1][2] = 1991;
		
		//동적 가변배열 생성하기
		//이 배열식은 Outer 의 크기는 미리 정해두고 inner 배열을 동적으로 생성할 때 사용함.
		
		char[] star[] = new char[10][]; //outer 10개 배열 생성 inner 은 객체이기 때문에 동적 생성 가능
		for(int i = 0; i<star.length;i++) {
			//inner 배열 동적 생성
			star[i] = new char[i+1];
			for(int j = 0; j<star[i].length;j++) {
				star[i][j] = '*';
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
	}
}
