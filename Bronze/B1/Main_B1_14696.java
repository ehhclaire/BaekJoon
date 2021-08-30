package boj.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_B1_14696 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());	// 게임 라운드 수
		
		for(int i=0; i<N; i++) {
			// a가 낸 딱지 정보 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");			
			int n1 = Integer.parseInt(st.nextToken());
			Integer[] a = new Integer[n1];
			for(int j=0; j<n1; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}
			
			// b가 낸 딱지 정보 입력
			st = new StringTokenizer(br.readLine(), " ");
			int n2 = Integer.parseInt(st.nextToken());
			Integer[] b = new Integer[n2];
			for(int j=0; j<n2; j++) {
				b[j] = Integer.parseInt(st.nextToken());
			}
			
			// a 딱지 정보 내림차순 정렬
			Arrays.sort(a, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});	
			// b 딱지 정보 내림차순 정렬
			Arrays.sort(b, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});	
		
			boolean aWin = false;
			boolean bWin = false;
			
			int end = Math.min(n1, n2);	// 둘 중 짧은 길이 저장
			
			// 둘 중 짧은 길이 만큼 반복을 돌며 
			for(int j=0; j<end; j++) {	
				if(a[j]>b[j]) {	// 현재 a가 숫자가 더 큰 경우 
					System.out.println("A");
					aWin = true;
					break;
				}
				else if(a[j]<b[j]) {	// 현재 b가 숫자가 더 큰 경우 
					System.out.println("B");
					bWin = true;
					break;
				}
			}
			if(!aWin && !bWin) 	// 현재까지 무승부일때
				if(n1>n2) System.out.println("A");	// a가 아직 낼 딱지가 남은 경우
				else if(n1<n2) System.out.println("B");	// b가 아직 낼 딱지가 남은 경우
				else System.out.println("D");		// 위의 조건이 다 아닌 경우
		}
		
	}
	static String src = "5\r\n" + 
			"1 4\r\n" + 
			"4 3 3 2 1\r\n" + 
			"5 2 4 3 2 1\r\n" + 
			"4 4 3 3 1\r\n" + 
			"4 3 2 1 1\r\n" + 
			"4 2 3 2 1\r\n" + 
			"4 4 3 2 1\r\n" + 
			"3 4 3 2\r\n" + 
			"5 4 4 2 3 1\r\n" + 
			"5 4 2 4 1 3";
}
