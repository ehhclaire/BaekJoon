package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S5_2477 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());	// 1m^2의 넓이에 자라는 참외의 개수
		int[] inputs = new int[6];
		int area = 0;
		
		int height = Integer.MIN_VALUE, width = Integer.MIN_VALUE;
		for(int i=0; i<6; i++) {	// 육각형의 둘레 정보
			StringTokenizer st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken());
			inputs[i] = Integer.parseInt(st.nextToken());
			if(i%2==0) {
				height = Math.max(height, inputs[i]);
			} else {
				width = Math.max(width, inputs[i]);
			}
		}
		int h = 0, w = 0;
		for(int i=0; i<6; i++) {
			if(i%2==0) {
				if(inputs[(i+1)%6]+inputs[(i+5)%6]==width) {
					h = inputs[i];
				}
			}else {
				if(inputs[(i+1)%6]+inputs[(i+5)%6]==height) {
					w = inputs[i];
				}
			}
		}
		
		System.out.println((height*width-h*w)*N);	
	}
	static String src = "7\r\n" + 
			"4 50\r\n" + 
			"2 160\r\n" +
			"3 20\r\n" +
			"1 60\r\n" + 
			"3 30\r\n" + 
			"1 100";
}
