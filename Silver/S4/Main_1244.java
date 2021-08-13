package BOJ;

import java.util.Arrays;
import java.util.Scanner;

// 1: On, 2: Off
// 남학생, 수의 배수 -> 상태 change
// 여학생, 수의 좌우 대칭 -> 상태 change / 아닌경우 -> 해당변호만 change
// 남학생 : 1, 여학생 : 2

public class Main_1244 {

	// 남학생인 경우
	public static void boy(int n, int[] s) {
		
		// 선택한 스위치가 1인 경우, 전체 스위치 변경
		if(n==1) {
			for(int i=0, end=s.length; i<end; i++) {
				change(s, i);
			}
		} else {
			for(int i=1, end=s.length/n+1; i<end; i++) {
				change(s, i*n-1);
			}
		}
	}
	
	// 여학생인 경우
	public static void girl(int n, int[] s) {
		int len = s.length;
		int end;
		
		if(len/2 > n) {		// 선택한 스위치가 스위치 총 길이의 반보다 앞쪽에 있는 경우
			for(int i=1; i<n; i++) {
				if(s[n-i-1]==s[n+i-1]) {
					change(s, n-i-1);	// 기준 앞의 값 변경
					change(s, n+i-1);	// 기준 뒤의 값 변경
				} else {
					break;
				}
			}
		} else {		// 선택한 스위치가 스위치 총 길이의 반보다 뒤쪽에 있는 경우
			for(int i=1; i<=len-n; i++) {
				if(s[n-i-1]==s[n+i-1]) {
					change(s, n-i-1);	// 기준 앞의 값 변경
					change(s, n+i-1);	// 기준 뒤의 값 변경
				} else {
					break;
				}
			}
		}
		change(s, n-1);		// 기준 값 변경
	}
	
	// 스위치 상태 변경
	public static void change (int[] s, int idx) {
		if(s[idx]==1) {
			s[idx]=0;
		} else {
			s[idx]=1;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();		// 스위치 개수
		int[] light = new int[size];
		
		// 스위치 상태 입력
		for(int i=0; i<size; i++) {	
			light[i] = scan.nextInt();
		}
		
		int student = scan.nextInt();	// 학생 수
		for(int i=0; i<student; i++) {
			int gender = scan.nextInt();
			int num = scan.nextInt();
			
			if(gender==1) {
				boy(num, light);
			} else if(gender==2){
				girl(num, light);
			}
		}
		for(int i=0; i<size; i++) {
			System.out.print(light[i] + " ");
			if((i+1)%20==0) System.out.println();	// 20개 단위로 출력
		}
	}
}
