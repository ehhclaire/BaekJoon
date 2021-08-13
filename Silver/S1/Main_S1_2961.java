package BOJ;

import java.util.Scanner;

public class Main_S1_2961 {
	static int N;			// 재료 수
	static int[] sour;		// 신맛 정보
	static int[] bitter;	// 쓴맛 정보
	static int flavor = Integer.MAX_VALUE;		// 맛 차이 정도
	static boolean[] isSelected;	// 재료 사용 여부
	
	public static void subset(int cnt) {
		if(cnt==N) {
			int sour_level = 1;		// 신맛 총 합 초기화
			int bitter_level = 0;	// 쓴맛 총 합 초기화
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					sour_level *= sour[i];		// 신맛 정도 누적 (곱하기)
					bitter_level += bitter[i];	// 쓴맛 정도 누적 (더하기)
				}
			}
			if(sour_level==1 && bitter_level==0) return;	// 둘 다 선택하지 않은 공집합은 제외
			else {
				flavor = Math.min(Math.abs(sour_level - bitter_level), flavor);	// 현재 맛 차이가 최소보다 작다면 해당 값 최소값으로 갱신
				return;
			}
		}
		
		// 재료 수만큼 가능한 모든 부분집합 구하기
		isSelected[cnt] = false;
		subset(cnt+1);
		isSelected[cnt] = true;
		subset(cnt+1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	
		
		sour = new int[N];	
		bitter = new int[N];	
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}
		
		subset(0);
		System.out.println(flavor);
		
	}

}
