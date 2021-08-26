package boj.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S4_1337 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		// 입력 원소 수
		int[] numbers = new int[N];
		int answer = Integer.MAX_VALUE; 
		
		for(int i=0; i<N; i++) {
			numbers[i] = sc.nextInt();
		}
		Arrays.sort(numbers);
	
		if(N==1) answer=4;		// 입력 원소가 하나인 경우, 필요한 원소는 무조건 4개
		else {					// 입력 원소가 2개 이상이라면
			for(int i=0; i<N-1; i++) {	// 입력받은 원소를 하나씩 기준으로 잡고
				int cnt = 1;	// 연속한 원소 개수 카운트 변수
				int need = 0;	// 추가로 필요한 원소 수
				int j = i+1;	// 기준 원소 바로 다음부터 비교 시작
				while(cnt<5 && j<N) {	// cnt가 5개 이거나 입력 원소배열을 다 탐색한 경우 종료
					if(numbers[j]-numbers[i]!=cnt) {	// 차이가 기준 배열과의 거리랑 다르다면
						need++;		// 해당 부분에 원소 1개 삽입 필요
					} else {		// 차이가 기준 배열과의 거리랑 같다면
						j++;		// 다음 인덱스 검색
					}
					cnt++;			// 탐색 개수 증가
				}
				// 연속한 원소를 5개를 채우지 못했는데 배열 탐색이 끝나버린경우
				// 5 - cnt 만큼 더 필요하다는 말
				need += 5-cnt;		
				answer = Math.min(answer, need);	// 현재 필요한 추가 원소수가 더 적다면 해당 값으로 answer 갱신
			}
		}
		System.out.println(answer);
	}
}
