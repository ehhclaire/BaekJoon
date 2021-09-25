package boj.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S3_15651 {
	static int n, r;
	static int[] numbers;
	static StringBuilder sb;
	
	private static void duplicate_permutation(int cnt){

		if(cnt==r) {
			for(int num : numbers) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
			numbers[cnt] = i;
			duplicate_permutation(cnt+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		numbers = new int[r];
		sb = new StringBuilder();
		
		duplicate_permutation(0);
		
		System.out.println(sb);
	}
}
