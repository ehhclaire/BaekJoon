package boj.Silver;
/**
 * 인접 행렬을 활용한 DFS, BFS
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_S2_1260 {
	static int N;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 정점 개수
		int M = sc.nextInt();	// 간선 개수
		int V = sc.nextInt();	// 시작 정점 번호
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int l=0; l<M; l++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			graph[r][c] = graph[c][r] = 1;
		}
		
		dfs(V);
		System.out.println();
		
		// bfs 탐색을 위해 visited 배열 초기화
		Arrays.fill(visited, false);	
		bfs(V);
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(v);	// 시작 노드 queue에 할당
		visited[v] = true;	// 방문 표시
		
		while(!queue.isEmpty()) {	// queue가 빌 때까지
			v = queue.poll();	// queue에서 하나 꺼내와서 
			System.out.print(v + " ");	// 출력
			
			for(int adj=1; adj<=N; adj++) {	// 인접 노드를 방문하며
				// 두 노드에 간선이 존재하면서 아직 방문하지 않은 인접노드라면
				if(graph[v][adj]==1 && !visited[adj]) {
					queue.offer(adj);	// queue에 넣고 
					visited[adj] = true;	// 방문 표시
				}
			}
		}
	}

	private static void dfs(int v) {
		visited[v] = true;		// 방문 여부 표시
		System.out.print(v + " ");	

		for(int adj=1; adj<=N; adj++) {	// 인접노드를 탐색하며
			// 간선이 존재하면서 아직 방문하지 않은 노드라면
			if(graph[v][adj]==1 && !visited[adj]) {	
				dfs(adj);	// 그 길로 더 들어가보기
			}
		}
	}
}
