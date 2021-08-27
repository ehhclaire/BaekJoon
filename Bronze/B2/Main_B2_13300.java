package boj.Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_13300 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 총 학생 수 
		int K = Integer.parseInt(st.nextToken());	// 한 방 최대 인원 수
		
		int[][] rooms = new int[6][2];	// 학년과 성별에 따른 학생 배정할 room 배열
		
		int cnt = 0;		// 필요한 총 방의 개수
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());	// 학생 성별
			int year = Integer.parseInt(st.nextToken())-1;	// 학생 학년
			
			rooms[year][gender]++;	// 해당 학년, 성별에 학생 +1
		}
		
		
		for(int[] room : rooms) {
			for(int r : room) {
				if(r>0 && r<=K) cnt++;	// 방 최대 인원수가 넘지 않으면 방 1개로 충분
				else if(r>K){			// 방 최대 인원수를 넘으면
					if(r%K==0) cnt += r/K;	// 인원을 방 최대 인원수로 나누어떨어지면 몫만큼 방 추가 
					else cnt += r/K + 1; 	// 				     나누어떨어지지 않으면 몫+1만큼 방 추가
				}
			}
		}
		System.out.println(cnt);
	}

}
