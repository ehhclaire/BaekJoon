package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S3_17413 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();		// 입력 문자열
		String answer = "";				// 결과 문자열
		
		int idx = 0;	// 인덱스 변수
		Stack<Character> stack = new Stack<Character>();	// 뒤집을 문자열을 저장할 stack
		while(idx<str.length()) {	// 입력 문자열을 다 읽을때까지
			if(str.charAt(idx)=='<') {	// < 가 입력되면
				while(!stack.isEmpty()) answer += stack.pop();	// 이전에 stack에 저장된 문자열이 있다면 뒤짚어서 결과에 입력
				while(str.charAt(idx)!='>') answer += str.charAt(idx++);	// > 가 입력될 때까지 순서대로 결과에 저장
				answer+=str.charAt(idx++);	// > 까지 저장해서 괄호 닫아주기
			} else if(str.charAt(idx)==' ') {	// space가 입력으로 들어오면
				while(!stack.isEmpty()) answer += stack.pop();	// 이전에 stack에 저장된 문자열이 있다면 결과에 입력
				answer += str.charAt(idx++);		// 현재 space 입력
			} else {
				stack.push(str.charAt(idx++));		// <나 space 입력이 아니면 문자열을 뒤짚기 위해 stack에 저장
			}
		}
		while(!stack.isEmpty()) answer += stack.pop();	// stack에 남아있는 문자열 뒤짚어서 결과에 저장
		System.out.println(answer.toString());
	}
}
