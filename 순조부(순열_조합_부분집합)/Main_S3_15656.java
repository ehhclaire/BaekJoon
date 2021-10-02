package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_S3_15656 {
	static int n, r;
	static int[] numbers;
	static int[] inputs;
	static StringBuilder sb;
	
	private static void permutation(int cnt){

		if(cnt==r) {
			for(int num : numbers) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<n; i++) {
			numbers[cnt] = inputs[i];
			permutation(cnt+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		numbers = new int[r];
		sb = new StringBuilder();
		
		inputs = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(inputs);
		
		permutation(0);
		
		System.out.println(sb);
	}
}
