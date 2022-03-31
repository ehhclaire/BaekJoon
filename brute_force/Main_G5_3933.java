package boj.Gold;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main_G5_3933 {
	static int[] comb;
	static int[] numbers;
	static int N;
	static int answer, size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			N = sc.nextInt();
			if(N==0) break;
			
			size = (int) Math.sqrt(N);
			numbers = new int[size];
			for(int i=0; i<size; i++) {
				numbers[i] = (int) Math.pow(i+1, 2);
			}
			comb = new int[4];
			answer = 0;
			
			// 4개로 구성된 조합 만들기
			for(int i=0; i<size; i++) {
				if(numbers[i]==N) {
					answer++;
					break;
				}
				for(int j=i; j<size; j++) {
					if(numbers[i]+numbers[j]==N) {
						answer++;
						break;
					}
					for(int k=j; k<size; k++) {
						if(numbers[i]+numbers[j]+numbers[k]==N) {
							answer++;
							break;
						}
						for(int l=k; l<size; l++) {
							if(numbers[i]+numbers[j]+numbers[k]+numbers[l]==N) {
								answer++;
								break;
							}
						 }
					 }
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());

	}
	
	// 재귀를 이용한 조합 (시간초과)
//	private static void combination(int cnt, int idx, int r, int sum) {
//		if(sum>N) return;
//		if(cnt==r) {
//			if(sum==N) {
//				answer++;
//			}
//			return;
//		}
//		for(int i=idx; i<size; i++) {
//			comb[cnt] = numbers[i];
//			combination(cnt+1, i, r, sum+=numbers[i]);	
//			sum-=numbers[i];
//		}
//	}
	static String src = "1\r\n" + 
			"25\r\n" + 
			"2003\r\n" + 
			"211\r\n" + 
			"20007\r\n" + 
			"0";
}
