package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_S2_15664 {
	static int N, M;
	static int[] inputs;
	static int[] numbers;
	static Set<String> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inputs = new int[N];
		numbers = new int[M];
		set = new LinkedHashSet<String>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
				
		
		Arrays.sort(inputs);
		
		combination(0, 0);
		
		StringBuilder sb2 = new StringBuilder();
        for(String list : set) {
            sb2.append(list).append("\n");
        }
        System.out.println(sb2);

	}

	// 순열
	private static void combination(int cnt, int start) {
		if(cnt==M) {	// nCm
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			set.add(sb.toString());	// set을 이용한 중복 요소 제거
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = inputs[i];
			combination(cnt+1, i+1);
		}
	}
}
