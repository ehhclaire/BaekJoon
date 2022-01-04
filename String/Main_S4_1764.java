package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_S4_1764 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 듣도 못한 사람의 수
		int M = Integer.parseInt(st.nextToken());	// 보도 못한 사람의 수
		
		Map<String, Integer> map = new HashMap<String, Integer>();	// 듣도 못한 사람을 저장할 map
		
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 1);	// 듣도 못한 사람이름을 key로 1을 value로 map에 저장
		}
		
		List<String> answer = new ArrayList<String>();	// 듣도 보도 못한 사람을 저장할 ArrayList
		
		for(int i=0; i<M; i++) {
			String name = br.readLine();	// 입력받은 보도 못한 사람
			if(map.containsKey(name)) answer.add(name);		// 위에서 저장한 map에 같은 이름을 가진 key가 존재한다면, answer에 추가			
		}
		
		Collections.sort(answer);	// 사전 순서로 정렬
	
		System.out.println(answer.size());	// 듣보잡 수 출력
		for(String a : answer) {	
			System.out.println(a);	// 듣보잡 명단 출력
		}		
	}
	
	static String src = "3 4\r\n" + 
			"ohhenrie\r\n" + 
			"charlie\r\n" + 
			"baesangwook\r\n" + 
			"obama\r\n" + 
			"baesangwook\r\n" + 
			"ohhenrie\r\n" + 
			"clinton";
}
