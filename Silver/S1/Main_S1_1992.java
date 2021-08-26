package boj.Silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_S1_1992 {
	private static Queue<String> answer = new LinkedList<String>();
	private static int[][] map;
	
	private static void QuadTree(int r, int c, int n) {
		int half = n >> 1;		// 현재 영역의 절반 구하기
		boolean same = true;	// 영역의 값이 다 같은지 여부 체크 변수
		
		top:
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				if(map[r][c]!=map[i][j]) {	// 영역의 첫번째 값과 이후의 값들이 다르면
					same = false;			// 같은지 여부를 false로 체크 후
					break top;				// 반복문 탈출
				}
			}
		}
		
		if(same) {		// 만약 영역의 값들이 다 같다면
			if(map[r][c]==1) answer.add("1");	// 그 값들이 1이라면, 1 추가
			else answer.add("0");				// 		  0이라면, 0 추가
			return;
		} else {
			answer.add("(");				// 영역에 다른 값이 존재한다면 한 레벨 안으로 들어가기위해 괄호 "(" 추가
			QuadTree(r, c, half);			// 우쪽 좌측 영역에대해 재귀 수행
			QuadTree(r, c+half, half);		// 위쪽 우측 영역에대해 재귀 수행
			QuadTree(r+half, c, half);		// 아래쪽 좌측 영역에대해 재귀 수행
			QuadTree(r+half, c+half, half); // 아래쪽 우측 영역에대해 재귀 수행
			answer.add(")");				// 해당 레벨이 끝났으면 괄호 닫기 ")" 추가
		}		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/boj_1992.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		// 영상 데이터 입력받기			
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		// 전부 0이면, 0 출력 
		// 전부 1이면, 1 출력
		int sum = 0;
		for(int[] ma : map) {
			for(int m : ma) {
				sum+=m;
			}
		}
		if(sum==0) System.out.print("0");
		else if(sum==N*N) System.out.print("1");
		else {		// 전부 같은 데이터가 아니라면 
			QuadTree(0, 0, N);	// 영상 데이터 탐색하러가기
		}
		
		// 정답 출력
		while(!answer.isEmpty()) {
				System.out.print(answer.poll());
		}
		
	}
}