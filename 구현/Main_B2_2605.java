package boj.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_B2_2605 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> list = new LinkedList<Integer>();	// 학생들을 줄 세울 list
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			if(i==0) {	// 첫번째 입력은 0번째에 학생번호 1 입력
				list.add(Integer.parseInt(st.nextToken()), i+1);
			} else {	// 나머지는 해당입력자리 - 입력 숫자의 인덱스에 학생번호 i+1 입력
				list.add(i-Integer.parseInt(st.nextToken()), i+1);
			}
		}
		for(int i=0; i<N; i++) {
			System.out.print(list.poll()+ " ");
		}
	}
}
