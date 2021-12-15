package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_10815 {
	static int N, cards[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringBuilder sb = new StringBuilder();		// 출력을 위한 StringBuilder
		
		N = Integer.parseInt(br.readLine());
		cards = new int[N];		// 상근이가 가진 숫자카드
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);		// 이분탐색을 위한 오름차순 정렬
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());		// 찾을 정수 입력 받기
			sb.append(binarySearch(num));		// 이분탐색 (BinarySearch)한 결과를 하나씩 출력
			sb.append(" ");
		}	
		System.out.println(sb.toString());
	}
	
	// 이분 탐색
	private static int binarySearch(int num) {
		int start = 0;		// 시작 인덱스
		int end = N-1;		// 끝 인덱스
		int mid;			// 중간 index
		
		while(start <= end) {
			mid = (start + end) / 2;		// 현재 start, end를 기준으로 중간 값 구하기
			if(cards[mid] == num) {			// 찾는 정수를 찾은 경우 1 return
				return 1;
			} else if(cards[mid] < num) {	// 찾는 값보다 작다면 start 인덱스를 mid+1로 갱신
				start = mid + 1;
			} else {						// 찾는 값보다 크다면 end 인덱스를 mid-1로 갱신
				end = mid - 1;
			}
		}	
		return 0;	// 값을 배열에서 찾지 못했다면 0 return
	}

	static String src = "5\r\n" + 
			"6 3 2 10 -10\r\n" + 
			"8\r\n" + 
			"10 9 -5 2 3 4 5 -10";
}