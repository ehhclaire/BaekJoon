package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S5_1316 {

	public static void main(String[] args) throws Exception {
		// 1. 풀이 1
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());	// 단어의 개수
//		int cnt = 0;	// 그룹 단어 수
//		
//		for(int i=0; i<N; i++) {
//			char[] inputs = br.readLine().toCharArray();
//			boolean valid = true;
//			int flag = 0;
//			
//			flag = flag | 1 << (inputs[0]-'a');
//			for(int j=1; j<inputs.length; j++) {
//				if(inputs[j-1]!=inputs[j] && ((flag & 1 << (inputs[j]-'a'))!=0)) {
//					valid = false;
//					break;
//				}
//				flag = flag | 1 << (inputs[j]-'a');
//			}
//			if(valid) {
//				System.out.println(Arrays.toString(inputs));
//				cnt++; 
//			}
//
//		}
//		System.out.println(cnt);
		
		// 2. 풀이 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 단어의 개수
		int cnt = 0;	// 그룹 단어 수
		
		for(int i=0; i<N; i++) {
			char[] inputs = br.readLine().toCharArray();
			boolean[] visited = new boolean[26];			// 사용 단어 체크
			boolean valid = true;
			
			visited[inputs[0]-'a'] = true;
			for(int j=1; j<inputs.length; j++) {
				if(inputs[j-1]!=inputs[j] && visited[inputs[j]-'a']) {
					valid = false;
					break;
				}
				visited[inputs[j]-'a'] = true;
			}
			if(valid) cnt++; 

		}
		System.out.println(cnt);
	}
}
