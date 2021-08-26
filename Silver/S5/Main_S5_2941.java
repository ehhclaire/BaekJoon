package boj.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S5_2941 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputs = br.readLine();
		
		inputs = inputs.replaceAll("c=", "0");
		inputs = inputs.replaceAll("c-", "1");
		inputs = inputs.replaceAll("dz=", "2");
		inputs = inputs.replaceAll("d-", "3");
		inputs = inputs.replaceAll("lj", "4");
		inputs = inputs.replaceAll("nj", "5");
		inputs = inputs.replaceAll("s=", "6");
		inputs = inputs.replaceAll("z=", "7");
		
		System.out.println(inputs.length());
	}
}
