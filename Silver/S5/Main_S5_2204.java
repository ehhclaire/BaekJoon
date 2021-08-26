package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_S5_2204 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			// 입력 문자의 소문자 버전을 key로, 입력 문자 그대로를 value로 가지는 map 생성
			Map<String, String> map = new HashMap<String, String>();
			String[] words = new String[N];
			for(int i=0; i<N; i++) {
				String str = br.readLine();		// 입력받은 문자
				words[i] = str.toLowerCase();	// 입력받은 문자를 소문자로 변형하여 차례대로 추가
				map.put(words[i], str);			// map 생성
			}
			
			Arrays.sort(words);		// 소문자로 구성된 배열을 오름차순 정렬
			System.out.println(map.get(words[0]));	// 앞서 정렬한 배열의 0번째 자리를 key로 가지는 value 출력
		}
	}
	static String src = "3\r\n" + 
			"Cat\r\n" + 
			"fat\r\n" + 
			"bAt\r\n" + 
			"4\r\n" + 
			"call\r\n" + 
			"ball\r\n" + 
			"All\r\n" + 
			"Hall\r\n" +
			"3\r\n" +
			"aaaa\r\n" + 
			"AAA\r\n" + 
			"AnT\r\n" +
			"1\r\n" +
			"aaaa\r\n" + 
			"0";
}
