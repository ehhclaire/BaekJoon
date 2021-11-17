package boj.Silver;

import java.io.StringReader;
import java.util.Scanner;

public class Main_S1_1105 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(new StringReader(src));
		
		String L = sc.next();
		String R = sc.next();
		
		int min = 0;
		
		// 제일 작은 수와 큰수의 자리수가 다르면 무조건 8이 없는 값이 존재한다. 
		// 따라서, 같은 자리수를 가진 애들만 체크해주면 된다.
		if(L.length() == R.length()) {		
			for(int i=0; i<L.length(); i++) {
				if(L.charAt(i) == R.charAt(i)) {	// 앞 자리수부터 비교하면서 같을때
					if(L.charAt(i)=='8') min++;		// 같은 값이 8이라면, min 증가
				} else {		// 다른 값인 경우 반복 탈출
					break;
				}
			}	
		}
		System.out.println(min);
	}
	static String src = "1 10";
}
