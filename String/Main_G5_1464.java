package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_G5_1464 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String str = br.readLine();		
		
		int i=1;
		while(true) {
			if(i==str.length()) break;	// 인덱스가 문자열 길이와 같아지면 탈출
			
			// 인덱스 i번째의 문자가 0번째 문자보다 우선순위가 높고 && i번째와 i-1번째 문자가 같지 않다면
			if(str.charAt(0)>=str.charAt(i) && str.charAt(i)-str.charAt(i-1) != 0) {
				str = reverse(str, i-1);	// 0 ~ i-1 자리의 문자열을 reverse
				str = reverse(str, i);		// 0 ~ i 자리의 문자열을 reverse
			}
			i++;	// 비교 인덱스 증가
		}
		System.out.println(str);
	}
	
	// 인덱스 0 ~ num 까지 문자열 뒤집기
	private static String reverse(String str, int num) {
		StringBuilder sb = new StringBuilder();
		sb.append(str.substring(0, num+1));
		sb = sb.reverse();
		
		// 남은 부분 그대로 StringBuilder에 이어 붙이기
		if(num+1 <= str.length()) sb.append(str.substring(num+1, str.length()));
	
		return sb.toString();
	}	
}
