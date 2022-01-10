import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S2_1780 {
	static int paper[][], answer[], cnt[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());	// 종이의 크기
		answer = new int[3];		// -1, 0, 1 로만 채워진 종이의 수
		
		paper = new int[N][N];
		StringTokenizer st = null;
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		split(0, 0, N);
		
		for(int a : answer) {
			System.out.println(a);
		}
		
	}
	private static void split(int r, int c, int n) {
		if(n==0) return;	// 더이상 자를 수 없는 경우 return
		
		boolean check = true;	// 현재 영역의 숫자가 다 동일한지 체크
		int data = paper[r][c];	// 현재 영역의 첫번째 값
		
		// 현재 영역을 탐색하면서
		top:
		for(int i=r; i<r+n; i++) {	
			for(int j=c; j<c+n; j++) {
				if(data != paper[i][j]) {	// 처음 값과 다른 값이면 해당 영역은 모두 같은 값으로 이루어지지않아 9등분
					check = false;	// 9등분을 하기위해 check를 false로 전환
					break top;	// 반복 종료
				}
			}
		}
		
		if(!check) {	// 9등분을 해야하는 경우
			for(int k=0; k<3; k++) {	
				for(int l=0; l<3; l++) {
					split(r+k*(n/3), c+l*(n/3), n/3);	// 9등분을 한 각각의 시작위치(영역의 왼쪽-위 좌표)와 영역의 길이를 매개변수로 재귀					
				}
			}
		} else {	// 모든 영역이 같은 값이라면
			answer[data+1]++;	// -1은 0 번째에, 0은 1번째에, 1은 2번째 인덱스의 값을 1 증가
			return;
		}
	}
	static String src = "9\r\n" + 
			"0 0 0 1 1 1 -1 -1 -1\r\n" + 
			"0 0 0 1 1 1 -1 -1 -1\r\n" + 
			"0 0 0 1 1 1 -1 -1 -1\r\n" + 
			"1 1 1 0 0 0 0 0 0\r\n" + 
			"1 1 1 0 0 0 0 0 0\r\n" + 
			"1 1 1 0 0 0 0 0 0\r\n" + 
			"0 1 -1 0 1 -1 0 1 -1\r\n" + 
			"0 -1 1 0 1 -1 0 1 -1\r\n" + 
			"0 1 -1 1 0 -1 0 1 -1";

}
