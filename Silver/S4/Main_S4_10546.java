package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Main_S4_10546 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 1. 시간초과 - 문자열과 replace()
//		String names = "";
//		for(int i=0; i<N; i++) {
//			names+=br.readLine();
//			names+=" ";
//		}
//		for(int i=0; i<N-1; i++) {
//			names = names.replaceFirst(br.readLine() + " ", "");
//		}
		
		// 2. 시간 초과 - 배열 탐색
//		String[] names = new String[N];
//		for(int i=0; i<N; i++) {
//			names[i] = br.readLine();
//		}
//		
//		String[] finishers = new String[N];
//		for(int i=0; i<N-1; i++) {
//			String name = br.readLine();
//			for(int j=0; j<N; j++) {
//				if(names[j].equals(name)) {
//					names[j] = "";
//					break;
//				}
//			}
//		}
//		for(String name : names) {
//			if(!name.equals("")) System.out.println(name);
//		}
		
		// 3. HashMap 이용
		// 마라토너 이름을 key 값으로 해당 이름을 가지는 마라토너 수를 value로 가지는 HashMap 생성
		Map<String, Integer> map = new HashMap<String, Integer>();	
		String loser = "";		// 배부른 사람
		
		// 참가자 수만큼 반복을 돌며 입력 받기
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0)+1);
		}
		
		for(int i=0; i<N-1; i++) {
			String name = br.readLine();	// 골인한 선수들 입력받기
			if(map.get(name)>0)	map.put(name, map.getOrDefault(name, 0)-1);	// 만약 
			else {		// 만약 해당 이름의 value(마라토너 수)가 이미 0이라면
				map.put(name, map.getOrDefault(name, 0)+1);		// 1로 변경시키고 
				break;											// 탐색 종료
			}
		}		
		
		// 골인한 선수들을 제외한 후, map에 1의 value를 가지는 배부른 사람 출력
		Set<Entry<String, Integer>> entries = map.entrySet();
    	for(Entry<String, Integer> entry : entries) {
    		if(entry.getValue().equals(1)) {
    			loser = entry.getKey();
    		}
    	}
		System.out.println(loser);
	}
}
