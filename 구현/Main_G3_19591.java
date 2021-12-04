package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Main_G3_19591 {
	static Deque<Character> operator;
	static Deque<Long> number;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		List<Character> priority = Arrays.asList('+','-','*','/');
				
		operator = new ArrayDeque<>();
		number = new ArrayDeque<>();

		// 입력에따라 피연산자와 연산자를 number, operator Deque에 각각 저장
		/* 입력 시작 */
		String str = br.readLine();
		String num = "";
		boolean negative = false;
		if(str.charAt(0)=='-') negative = true;
		for(int i=0; i<str.length(); i++) {
			if(i==0 && negative) continue;
			else if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*' || str.charAt(i)=='/') {
				operator.offer(str.charAt(i));
				if(negative) {
					number.offer(Long.parseLong(num)*(-1));
					negative = false;
				} else {
					number.offer(Long.parseLong(num));
				}
				num = "";
			} else {
				num += str.charAt(i);
			}
		}
		if(!num.equals("")) {
			if(negative) number.offer(Long.parseLong(num)*(-1));
			else number.offer(Long.parseLong(num));
		}
		/* 입력 끝 */
		
		while(!operator.isEmpty()) {
			if(operator.size()>2) {		// 연산자 3개이상, 피연산자 4개이상인 경우
				long a1 = number.pollFirst();
				long b1 = number.pollFirst();
				char op1 = operator.pollFirst();
				
				long b2 = number.pollLast();
				long a2 = number.pollLast();
				char op2 = operator.pollLast();
				
				// 1. 연산자 우선순위 비교
				if(priority.indexOf(op1)/2 > priority.indexOf(op2)/2) {		// 앞쪽 연산자가 우선순위가 더 높은 경우
					number.offerFirst(calculate(a1, b1, op1));
					number.offerLast(a2);
					number.offerLast(b2);
					operator.offerLast(op2);
				} else if(priority.indexOf(op1)/2 < priority.indexOf(op2)/2) {	// 뒤쪽 연산자가 우선순위가 더 높은 경우
					number.offerLast(calculate(a2, b2, op2));
					number.offerFirst(b1);
					number.offerFirst(a1);
					operator.offerFirst(op1);
				} else {
					// 2. 연산자 우선순위가 같은 경우, 값 비교
					long result1 = calculate(a1, b1, op1);
					long result2 = calculate(a2, b2, op2);
					if(result1>=result2) {		// 앞쪽 연산 결과가 더 큰 경우 or 두개 결과가 같은경우에도 앞쪽 처리
						number.offerFirst(calculate(a1, b1, op1));
						number.offerLast(a2);
						number.offerLast(b2);
						operator.offerLast(op2);
					} else {					// 뒤쪽 연산 결과가 더 큰 경우
						number.offerLast(calculate(a2, b2, op2));
						number.offerFirst(b1);
						number.offerFirst(a1);
						operator.offerFirst(op1);
					}
				}
			} else if(operator.size()==2) { 		// 연산자 2개, 피연산자 3개인 경우
				long a1 = number.pollFirst();
				long b1 = number.pollFirst();
				char op1 = operator.pollFirst();
				
				long b2 = number.pollLast();
				long a2 = b1;
				char op2 = operator.pollLast();
				
				// 1. 연산자 우선순위 비교
				if(priority.indexOf(op1)/2 > priority.indexOf(op2)/2) {		// 앞쪽 연산자가 우선순위가 더 높은 경우
					number.offerFirst(calculate(a1, b1, op1));
					number.offerLast(b2);
					operator.offerLast(op2);
				} else if(priority.indexOf(op1)/2 < priority.indexOf(op2)/2) {		// 뒤쪽 연산자가 우선순위가 더 높은 경우
					number.offerLast(calculate(a2, b2, op2));
					number.offerFirst(a1);
					operator.offerFirst(op1);
				} else {
					// 2. 연산자 우선순위가 같은 경우, 값 비교
					long result1 = calculate(a1, b1, op1);
					long result2 = calculate(a2, b2, op2);
					if(result1>=result2) {		// 앞쪽 연산 결과가 더 큰 경우 or 두개 결과가 같은경우에도 앞쪽 처리
						number.offerFirst(calculate(a1, b1, op1));
						number.offerLast(b2);
						operator.offerLast(op2);
					} else {					// 뒤쪽 연산 결과가 더 큰 경우
						number.offerLast(calculate(a2, b2, op2));
						number.offerFirst(a1);
						operator.offerFirst(op1);
					}
				}
			} else {		// 연산자 1개, 피연산자 2개인 경우
				number.offer(calculate(number.pollFirst(), number.pollFirst(), operator.pollFirst()));
			}
		}
		System.out.println(number.poll());
	}
	
	// 연산자에 따라서 수식 계산
	private static long calculate(long a, long b, char op) {
		if(op=='+') {
			return a+b;
		} else if(op=='-') {
			return a-b;
		} else if(op=='*') {
			return a*b;
		} else {
			return a/b;
		}
	}
	static String src = "3*2+5-5+7";
}
