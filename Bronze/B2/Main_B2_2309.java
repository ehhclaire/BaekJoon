package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B2_2309 {
	private static int[] numbers;
	private static boolean[] selected;
	private static boolean found;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] height = new int[9];
		numbers = new int[7];	
		selected = new boolean[101];	// 1 ~ 100까지 키 사용 여부
		
		for(int i=0; i<9; i++) {
			height[i] = sc.nextInt();
		}
		found = false;
		combination(height, 9, 7);	// 9개의 입력 중 7명의 난쟁이 찾기
	}

	private static void combination(int[] height, int n, int r) {
		if(found) return;	// 찾았으면 탐색 그만 
		
		if(r==0) {		// 7개의 경우를 찾았다면
			int sum = 0;
			for(int i=0; i<7; i++) {
				sum += numbers[i];	// 7개의 키의 합 구하기
			}
			if(sum==100) {	// 합이 100이면
				Arrays.sort(numbers);	// 오름차순 정렬 후
				for(int num : numbers) System.out.println(num);	// 출력
				found = true;	// 찾은 표시
			}
			return;
		}
		
		if(n<r) return;
		
		if(!selected[height[n-1]]) {	// 아직 사용한 키가 아니라면
			numbers[r-1] = height[n-1];	// 해당 키 조합에 추가 
			selected[height[n-1]] = true;	// 해당 키 사용 여부 true
			combination(height, n-1, r-1);

			selected[height[n-1]] = false;	// 사용하고 난 뒤, 해당 키 사용 여부 false
			combination(height, n-1, r);
		}
	}
}
