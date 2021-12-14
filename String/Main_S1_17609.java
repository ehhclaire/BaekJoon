package boj.Gold;

import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;

public class Main_S1_17609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(new StringReader(src));
		int N = sc.nextInt();		// 입력 문자열
	
		for(int n=0; n<N; n++) {
			String str = sc.next();
			
			// 두 포인터 탐색을 위한 start, end
			int start = 0;
			int end = str.length()-1;
						
			int a = compare(str, start, end, 0);	// start, end 가 다른 경우, start를 증가시키는 경우
			int b = compare(str, start, end, 1);	// start, end 가 다른 경우, end를 감소시키는 경우
			
			System.out.println(Math.min(a, b));		// 둘 경우 중 결과가 작은 값을 출력
		}
	}	

	private static int compare(String str, int start, int end, int flag) {
		int answer = 0;
		
		while(true) {
			if(start > end) break;
			
			if(answer == 2) break;
			if(str.charAt(start) == str.charAt(end)) {
				start++;
				end--;
			} else {
				if(flag==0) {
					start++;
				} else {
					end--;
				}
				answer++;
			}
		}
		return answer;
	}

	static String src = "7\r\n" + 
			"abba\r\n" + 
			"summuus\r\n" + 
			"xabba\r\n" + 
			"xabbay\r\n" + 
			"comcom\r\n" + 
			"comwwmoc\r\n" + 
			"comwwtmoc";
}
