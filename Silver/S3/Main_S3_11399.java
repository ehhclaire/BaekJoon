package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S3_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numbers = new int[N];
		
		for(int i=0; i<N; i++) {
			numbers[i] = sc.nextInt();
		}
		Arrays.sort(numbers);

		int sum=0;
		for(int i=0; i<N; i++) {
			sum+=numbers[i]*(N-i);
		}
		System.out.println(sum);
	}

}
