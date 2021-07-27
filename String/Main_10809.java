package Solution;

import java.util.Scanner;

public class Main_10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] answer = new int[26];
		
		String str = sc.next();

		// 정답 배열 -1로 초기화
		for(int i=0, end=answer.length; i<end; i++) {
			answer[i] = -1;
		}
		
		for(int i=0, end=str.length(); i<end; i++) {
			int tmp = str.charAt(i)-97;
			if(answer[tmp]==-1) {
				answer[tmp] = i;
			} else {
				continue;
			}
		}
		for(int i=0, end=answer.length; i<end; i++) {	
			System.out.print(answer[i]+" ");
		}
	}
}
