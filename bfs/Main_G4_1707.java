package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1707 {
	static int V, E;
	static int[][] map;
	static int[] numbers;
	static int[] others;
	static boolean isValid;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트케이스 수
		
		for(int testcase=1; testcase<=T; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());		// 정점의 수
			E = Integer.parseInt(st.nextToken());		// 간선의 수
			
			map = new int[V+1][V+1];	// 정점의 인접정보를 저장할 배열 (정점 번호를 맞추기 위해 0행, 0열은 사용 X)			
			
			isValid = false;	// 이분그래프인지를 따져보기위한 boolean 변수 (이분그래프 : true, 이분그래프가 아니다 : false)
			
			// 간선의 개수만큼 입력정보를 받아 2차원배열 map에 각 정점이 인접하다면 1표시
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());	// 정점 1
				int v2 = Integer.parseInt(st.nextToken());	// 정점 2
				map[v1][v2] = map[v2][v1] = 1;	// 정점1과 정점2 사이에 간선이 존재함으로 인접 표시 1
			}
			
			for(int r=1, end=V/2; r<=end; r++) {
				numbers = new int[r];	// 뽑은 요소들을 저장할 배열
				others = new int[V-r];	// 뽑지 않은 정점들을 저장할 배열
				combination(V, r);	// V중에 r개를 뽑는 조합
				if(isValid) break;	// 이분 그래프가 아니라면 더이상 탐색하지 않고 탈출
			}
			
			if(isValid) System.out.println("YES");
			else System.out.println("NO");
		}		
	}

	private static void combination(int n, int r) {
		if(r==0) {	// r개만큼 다 뽑았다면
			for(int i=0, end=numbers.length; i<end; i++) {
				visited = new boolean[V+1];		// 정점 방문 여부 체크 배열
				check(numbers[i]);	// 해당 점점에서 연결가능한지를 테스트
			}
			return;
		}
		if(n<r) return;
		
		numbers[r-1] = n;
		combination(n-1, r-1);
		combination(n-1, r);
	}

	private static void check(int curr) {
		for(int i=0, end=numbers.length; i<end; i++) {
			if(curr==i) continue;			// 두 정점이 같다면 (1->1), 무시
			if(map[i][curr]!=1) isValid = true;	// 두 정점 사이에 간선이 존재한다면, true
		}
	}
}