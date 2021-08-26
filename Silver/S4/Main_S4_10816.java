package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_10816 {
	private static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);		// 오름차순 정렬
		
		int M = Integer.parseInt(br.readLine());
		sb = new StringBuilder();	
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(UpperBound(cards,key) - LowerBound(cards,key));
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

	private static int LowerBound(int[] cards, int key) {
		int start = 0;
		int end = cards.length;
		
		while(start<end) {
			int mid = (start+end)/2;

			if(key <= cards[mid]) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		
		return start;
	}

	private static int UpperBound(int[] cards, int key) {
		int start = 0;
		int end = cards.length;
		
		while(start<end) {
			int mid = (start+end)/2;
			
			if(key < cards[mid]) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		
		return start;
	}
	
	
}
