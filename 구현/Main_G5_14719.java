package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G5_14719 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());	// 세로 길이
		int W = Integer.parseInt(st.nextToken());	// 가로 길이
		int[][] block = new int[H][W];
		int water = 0;		// 총 고인는 빗물의 총량
		
		// 각각의 블록의 높이 입력받기
		String[] height = br.readLine().split(" ");
		
		// 2차원 배열에 높이만큼 표시하기
		int idx = 0;
		for(int i=0; i<height.length; i++) {
			int len = Integer.parseInt(height[i]);
			for(int h=H-1; h>H-1-len; h--) {
				block[h][idx] = 1;
			}
			idx++;
		}
		
//		for(int h=0; h<H; h++) {
//			for(int w=0; w<W; w++) {
//				System.out.print(block[h][w] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		// 맨 밑에 줄부터 탐색하면서 왼쪽과 오른쪽이 막혀있는 경우 count 누적
		for(int h=H-1; h>-1; h--) {
			boolean start = false;
			int sum = 0;
			for(int w=0; w<W; w++) {
				if(block[h][w]==1) {
					if(!start) start = true;
					else {
						water += sum;
						sum = 0;
					}
				}
				if(start && block[h][w]==0) sum++;
			}
		}
		System.out.println(water);
	}
	static String src = "4 4\r\n" + 
			"3 0 1 4";
}
