package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S1_2527 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 첫번째 사각형
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 두번째 사각형
			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken());
			int y4 = Integer.parseInt(st.nextToken());
			
			
			if((x1==x4 && y1==y4) || (x2==x3 && y1==y4) || (x2==x3 && y2==y3) || (x1==x4 && y2==y3)) { // c. 한 꼭지점이 같은 경우
				System.out.println("c");
			} else if((x2==x3 && (y3<y2 || y1<y4)) || (y1==y4 && (x1<x4 || x3<x2)) 
					|| (x1==x4 && (y1<y4 || y2<y4)) || (y3==y2 && (x1<x3 || x3<x2)) ) {	// b. 선분 겹치기
				System.out.println("b");
			} else if(x2<x3 || x4<x1 || y2<y3 || y4<y1) {	// d. 겹치지 않는 경우
				System.out.println("d");		
			} else {	// a. 사각형 겹치기
				System.out.println("a");
			}
		
		
		}
	}
	static String src = "3 10 50 60 100 100 200 300\r\n" + 
			"45 50 600 600 400 450 500 543\r\n" + 
			"11 120 120 230 50 40 60 440\r\n" + 
			"35 56 67 90 67 80 500 600\r\n" + 
			"1 1 3 3 3 3 5 5";
}
