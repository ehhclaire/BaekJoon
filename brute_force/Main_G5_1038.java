package boj.Gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_G5_1038 {
	static ArrayList<Long> list = new ArrayList<Long>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N <= 10) {		// 10이하인 경우 입력 번째가 출력 숫자
			System.out.println(N);
			return;
		} else {			// 그 외의 경우 0 ~ 9로시작하는 숫자의 감소하는 모든 정수를 만들어 list에 저장
			for(int i=0; i<10; i++) {
				makeList(i, 1);
			}
		}
		
		Collections.sort(list);		// 위에서 생성한 list를 정렬
		
		if(N >= list.size()) System.out.println(-1);		// 생성한 list의 인덱스보다 큰 순번을 출력할 경우, -1
		else System.out.println(list.get(N));				// 범위 내의 경우, 해당 번째의 숫자 출력
	}

	private static void makeList(long num, int depth) {
		if(depth > 10) return;		// 0~9, 총 10번을 다 검사했다면 탈출
		
		list.add(num);		// 만든 정수 list에 추가
		
		for(int i=0; i<10; i++) {
			if(num % 10 > i) {		// i를 현재 num의 오른쪽에 붙일 수 있다면 (num의 1의자리보다 i가 작다면)
				makeList((num * 10) + i, depth + 1);	// num의 오른쪽에 붙이기
			}
		}
	}
}
