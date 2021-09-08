package boj.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}	
	
	@Override
	public int compareTo(Node o) {
		int result = this.y - o.y;
		if(result==0) {
			return this.x - o.x;
		}
		return result;
	}	
}

public class Main_G3_2412 {
	
	static Node[] numbers;
	static int n;
	static int T;
	static boolean[] visited;
	static Queue<Node> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		numbers = new Node[n];
		visited=  new boolean[n];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
            numbers[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(numbers);
		
		System.out.println(bfs());
	}

	private static int bfs() {
		queue = new LinkedList<Node>();
		
		queue.add(new Node(0, 0));
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0; s<size; s++) {
				Node node = queue.poll();
				
				if(node.y == T) {
					return cnt;
				}
				lowerBound(node, 0, n);
				upperBound(node, 0, n);
			}
			cnt++;
		}
		return -1;
	}

	private static void lowerBound(Node node, int start, int end) {
	    if(start>end) return;
	    
	    int mid = (start + end)/2;
	    
	    if(Math.abs(numbers[mid].y-node.y) <= 2) {
	    	int leftIdx = mid;
	    	while(leftIdx>-1 && Math.abs(numbers[leftIdx].y - node.y) <= 2) {
	    		if(!visited[leftIdx] && Math.abs(numbers[leftIdx].x - node.x) <= 2) {
	    			queue.offer(numbers[leftIdx]);
	    			visited[leftIdx] = true;
	    		}
	    		leftIdx--;
	    	}
	    }
	    else if(numbers[mid].y > node.y) {
	    	lowerBound(node, start, mid-1);
	    } else {
	    	lowerBound(node, mid+1, end);
	    }
	}
	
	private static void upperBound(Node node, int start, int end) {
	    if(start>end) return;
	    
	    int mid = (start + end)/2;
	    
	    if(Math.abs(numbers[mid].y-node.y) <= 2) {
	    	int rightIdx = mid+1;
	    	while(rightIdx < n && Math.abs(numbers[rightIdx].y - node.y) <= 2) {
	    		if(!visited[rightIdx] && Math.abs(numbers[rightIdx].x - node.x) <= 2) {
	    			queue.offer(numbers[rightIdx]);
	    			visited[rightIdx] = true;
	    		}
	    		rightIdx++;
	    	}
	    }
	    else if(numbers[mid].y > node.y) {
	    	upperBound(node, start, mid-1);
	    } else {
	    	upperBound(node, mid+1, end);
	    }
	}

	static String src = "5 3\r\n" + 
			"1 2\r\n" + 
			"6 3\r\n" + 
			"4 1\r\n" + 
			"3 2\r\n" + 
			"0 2";
}
