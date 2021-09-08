package boj.Silver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main_S5_5568 {
	static int n, k;		
	static int[] inputs;	// 처음 입력 정수 배열
	static int[] numbers;
	static boolean[] visited;
	static HashMap<String, Integer> list = new HashMap<String, Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		inputs = new int[n];
		visited = new boolean[99];
		numbers = new int[k];
		
		for(int i=0; i<n; i++) {
			inputs[i] = sc.nextInt();
		}
		
		permutation(0);	// 가능한 모든 순열 구하기
		
		System.out.println(list.size());
		
	}

	private static void permutation(int cnt) {
		if(cnt == k) {
			String src = "";
			for(int i=0; i<k; i++) {
				src += numbers[i];		// 만든 경우를 String으로 합치기
			}
			list.put(src, 1);			// 합쳐진 String을 HashMap에 저장
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			
			numbers[cnt] = inputs[i];
			visited[i] = true;
			permutation(cnt+1);
			visited[i] = false;			
		}
	}
}
