package boj.Gold;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_G5_1461 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(new StringReader(src));
		
		int N = sc.nextInt();	// 책의 개수
		int M = sc.nextInt();	// 세준이가 한 번에 들 수 있는 책의 개수
		
		int step = 0;		// 최소 걸음 수
		ArrayList<Integer> positive = new ArrayList<Integer>();		// 양수 값 좌표 저장 ArrayList
		ArrayList<Integer> negative = new ArrayList<Integer>();		// 음수 값 좌표 저장 ArrayList

		int Psize = 0;
		int Nsize = 0;
		
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			if(num>0) {
				positive.add(num);
				Psize++;
			}
			else {
				negative.add(num);
				Nsize++;
			}
		}	
		
		// 오름차순 정렬
		if(Psize>0) Collections.sort(positive);	
		if(Nsize>0) Collections.sort(negative);		
		
		// 음수 처리
		for(int i=0; i<Nsize; i+=M) {
			step += Math.abs(negative.get(i))*2;
		}
		
		// 양수 처리
		for(int i=Psize-1; i>-1; i-=M) {
			step += positive.get(i)*2;
		}
		
		// 음수 중 제일 큰 것 vs 양수 중 제일 큰 것 중 큰 것을 마지막에 방문
		if(Psize==0) step += negative.get(0);
		else if(Nsize==0) step -= positive.get(Psize-1);
		else if(Math.abs(negative.get(0))> positive.get(Psize-1)) step += negative.get(0);
		else step -= positive.get(Psize-1);
		
		System.out.println(step);
		
	}
	static String src = "5 3\r\n" + 
			"-18 -9 -4 -26 -45";
}
