package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1759 {
	private static int[] alpha;
	private static int[] password;
	private static int L, C;

	private static void combination(int cnt, int start) {
		if(cnt==L) {	// 문자를 L개 만큼 구성하였을때
			int cnt_mo = 0;
			int cnt_ja = 0;
			for(int p : password) {
				// 모음 개수 세기
				if(p=='a'-'a' || p=='e'-'a' || p=='i'-'a' || p=='o'-'a' || p=='u'-'a') cnt_mo++;
				// 자음 개수 세기
				else cnt_ja++;
			}
			if(cnt_mo>=1 && cnt_ja>=2) {	// 모음이 최소 1개이상, 자음이 최소 2개이상이라면
				for(int p : password) {
					System.out.print((char)(p+'a'));	// 패스워드 출력
				}
				System.out.println();
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			
			if(cnt==0 							// password 배열이 비어있거나
				|| password[cnt-1]<alpha[i]) {	// password의 마지막값이 새로 넣을 알파벳보다 앞순서라면
				password[cnt] = alpha[i];		// password에 현재 알파벳 추가
				combination(cnt+1, i+1);		// 현재 뽑은 자리의 뒤 범위안에서 재귀 다시 돌리기 
			} else {
				return;
			}
		}	
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());	// 비밀번호 자리 수 
		C = Integer.parseInt(st.nextToken());	// 후보 문자 수
		
		alpha = new int[C];
		password = new int[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			alpha[i] = st.nextToken().charAt(0)-'a';	// 입력받은 문자 숫자로 변환해서 int 타입 alpha 배열 생성
		}
		
		Arrays.sort(alpha);
		combination(0, 0);
	}
}
