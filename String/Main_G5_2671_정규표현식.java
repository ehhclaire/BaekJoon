package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

// (100~1~|01)~
public class Main_G5_2671_정규표현식 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		String str = br.readLine();		// 입력 신호
		
		if(str.matches("(100+1+|01)+")) System.out.println("SUBMARINE");
		else System.out.println("NOISE");
	}
	static String src = "10010111";
}
