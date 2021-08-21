package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_1920 {
	
	public static void BinarySearch() {
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		
		// 비교할 배열
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);		// 이분탐색을 위해 오름차순 정렬
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for(int i=0; i<M; i++) {	// 입력 수를 차례대로 찾기
			if(binary(A, Integer.parseInt(st.nextToken()))) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}		
	}

	private static boolean binary(int[] a, int n) {		
		int left = 0;
		int right = a.length-1;
		
		boolean find = false;
		while(left<=right) {	// 검색이 완료될 떄까지
			int mid = (left + right) / 2;	// 중간 지점
			if(a[mid]==n) {		// 찾는 값을 찾으면
				find = true;	// 찾은 여부 표시후	
				break;			// 반복문 탈출
			}
			
			if(n < a[mid]) {	// 찾는 수가 중간보다 왼쪽에 있다면
				right = mid-1;	// 범위를 left ~ mid-1 로 변경
			} else {			// 찾는 수가 중간보다 오른쪽에 있다면
				left = mid+1;	// 범위를 mid+1 ~ right 로 변경
			}
		}
		return find;	// 찾았는지의 유무를 return
	}
}
