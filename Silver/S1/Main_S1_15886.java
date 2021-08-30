package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S1_15886 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[] inputs = br.readLine().toCharArray();
		int cnt = 0;	// 최소로 놓아야하는 칸 수
		for(int i=1; i<N; i++) {
			if(inputs[i-1]=='E' && inputs[i]=='W') cnt++;	// EW인 구간을 찾으면 거기에 선물을 하나 놓으면 무조건 가져간다
		}
		System.out.println(cnt);
	}
}
