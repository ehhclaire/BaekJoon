package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B1_2954 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String answer = "";
		int i=0;
		while(i<str.length()) {
			if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i'
					|| str.charAt(i)=='o' || str.charAt(i)=='u') {
				answer += str.charAt(i);
				i += 3;
			} else {
				answer += str.charAt(i++);
			}	
		}
		System.out.println(answer);
	}
}
