package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1753 {
	
	static class Node {
		int vertex;
		int weight;
		Node link;
		
		public Node(int vertex, int weight, Node link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
		
		@Override
		public String toString() {
			return "Node [vertex=" + vertex +", weight=" + weight + ", link=" + link + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());		// 정점 수
		int E = Integer.parseInt(st.nextToken());		// 간선 수

		Node[] adjList = new Node[V];			// 인접 리스트
		boolean[] visited = new boolean[V];		// 정점에 대한 방문 처리를 위한 배열
		int[] distance = new int[V];
		
		int start = Integer.parseInt(br.readLine())-1;	// 시작 정점
		
		// 정점에 대한 인접 정보 입력
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			// 정점 u에서 정점 v로 가는 가중치 w 정보 입력 받기
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			adjList[u] = new Node(v, w, adjList[u]);
		}
		
		// 정점의 최소 비용을 갱신하기 위해 초기 값을 max로 설정
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		// 시작 정점의 비용을 0으로 설정
		distance[start] = 0;
		
		// 각 정점 수만큼 반복하여 최소 비용 찾기
		int min = 0, curr = start;
		for(int i=0; i<V; i++) {
			min = Integer.MAX_VALUE;
			// 방문하지 않은 정점 중에서 최소 비용의 정점 선택
			for(int j=0; j<V; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					curr = j;
				}
			}
			
			// 최소 비용으로 선택된 정점을 방문 처리
			visited[curr] = true;
			
			// 기존의 비용과 선택한 정점(경유지)를 통해 가는 비용 중 더 적은 비용으로 갱신
			for(Node tmp = adjList[curr]; tmp != null; tmp = tmp.link) {
				if(!visited[tmp.vertex] && distance[tmp.vertex]>min+tmp.weight) {
					distance[tmp.vertex] = min+tmp.weight;
				}
			}
		}
		for(int d : distance) {
			if(d!=Integer.MAX_VALUE) System.out.println(d);
			else {
				System.out.println("INF");
			}
		}		
	}
	static String src = "5 6\r\n" + 
			"1\r\n" + 
			"5 1 1\r\n" + 
			"1 2 2\r\n" + 
			"1 3 3\r\n" + 
			"2 3 4\r\n" + 
			"2 4 5\r\n" + 
			"3 4 6";
}
