package boj.Silver;

import java.util.Scanner;

public class Main_S2_11724 {
	static boolean[] visited;
	static int N;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 정점의 개수
		int M = sc.nextInt();	// 간선의 개수
		
		map = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			map[n1][n2] = map[n2][n1] = 1;
		}
		
		visited = new boolean[N+1];
		int cnt = 0;
		
		for(int i=1; i<=N; i++) {
			if(!visited[i])	{
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void dfs(int i) {
		visited[i] = true;
		
		for(int adj=1; adj<=N; adj++) {
			if(map[i][adj]==1 && !visited[adj]) {
				dfs(adj);
			}
		}		
	}
}
