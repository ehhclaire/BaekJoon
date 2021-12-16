package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_11509 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));

		int N = Integer.parseInt(br.readLine());
		int[] heights = new int[N];				// 입력받은 풍선 높이를 저장할 배열
		int[] arrows = new int[1000000];		// 높이에따른 화살의 개수를 세기 위한 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {			
			// 해당 높이의 풍선을 터뜨릴 수 있는 화살이 없는 경우
			if(arrows[heights[i]] <= 0) {
				arrows[heights[i]-1]++;		// 현재 풍선 높이 - 1 의 높이에 해당하는 화살 개수 1 증가
				cnt++;			// 화살 총 개수 증가
			} else { 	// 해당 높이의 풍선을 터뜨릴 수 있는 화살이 있는 경우	
				arrows[heights[i]]--;		// 현재 높이의 화살 개수 1개 감소
				arrows[heights[i]-1]++;		// 현재 높이 - 1의 높이에 해당하는 화살 개수 1 증가
			}
		}
		System.out.println(cnt);		// 총 화살 개수 출력
		
	}
	static String src = "5\r\n" +
			"2 1 5 4 3";
}
