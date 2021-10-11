package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_2628 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());	// 색종이 가로길이
		int height = Integer.parseInt(st.nextToken());	// 색종이 세로 길이
		
		int N = Integer.parseInt(br.readLine());	// 입력 개수
		
		int[] r = new int[N];
		int[] c = new int[N];
		
		int[] cutR = new int[N+1];
		int[] cutC = new int[N+1];
		
		int idxR = 0, idxC = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if(type==0) {
				r[idxR++] = n;
			} else {
				c[idxC++] = n;
			}
		}
		Arrays.sort(r);
		Arrays.sort(c);
		
		// 세로로 자른 길이 하나씩 저장
		int start = 0;
		int end = height;
		for(int i=0; i<N; i++) {
			if(r[i]>0) {
				cutR[i] = r[i]-start;
				start = r[i];				
			}
		}
		// 마지막으로 자른 지점부터 끝까지의 길이 저장
		cutR[N] = end-start;
		
		// 가로로 자른 길이 하나씩 저장
		start = 0;
		end = width;
		for(int i=0; i<N; i++) {
			if(c[i]>0) {
				cutC[i] = c[i]-start;
				start = c[i];
			}
		}
		// 마지막으로 자른 지점부터 끝까지의 길이 저장
		cutC[N] = end-start;

		Arrays.sort(cutR);
		Arrays.sort(cutC);
		System.out.println(cutR[N]*cutC[N]);
	}
	static String src = "10 8\r\n" + 
			"3\r\n" + 
			"0 3\r\n" + 
			"1 4\r\n" + 
			"0 2";

}
