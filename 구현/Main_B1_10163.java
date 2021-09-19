package boj.Bronze;

/**
 * N장의 종이 놓을 때 종이 번호를 이용해서 표시를 해놓자
 * 모든 종이를 다 놓은 후에 종이 번호를 count
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_10163 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[1001][1001];
		int[] area = new int[N];
		
		for(int t=1; t<=N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());	// 색종이 x 좌표
			int y = Integer.parseInt(st.nextToken());	// 색종이 y 좌표
			int r = Integer.parseInt(st.nextToken());	// 색종이 너비
			int c = Integer.parseInt(st.nextToken());	// 색종이 높이
			
			// 입력받은 (x, y) 위치에 색종이 너비 * 높이 만큼 색종이 번호를 평면에 저장
			for(int i=x; i<x+r; i++) {
				for(int j=y; j<y+c; j++) {
					map[i][j] = t;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {	// 색종이 번호에 해당하는 번호를 찾으면
			// 전체 평면을 탐색하면서
			for(int[] ma : map) {
				for(int m : ma) {
					if(m==i) area[i-1]++;	// area 배열의 index-1자리 값 +1
				}
			}
		}
		
		// 색종이 별 면적 출력
		for(int a : area) System.out.println(a);	
	}
}
