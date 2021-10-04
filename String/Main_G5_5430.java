package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_G5_5430 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(br.readLine());	// 테스트케이스 수
		
		for(int testcase=1; testcase<=T; testcase++) {
			String func = br.readLine();				// 수행할 함수
			int N = Integer.parseInt(br.readLine());	// 배열에 들어있는 수
			
			String inputs = br.readLine();
			inputs = inputs.substring(1, inputs.length()-1);	// 양쪽 괄호 지우기
			
			String[] str = inputs.split(","); 
			
			ArrayList<String> list = new ArrayList<String>();
			
			for(int i=0; i<N; i++) {
				list.add(str[i]);
			}			
			
			int flag = 0;	// 맨 앞의 index로  flag 초기화
			int reverse = 0;	// R 명령 횟수 count 
			boolean error = false;	// error 발생 여부
			for(int i=0, end=func.length(); i<end; i++) {
				if(func.charAt(i)=='D') {	// Delete
					if(list.size()==0) {	// 현재 배열이 0인데 Delete를 수행하는 경우
						error = true;		
						break;
					}
					// Delete 정상 수행
					list.remove(flag);		
					if(flag>0) flag--;	// 사이즈 1개 줄었으니깐 flag값 1 감소					
				} else {	// Reverse
					reverse++;		
					flag = (list.size()-1)-flag;	// flag 위치 앞 -> 뒤, 뒤 -> 앞
				}
			}
			
			// 출력
			if(error) System.out.println("error");
			else {
				if(reverse%2==1) Collections.reverse(list);	
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				for(int i=0, end=list.size(); i<end; i++) {
					sb.append(list.get(i)).append(",");
				}
				if(sb.length()>1) sb.deleteCharAt(sb.lastIndexOf(","));
				sb.append("]");
				System.out.println(sb);
			}
		}
	}
	static String src = "4\r\n" + 
			"RDD\r\n" + 
			"4\r\n" + 
			"[1,2,3,4]\r\n" + 
			"DD\r\n" + 
			"1\r\n" + 
			"[42]\r\n" + 
			"RRD\r\n" + 
			"6\r\n" + 
			"[1,1,2,3,5,8]\r\n" + 
			"R\r\n" + 
			"0\r\n" + 
			"[]";
}
