package boj;

import java.util.Scanner;

/** 
 * 
 * 이진탐색을 하지않아 시간초과(Timeout Error) 발생 - 실패코드
 *
 */

public class Main_G5_3020_시간초과 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int H = sc.nextInt();
		
		int[][] cave = new int[H][N];
		int[] answer = new int[H];
		
		
		for(int i=0; i<N; i++) {
			int len = sc.nextInt();
			if(i%2==0) {
				while(len>0) {
					cave[H-len][i] = 1;
					len--;
				}
			} else {
				while(len>0) {
					cave[len-1][i] = 1;
					len--;
				}
			}
		}
		
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				if(cave[i][j]==1) {
					cnt++;
				}
			}
			min = Math.min(min, cnt);
			answer[i] = cnt;
			cnt=0;
		}	
		for(int a : answer) {
			if(a == min) cnt++;
		}
		System.out.println(min + " " +cnt);
	}
}
