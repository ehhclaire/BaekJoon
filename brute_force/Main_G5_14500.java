package boj.Gold;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G5_14500 {
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 세로 길이
		int M = Integer.parseInt(st.nextToken());	// 가로 길이
		int[][] map = new int[N][M];
		
		// 게임판 초기화
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		// 1. ㅁ
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<M-1; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1];
				max = Math.max(max, sum);
			}
		}
		
		// 2. ㅡ
		for(int i=0; i<N; i++) {
			for(int j=0; j<M-3; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
				max = Math.max(max, sum);
			}
		}
		for(int i=0; i<N-3; i++) {
			for(int j=0; j<M; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
				max = Math.max(max, sum);
			}
		}
		
		// 3. L
		for(int i=0; i<N-2; i++) {
			for(int j=0; j<M-1; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
				max = Math.max(max, sum);
				sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i][j+1];
				max = Math.max(max, sum);
				sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
				max = Math.max(max, sum);
				sum = map[i+2][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
				max = Math.max(max, sum);
			}
		}
		for(int i=1; i<N; i++) {
			for(int j=0; j<M-2; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i-1][j+2];
				max = Math.max(max, sum);
				sum = map[i-1][j] + map[i-1][j+1] + map[i-1][j+2] + map[i][j+2];
				max = Math.max(max, sum);
				sum = map[i][j] + map[i-1][j] + map[i-1][j+1] + map[i-1][j+2];
				max = Math.max(max, sum);
				sum = map[i-1][j] + map[i][j] + map[i][j+1] + map[i][j+2];
				max = Math.max(max, sum);
			}
		}
		
		// 4. ㅗ
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<M-2; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
				max = Math.max(max, sum);
				sum = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+1];
				max = Math.max(max, sum);
			}
		}
		for(int i=0; i<N-2; i++) {
			for(int j=0; j<M-1; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
				max = Math.max(max, sum);
				sum = map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+1][j];
				max = Math.max(max, sum);
			}
		}
		
		// 5. ㄹ
		for(int i=0; i<N-2; i++) {
			for(int j=0; j<M-1; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
				max = Math.max(max, sum);
				sum = map[i][j+1] + map[i+1][j+1] + map[i+1][j] + map[i+2][j];
				max = Math.max(max, sum);
			}
		}
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<M-2; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
				max = Math.max(max, sum);
				sum = map[i+1][j] + map[i+1][j+1] + map[i][j+1] + map[i][j+2];
				max = Math.max(max, sum);
			}
		}		
		System.out.println(max);
	}
	static String src = "5 5\r\n" + 
			"1 2 3 4 5\r\n" + 
			"5 4 3 2 1\r\n" + 
			"2 3 4 5 6\r\n" + 	
			"6 5 4 3 2\r\n" + 
			"1 2 1 2 1";
}
