package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_2491 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 수열의 길이
		int[] numbers = new int[N];	
		
		// N개의 숫자 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순 탐색
		int cnt = 0;
		int max = 1;	// 최소 1개는 존재할거니깐 max=1부터 시작
		for(int i=0; i<N-1; i++) {
			cnt = 1;
			int j = i;
			while(j<N-1) {
				if(numbers[j]<=numbers[j+1]) {
					cnt++;
					j++;
				}
				else break;
			}
			max = Math.max(max, cnt);	// 최대 개수로 갱신
			
			// 내림차순 탐색
			cnt = 1;
			j = i;
			while(j<N-1) {
				if(numbers[j]>=numbers[j+1]) {
					cnt++;
					j++;
				}
				else break;
			}
			max = Math.max(max, cnt);	// 최대 개수로 갱신
		}
		System.out.println(max);	
	}
}
