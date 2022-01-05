import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		
		long num = N;
		while(true) {
			if(prime(num)) {
				System.out.println(num);
				if(palindrome(num)) {
					System.out.println(num);
					break;
				}
			}
			num++;
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

	private static boolean prime(long n) {
		// 0, 1인 경우, 소수 X
		if(n < 2) return false;
		
		// 그 외 숫자들에대해서는 1과 자기자신을 제외한 숫자로 나눠지는지 검사
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n % i == 0) {	// 나눠진다면 소수 X
				return false;
			}
		}
		return true;	// 나눠지지 않는다면 소수 O
	}
}
