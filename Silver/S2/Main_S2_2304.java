package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S2_2304 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());	// 기둥 개수
		int[][] inputs = new int[N][2];		// 입력을 저장할 2차원 배열
		int area = 0;		// 창고 다각형 면적
		int idx = 0;					// 최대 기둥 index

		// 기둥의 좌표와 높이 입력받기
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int L = Integer.parseInt(st.nextToken());	// 왼쪽 면의 위치
			int H = Integer.parseInt(st.nextToken());	// 높이
			inputs[i][0] = L;
			inputs[i][1] = H;
		}
		
		// 위치를 기준으로 오름차순
		Arrays.sort(inputs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
				
		// 정방향 탐색 (처음부터 끝까지)
		int start = inputs[0][0];	// 첫번째 기둥 좌표
		int height = inputs[0][1];	// 첫번째 기둥 높이
		for(int i=1; i<N; i++) {
			if(height <= inputs[i][1]) {	// 현재 기둥보다 높은 기둥을 만나면
				area += (inputs[i][0]-start)*height;	// 이전 기둥의 높이를 기준으로 면적 누적 
				start = inputs[i][0];	// 좌표 갱신
				height = inputs[i][1];	// 높이 갱신
			}
			
			// 가장 높은 기둥의 index 찾기
			if(inputs[i][1]>=inputs[idx][1]) {
				idx = i;
			}
		}
		
		// 역방향 탐색 (끝에서부터 높은 기둥까지)
		start = inputs[N-1][0];	// 마지막 기둥 좌표
		height = inputs[N-1][1];	// 마지막 기둥 높이
		for(int i=N-2; i>idx-1; i--) {
			if(height <= inputs[i][1]) {	// 현재 기둥보다 높은 기둥을 만나면
				area += (start-inputs[i][0])*height;	// 이전 기둥의 높이를 기준으로 면적 누적
				start = inputs[i][0];	// 좌표 갱신
				height = inputs[i][1];	// 높이 갱신
			}
		}
		
		area += inputs[idx][1];		// 제일 높은 기둥 면적 누적
		System.out.println(area);
	}
	static String src = "7\r\n" + 
			"2 4\r\n" + 
			"11 4\r\n" + 
			"15 8\r\n" + 
			"4 6\r\n" + 
			"5 3\r\n" + 
			"8 10\r\n" + 
			"13 6";
}
