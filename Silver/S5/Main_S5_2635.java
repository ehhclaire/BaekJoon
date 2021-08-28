package boj.Silver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_S5_2635 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> answer = new LinkedList<Integer>();

		int N = sc.nextInt();
		
		int max = Integer.MIN_VALUE;
		for(int i=N; i>N/2; i--) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.offer(N);
			list.offer(i);
		
			int idx = 1;
			int cnt = 2;
			
			while(true) {
				if(list.get(idx-1)-list.get(idx)>-1) {	// 전전값 - 이전값이 음수가 아니라면
					list.offer(list.get(idx-1)-list.get(idx));	// list에 추가
					idx++;
					cnt++;
				} else {
					break;
				}
			}
			// 최대 개수보다 크다면
			if(max<cnt) {
				max = cnt;	// 최대 개수 갱신
				answer = new LinkedList<Integer>();
				while(!list.isEmpty()) {	// 정답 리스트 answer 갱신
					answer.offer(list.poll());
				}
			}
		}
		System.out.println(answer.size());
		while(!answer.isEmpty()) {
			System.out.print(answer.poll() + " ");
		}
	}
}
