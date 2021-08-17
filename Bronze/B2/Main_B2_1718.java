package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B2_1718 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] plainText = br.readLine().toCharArray();		// 평문 입력
		char[] key = br.readLine().toCharArray();			// 암호화 키 입력

		int p_size = plainText.length;
		int k_size = key.length;
				
		for(int i=0; i<p_size; i++) {	// 평문 사이즈만큼
			int diff = plainText[i]-key[(i)%k_size]-1;		// 평문 문자 - 키 문자 - 1는 두 문자의 차이
			
			if(plainText[i]==' ') {		// 평문이 공백문자(space)라면 
				System.out.print(" ");	// 공백문자(space) 출력
			} else if(diff>=0) {		// 위의 diff가 양수라면
				System.out.print((char)('a'+diff));		// 알파벳 앞순서(a)부터 diff 만큼 이동한 문자 출력
			} else {					// 위의 diff가 양수라면, z로 돌아가서 생각해줘야한다
				System.out.print((char)('z'+diff+1));	// 알파벳 뒷순서(z)부터 idff+1 만큼 이동한 문자 출력
			}
		}
	}
}