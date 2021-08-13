package BOJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_15686 {
	static int N;			// 도시 크기, N x N
	static int M;			// 최대 치킨집 수
	static int[][] map;		// 도시 정보 저장 배열
	static int[][] chicken;	// 치킨집 위치 저장
	static int[] numbers;	// 조합 경우 임시 저장 배열
	static int distance;	// 최단 거리
	
	public static void combination(int cnt, int start) {
		if(cnt==M) {
			// 경우가 하나 만들어질때마다
			int total_dist = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int min_dist = Integer.MAX_VALUE;
					if(map[i][j]==1) {	// 도시 좌표에서 집을 찾은 경우
						for(int k=0; k<M; k++) {	// 현재 경우에 존재하는 치킨집으로부터 집까지의 거리 중 최소값을 저장
							int dist = Math.abs(chicken[numbers[k]][0]-i)+Math.abs(chicken[numbers[k]][1]-j);
							min_dist = Math.min(dist, min_dist);
						}
						total_dist += min_dist;		// 현재 경우에 치킨집으로부터 모든 집의 최소 거리를 total_dist에 저장
					}
				}
			}
			distance = Math.min(total_dist, distance);	// 해당 경우가 최종 최단거리보다 짧은 경우 거리 update
			
			return;
		}
		
		// 치킨집 좌표에대해서 최대 치킨집 수만큼 모든 조합 구하기
		for(int i=start; i<chicken.length; i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("res/boj_15686.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		
		N = Integer.parseInt(st.nextToken());	
		M = Integer.parseInt(st.nextToken());	
		
		map = new int[N][N];
		chicken = new int[13][2];
		numbers = new int[M];
		distance = Integer.MAX_VALUE;
		
		int idx = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					idx++;
				}
			}
		}
		
		chicken = new int[idx][2];	// 도시 좌표에 치킨집 수만큼 chicken 배열 초기화
		idx = -1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==2) {	// 치킨집이 위치의 좌표값 x, y 값을 배열에 저장
					chicken[++idx][0] = i;
					chicken[idx][1] = j;
				}
			}
		}

		combination(0,0);
		System.out.println(distance);
	}
}
