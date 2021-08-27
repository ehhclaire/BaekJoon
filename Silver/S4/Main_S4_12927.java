package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S4_12927 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] lights = br.readLine().toCharArray();
		int N = lights.length;
		boolean done = true;
		int btn = 0;
		
		for(int i=0; i<N; i++) {	// 전구 탐색
			if(lights[i]=='Y') {	// 전구가 켜져있다면
				int idx = i;		// 현재 인덱스로 부터
				while(idx<N) {		// 끝까지 탐색하면서
					if((idx+1)%(i+1)==0) {	// 처음 켜져있던 전구의 배수의 위치의 전구라면
						// 스위치 상태 반전
						if(lights[idx]=='Y') lights[idx]='N';	
						else lights[idx]='Y';
					}
					idx+=(i+1);	// 인덱스를 처음 켜져있던 전구의 배수만큼 이동하여 다시 탐색
				}
			} else continue;	// 전구가 꺼져있다면 그냥 전진
			btn++;	// 전구가 켜져있었을때 처리를 했다면 스위치 눌림 1번 count
			for(int l : lights) {	// 현재 전구상태를 탐색하여
				if(l=='Y') {	// 켜져있는게 존재한다면 위의 작업 반복
					done = false;					
					break;
				}
			}
			if(done) break;		// 현재 전구가 다 꺼져있다면 탈출	
		}
		
		done = true;
		// 마지막으로 전구 상태 탐색
		for(int l : lights) {		
			if(l=='Y') done=false; 
		}
		if(done) System.out.println(btn);	// 다 꺼져있다면 스위치를 누른 횟수 출력
		else System.out.println(-1);		// 켜져있는게 존재한다면 -1 출력
	}
}
