package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S1_2564 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int width = Integer.parseInt(st.nextToken());	// 가로 길이
		int height = Integer.parseInt(st.nextToken());	// 세로 길이
		
		int N = Integer.parseInt(br.readLine());		// 상점의 개수
		LinkedList<int[]> list = new LinkedList<int[]>();			// 상점 좌표
		
		int distance = 0;		// 최단 거리의 합

		for(int i=0; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());	// 방향
			switch(direction) {
			case 1:		// 북쪽
				list.offer(new int[] {direction, Integer.parseInt(st.nextToken()), height});
				break;
			
			case 2:		// 남쪽
				list.offer(new int[] {direction, Integer.parseInt(st.nextToken()), 0});
				break;
				
			case 3:		// 서쪽
				list.offer(new int[] {direction, 0, height-Integer.parseInt(st.nextToken())});
				break;
				
			case 4:		// 동쪽
				list.offer(new int[] {direction, width, height-Integer.parseInt(st.nextToken())});
				break;
			}
		}

		// 동근이의 위치
		int[] tmp = list.pollLast();
		int dist = tmp[0];
		int x = tmp[1];
		int y = tmp[2];
		
		// 왼쪽으로 가는 경우와 오른쪽으로 가는경우 중 최단 거리
		for(int i=0; i<N; i++) {
			
			if(dist==1 && list.get(i)[0]==2 || dist==2 && list.get(i)[0]==1 ||
					dist==3 && list.get(i)[0]==4 || dist==4 && list.get(i)[0]==3) {	// 상점과 동근이의 위치가 반대편인 경우
				distance += Math.min(x+y+list.get(i)[1]+list.get(i)[2], 2*width+2*height-(x+y+list.get(i)[1]+list.get(i)[2]));
			} else {	// 상점과 동근이의 위치가 반대편이 아닌 경우
				distance += Math.min(Math.abs(x-list.get(i)[1])+Math.abs(y-list.get(i)[2]), 
						2*width+2*height-(Math.abs(x-list.get(i)[1])+Math.abs(y-list.get(i)[2])));
			}
			
		}
		System.out.println(distance);
	}	
	static String src = "10 5\r\n" + 
			"3\r\n" + 
			"1 4\r\n" + 
			"3 2\r\n" + 
			"2 8\r\n" + 
			"2 3";
			
}
