package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_2559 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] numbers = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;		// 온도 합의 최대값을 저장할 변수
		int sum = 0; 		// K개의 온도 합을 저장할 변수
		int idx = 0;		// 탐색할 인덱스 번호
		int left = 0;		// 제거할 왼쪽 인덱스 번호
		while(idx<numbers.length) {		// 배열을 전부 탐색할때까지
			// 처음 N개로 이루어진 합 구하기
			if(idx<K) {	
				sum += numbers[idx++];
			} else {	// N개의 합이 완성된 이후부터
				max = Math.max(max, sum);	// 이전 저장된 온도합의 최대값과 현재의 합 중 큰 값으로 갱신
				sum -= numbers[left++];		// 이전 합에 왼쪽 제거
				sum += numbers[idx++];		// 오른쪽 새 온도 추가 
			}			
		}
		max = Math.max(max, sum);	// 탐색 후 마지막 온도합도 기존의 온도합의 최대값과 비교해서 큰 값으로 갱신

		System.out.println(max);
	}
}
