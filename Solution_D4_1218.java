package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1218 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		
		for(int testcase=1; testcase<=10; testcase++) {
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split("");
			int result=1;
			
			int j;
			for(j=0; j<n; j++) {
				// 스택이 비거나 괄호 왼쪽 부분이라면 스택에 현재 값 저장
				if(input[j].equals("(") || input[j].equals("[") || input[j].equals("{") || input[j].equals("<") ||stack.isEmpty()) {
					stack.add(input[j]);
				} else {	
					// 입력 값이 괄호 오른쪽 부분이라면 같은 세트인지 확인 후 아니라면 result 0 저장 후 반복 탈출
					if(input[j].equals(")")){
						if(!stack.pop().equals("(")) {
							result = 0;
							break;
						}
					} else if(input[j].equals("]")){
						if(!stack.pop().equals("[")) {
							result = 0;
							break;
						}
					} else if(input[j].equals("}")){
						if(!stack.pop().equals("{")) {
							result = 0;
							break;
						}
					} else if(input[j].equals(">")){
						if(!stack.pop().equals("<")) {
							result = 0;
							break;
						}
					}
				}
			}
			
			// 결과 출력
			System.out.println("#"+testcase+" "+result);
			stack.clear();	// 다음 테스트케이스를 위해 stack 비우기
		}
	}
}	  