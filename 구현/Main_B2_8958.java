package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_B2_8958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			char[] inputs = br.readLine().toCharArray();
			int cnt=0;
			int answer=0;
			
			for(int j=0, end=inputs.length; j<end; j++) {
				if(inputs[j]=='O') {
					cnt++;
					answer+=cnt;
				}
				else {					
					cnt=0;
				}
			}
			System.out.println(answer);
		}
	}
}
