package boj.Gold;

import java.util.Scanner;
import java.util.Stack;

/** 
 * 반례
 * 
6 2
391123
//output : 9123

6 2
436436
//output : 6436

7 3
7654321
//output : 7654

6 2
362514
//output : 6514

6 4
198794
//output : 99

 *
 */

public class Main_G4_2812 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 입력 정수 길이	
		int K = sc.nextInt();	// 지울 정수 개수
		
		Stack<Character> stack = new Stack<Character>();	// 최종 숫자를 담을 stack
		
		String number = sc.next();	// 입력 정수
		
		stack.push(number.charAt(0));	// 입력 숫자의 제일 처음 숫자를 stack에 push
		
		for(int i=1; i<N; i++) {
			if(stack.peek()>=number.charAt(i) && stack.size()==N-K) continue;
			
			if(stack.peek()<number.charAt(i)) {
				while(!stack.isEmpty() && (stack.size()+N-i > N-K) && stack.peek()<number.charAt(i)) stack.pop();
			}
			stack.push(number.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.reverse().toString());
	}
}
