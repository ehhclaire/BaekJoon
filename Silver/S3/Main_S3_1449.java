package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_1449 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 물이 새는 곳 수
		int L = Integer.parseInt(st.nextToken());	// 테이프 길이
		int cnt = 1;								// 테이프 개수
		
		int[] broken = new int[N];		
		st =  new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			broken[i] = Integer.parseInt(st.nextToken());		// 물 새는 곳 입력 받기
		}
		
		Arrays.sort(broken);	// 물 새는 곳, 오름차순 정렬
		int start = broken[0];	// 첫번째 위치를 start에 저장
		
		for(int i=1; i<N; i++) {	// 1 ~ N-1 범위 탐색
			if((broken[i]-start+1) > L) {	// 현재 좌표 - 시작좌표 + 1(0.5+0.5) 는 인접한 물 새는 두 곳의 총 길이이고 이게 테이프 길이보다 길다면
				cnt++;		// 테이프가 하나 더 필요
				start = broken[i];	// 시작점을 현재 좌표로 갱신
			}
		}
		System.out.println(cnt);
	}

}
