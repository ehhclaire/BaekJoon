package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

// (100~1~|01)~
public class Main_G5_2671 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().trim();		// 입력 신호		
		
		while(true) {

			if(str.length()==0) break;		// 종료조건(1) : 입력 문자열의 길이가 0이 되면 종료

			boolean flag1 = true;
			boolean op1 = true;
			boolean op2 = true;
			
			// 1. (100~1~) 에 대해서
			
			// 1) "10" 처리
			if(str.length()>=4 && str.substring(0, 2).equals("10")) {
				str = str.substring(2, str.length());	// 10 패턴을 뛰면 그만큼 자른다
				
				// 2) "0" 처리
				if(str.length()>0 && str.charAt(0)=='0') str = str.substring(1, str.length());	// 다음이 0이면 1개 일단 자르고
				else op1 = false;	// 다음에 0이 안오면 규칙에 어긋나니깐 false 처리
				
				// 0이 계속될 때가지 0 제거
				while(str.length()>0 && str.charAt(0)=='0') {		
					str = str.substring(1, str.length());
				}

				// 3) "1" 처리
				if(str.length()>0 && str.charAt(0)=='1') str = str.substring(1, str.length());	// 다음이 1이면 1개 일단 자르고 
				else op2 = false;	// 다음에 1이 안오면 규칙에 어긋나니깐 false 처리

				// 1이 계속될 때까지 1제거
				while(str.length()>0 && str.charAt(0)=='1') {
					// 만약 현재 1을 기준으로 남은 문자열의 패턴이 100를 보이면, 1을 제거하면 안되고 다음 바퀴에서 10을 제거해야한다.
					if(str.length()>=3 && !str.substring(0,3).equals("100")) str = str.substring(1, str.length());	
					// 만약 남은 문자열의 길이가 3보다 작다면 그냥 1 제거
					else if(str.length()<3) str = str.substring(1, str.length());
					// 위의 두개를 다 만족하지 않는다면 무한 루프돌기 때문에 탈출
					else break;
				}
				
				// 위의 탐색을 하던 중 0~이나 1~을 만족하지 않는 경우는 패턴에 어긋나는 경우로, 반복문을 탈출
				// 현재 문자열이 비어있을 수 있으므로 NOISE를 출력할 수 있도록 문자열에 "1" 추가 
				if(!op1 || !op2) {
					str = "1";
					break;
				}
			} else {		// "(100~1~)" 패턴을 띄지 않는 경우, 미사용 표시
				flag1 = false;
			}
			
			// 2. (01) 에 대해서
			boolean flag2 = true;
			// "01" 처리
			if(str.length()>=2 && str.substring(0, 2).equals("01")) {
				str = str.substring(2, str.length());

			} else {	// "(01)" 패턴을 띄지 않은 경우, 미사용 표시
				flag2 = false;
			}
			
			// 종료조건(2) : 만약 패턴 두가지를 둘 다 사용하지 않은 경우는 더이상 문자열에서 패턴을 띄지 않는다는 말로, 반복 종료
			if(!flag1 && !flag2) {
				break;
			}			
		}
		System.out.println(str.length()==0 ? "SUBMARINE" : "NOISE");
	}
}
