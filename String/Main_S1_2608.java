package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main_S1_2608 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		String[] roma = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
		int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
		
		Map<String, Integer> map1 = new LinkedHashMap<>();
		for(int i=0; i<roma.length; i++) {
			map1.put(roma[i], value[i]);
		}
		
		String[] str1 = br.readLine().split("");
		String[] str2 = br.readLine().split("");
		
		int sum1 = 0;
		for(int i=0; i<str1.length; i++) {
			if(i>0 && map1.containsKey(str1[i-1] + str1[i])) {	// 전과 현재 인덱스를 잇는 요소가 IV, IX, XL, XC, CD, CM 인 경우
				sum1 -= map1.get(str1[i-1]);
				sum1 += map1.get(str1[i-1] + str1[i]);
			} else sum1 += map1.get(str1[i]);		// 해당 키의 값을 누적
		}
		
		int sum2 = 0;
		for(int i=0; i<str2.length; i++) {
			if(i>0 && map1.containsKey(str2[i-1] + str2[i])) {	// 전과 현재 인덱스를 잇는 요소가 IV, IX, XL, XC, CD, CM 인 경우
				sum2 -= map1.get(str2[i-1]);
				sum2 += map1.get(str2[i-1] + str2[i]);
			} else sum2 += map1.get(str2[i]);		// 해당 키의 값을 누적
		}
		
		int answer = sum1+sum2;		// 아라비아 숫자로 바꾼 값 (sum1 + sum2)
		
		StringBuilder sb = new StringBuilder();
		
		// answer이 0이 될때까지 value를 뒤에서부터 돌면서 큰 값으로 나눌 수 있으면 나눠나간다.
		// 나눈 경우 해당 기호를 sb에 이어붙인다.
		while(answer>0) {
			for(int i=value.length-1; i>-1; i--) {
				if(answer/value[i]>0) {
					sb.append(roma[i]);
					answer -= value[i];
					break;
				}
			}
		}		
		
		System.out.println(sum1+sum2);
		System.out.println(sb.toString());		
	}
	static String src = "DLIII\r\n" + 
			"MCMXL";
}
