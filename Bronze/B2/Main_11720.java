package BOJ;

import java.util.Scanner;

public class Main_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int sum = 0;
		
		String num = sc.next();		// 숫자 문자열 입력받기
		
		// 숫자 문자열 하나하나 쪼개서 int로 형변환
		for(int i=0; i<num.length(); i++) {
			sum += Integer.parseInt(num.substring(i,i+1));
		}
		System.out.println(sum);
	}
}
