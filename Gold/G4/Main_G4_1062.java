package BOJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 1. 26개 중 5개를 미리 배운걸로 처리
 * 2. 
 * 	2.1 조합, cnt==K, K개의 배운 글자로 읽을 수 있는 단어 count
 * 	2.2 count는 처리값 비교
 * 
 */
public class Main_G4_1062 {
	static int N;	// 총 입력 단어 수 
	static int K;	// 사용할 수 있는 알파벳 수
	static char[][] word;		// 단어를 저장할 배열
	static boolean[] learned = new boolean[26];	// 알파벳 읽었는지 여부
	static int result;			// 배울 문자 개수
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/boj_1062.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		word = new char[N][];
		result = 0;
		
		learned['a'-'a'] = true;
		learned['n'-'a'] = true;
		learned['t'-'a'] = true;
		learned['i'-'a'] = true;
		learned['c'-'a'] = true;
		
		for(int j=0; j<N; j++) {
			word[j] = br.readLine().toCharArray();	// 단어 하나씩 입력받아 char 배열에 저장
		}
		combination('a', 5);
		System.out.println(result);
	}

	
	private static void combination(int ch, int cnt) {
		if(cnt == K) {
			check();
			return;
		}
		if(ch >'z') return;
		combination(ch+1, cnt);	// ch 알파벳을 배우지 않을 경우
		
		if(!learned[ch-'a']) {	// 아직 배우지 않은 알파벳이라면
			learned[ch-'a'] = true;
			combination(ch+1, cnt+1);
			learned[ch-'a'] = false;
		}
	}
	
	private static void check() {
		int count = 0;
		for(int i=0; i<N; i++) {
			boolean isRead = true;
			for(int j=0, size=word[i].length; j<size; j++) {
				int l = word[i][j]-'a';
				if(!learned[l]) {
					isRead = false;
					break;
				}
			}
			if(isRead) {
				count++;
			}
		}
		result = Math.max(count, result);
	}
}
