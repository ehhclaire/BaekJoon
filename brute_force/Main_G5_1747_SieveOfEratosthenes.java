package boj.Gold;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 
- 에라스토테네스의 체

	1. 2부터 소수를 구하고자 하는 구간의 모든 수를 나열한다.
	2. 2는 소수이다.
	3. 자기 자신을 제외한 2의 배수를 모두 지운다.
	4. 남아있는 수 가운데 3은 소수이다.
	5. 자기 자신을 제외한 3의 배수를 모두 지운다.
	6. 남아있는 수 가운데 5는 소수이다.
	7. 자기 자신을 제외한 5의 배수를 모두 지운다.
	8. 남아있는 수 가운데 7은 소수이다.
	9. 자기 자신을 제외한 7의 배수를 모두 지운다.
	10. 위의 과정을 반복하면 구하는 구간의 모든 소수가 남는다.

*/

public class Main_G5_1747_아리스토테네스의체 {
	static boolean[] prime;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		prime = new boolean[1004001];
		setPrime();		// 소수는 false, 소수가 아니라면 true로 세팅

		for(int i=N; i<1004001; i++) {
			if(prime[i]) continue;		// prime[i]가 true 즉, 소수가 아니라면 skip
			
			if(palindrome(i)) {	
				System.out.println(i);
				break;
			}	
		}
	}

	private static void setPrime() {
		prime[0] = prime[1] = true;
		
		// 에라스토테네스의 체를 이용한 소수 판별
		for(int i=2; i<1004001; i++) {
			for(int j=2; i*j<1004001; j++) {
				prime[i*j] = true;
			}
		}
	}

	// 팰린드롬 판별 함수
	private static boolean palindrome(long n) {
		String number = Long.toString(n);
		int len = number.length();
		
		Stack<Character> stack = new Stack<Character>();
		
		// 정수의 반만큼 stack에 추가
		for(int i=0; i<len/2; i++) {
			stack.push(number.charAt(i));
		}
		
		// 홀수라면 반(half) 다음 인데스부터, 짝수라면 반(half)이 되는 인덱스부터 
		for(int i=len/2 + len%2; i<len; i++) {
			if(stack.pop() != number.charAt(i)) return false;	// stack에서 하나씩 뽑으면서 현재의 문자와 일치하지않으면 팰린드롬이 아니다.
		}
		
		return true;
	}
}