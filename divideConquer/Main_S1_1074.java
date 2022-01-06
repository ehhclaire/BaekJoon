import java.io.StringReader;
import java.util.Scanner;

public class Main {
	static int R, C, answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(new StringReader(src));
		
		int N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		answer = 0;
		
		int size = (int) Math.pow(2, N);
		
		Z(0, 0, size);	// 매개변수 : 시작 좌표 r, c와 전체 한 변의 길이 (2^N)
		System.out.println(answer);
	}
	
	private static void Z(int r, int c, int len) {
		if(len==1) return;	// 더이상 나눌 사분면이 없다면 종료
		
		int half = len/2;	// 사분면을 자르기위해 현재 길이의 반 구하기
		
		// 1사분면에 속한 경우
		if(contains(r, c, half)) {
			Z(r, c, half);
		}
		// 2사분면에 속한 경우
		else if(contains(r, c+half, half)) {
			answer += half * half;		// 시작위치의 num 갱신
			Z(r, c+half, half);
		}
		// 3사분면에 속한 경우
		else if(contains(r+half, c, half)) {
			answer += half * half * 2;	// 시작위치의 num 갱신
			Z(r+half, c, half);
		}
		// 4사분면에 속한 경우
		else if(contains(r+half, c+half, half)) {
			answer += half * half * 3;	// 시작위치의 num 갱신
			Z(r+half, c+half, half);
		}
	}
	private static boolean contains(int r, int c, int half) {
		return r <= R && R < r + half && c <= C && C < c + half;
	}
	static String src = "2 3 1";
}
