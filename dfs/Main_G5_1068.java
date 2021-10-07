package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1068 {
	static int N, parents[], answer;
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
	
		N = Integer.parseInt(br.readLine());
		
		parents = new int[N];		// 각 노드별로 부모 노드 정보 저장
		visited = new boolean[N];	// 리프 노드 탐색 시, 방문 표시
		int root = 0;	// 루트 노드 번호 저장 변수
		answer = 0;		// 리프 노드 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int node = Integer.parseInt(st.nextToken());
			parents[i] = node;		// 부모 노드 번호 저장 
			if(node==-1) root = i;	// 루트 노드 번호 저장
		}
		
		int kill = Integer.parseInt(br.readLine());	// 제거할 노드 번호
		remove(kill);	// 노드 제거
		dfs(root);		// root 노드에서부터 아래로 탐색하여 leaf 수 세기
		
		System.out.println(answer);
	}

	// 1. 노드 제거
	private static void remove(int kill) {
		parents[kill] = -2;	// 제거된 노드는 -2로 표시
		
		for(int i=0; i<N; i++) {
			if(parents[i]==kill) {
				remove(i);
			}
		}
	}
	
	// 2. 리프 노드 수 세기
	private static void dfs(int node) {
		visited[node] = true;
		boolean isLeaf = true;
		
		if(parents[node]!=-2) {	// 제거된 노드가 아니라면
			for(int i=0; i<N; i++) {	
				if(parents[i] == node) {	// 내려갈 수 있으면
					dfs(i);	// 해당 노드로 내려가기
					isLeaf = false;	// 내려갈 노드가 있다면 리프노드가 아님
				}
			}
			if(isLeaf) answer++;	// 더이상 내려갈 노드가 없다면, 리프노드
		}
	}

	static String src = "5\r\n" + 
			"-1 0 0 1 1\r\n" + 
			"2";
}
