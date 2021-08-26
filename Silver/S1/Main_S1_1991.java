package boj.Silver;

/**
 * 전위순회(루트->좌->우) : ABDCEFG
 * 중위순회(좌->루트->우) : DBAECFG
 * 후위순회(좌->우->루트) : DBEGFCA
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_S1_1991 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/boj_1991.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<String> queue = new LinkedList<String>();

		for(int i=0; i<N; i++) {
			String[] inputs = br.readLine().split(" ");
			for(int j=0; j<3; j++) {
				queue.add(inputs[j]);
			}
		}
		System.out.println(queue);
	}

}
