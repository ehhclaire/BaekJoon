package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S1_1446 {
	
	static class Node implements Comparable<Node> {
		int from;
		int to;
		int weight;
		
		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			int result = this.from - o.from;
			if(result==0) return this.to - o.to;
			return result;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 지름길 개수
		int destination = Integer.parseInt(st.nextToken());	// 도착지점
		
		List<Node> list = new ArrayList<Node>();	
				
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());	// 지름길 시작 위치
			int v = Integer.parseInt(st.nextToken());	// 지름길 끝 위치
			int w = Integer.parseInt(st.nextToken());	// 지름길 사용시 걸리는 시간
			
			if(v > destination) continue;		// 역주행 금지
			if(v-u <= w) continue;	// 사실상 지름길이 아님
			
			list.add(new Node(u, v, w));
		}
		
		// 지름길 오름차순 정렬
		Collections.sort(list);
		
		int[] distance = new int[destination+1];	// 최단 거리 저장 배열		
		Arrays.fill(distance, Integer.MAX_VALUE);	// 최소 거리를 구하기위해 max로 초기화
		
		distance[0] = 0;	// 0은 0
		
		int index = 0;
		int next = 0;
		while(next < destination) {
			if(index<list.size() && next == list.get(index).from) {
				distance[list.get(index).to] = Math.min(distance[list.get(index).to], distance[next]+list.get(index).weight); 
				index++;
			} else {
				distance[next+1] = Math.min(distance[next+1], distance[next]+1);
				next++;
			}
		}		
		
		System.out.println(distance[destination]);
	}
	static String src = "5 150\r\n" + 
			"0 50 10\r\n" + 
			"0 50 20\r\n" + 
			"50 100 10\r\n" + 
			"100 151 10\r\n" + 
			"110 140 90";
}
