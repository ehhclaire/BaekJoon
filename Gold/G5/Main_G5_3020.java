package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_G5_3020_2 {
	private static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int H = sc.nextInt();
		
		int[] suck = new int[N/2];	// 석순
		int[] jong = new int[N/2];	// 종유석
		int[] bump = new int[H];	// 높이를 인덱스로 가지는 부딪힌 횟수 저장 배열
		
		for(int i=0; i<N/2; i++) {
			suck[i] = sc.nextInt();
			jong[i] = sc.nextInt();
		}
		
		// 이진탐색을 위한 석순, 종유석 배열 오름차순 정렬
		Arrays.sort(suck);
		Arrays.sort(jong);
		
		int min = Integer.MAX_VALUE;	// 최소로 부딪힌 높이
		int cnt = 0;					// 
		// 높이 1 ~ H 을 반복돌면서 탐색
		for(int i=1; i<=H; i++) {
			int s = binary(0, N/2-1, i, suck);			// 해당 높이의 석순에 부딪힌 횟수
			int j = binary(0, N/2-1, H-i+1, jong);		// 해당 높이의 종유석에 부딪힌 횟수
			
			bump[i-1] = s+j;						// 총 부딪힌 횟수 합을 저장
			if(min>bump[i-1]) {						// 현재 최소 부딪힌 횟수보다 현재 부딪힌 횟수가 작다면 
				min = bump[i-1];					// 최소 횟수 갱신
			}
		}
		for(int i=0; i<H; i++) {
			if(min==bump[i]) cnt++;				// 전체 부딪힌 정보 저장 배열에서 최소 부딪힌 구간의 수
		}
		System.out.println(min + " " + cnt);
		
	}

	private static int binary(int s, int e, int h, int[] stone) {
		int start = s;
		int end = e;
		
		int min = Integer.MAX_VALUE;
		
		while(start<=end) {
			int mid = (start+end) / 2;	// 가운데 지점 찾기
			
			if(h <= stone[mid]) {
				min = Math.min(min, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			return 0;
		}
		
		return N/2 - min;
	}
}