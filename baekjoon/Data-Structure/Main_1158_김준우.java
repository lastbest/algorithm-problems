import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1158_±èÁØ¿ì {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int[] josepus = new int[N];
		int index_k = K-1;
		//Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 1;i<=N;i++) {
			queue.offer(i);
		}
		
		System.out.print("<");
		for(int i = 0;i<N;i++) {
			int t = queue.remove(index_k);
			josepus[i] = t;
			if(!queue.isEmpty())index_k = (index_k + K-1)%queue.size();
			else index_k = (index_k + K-1);
			/*
			while(index_k > queue.size()-1 ) {
				index_k -= queue.size(); 
				if(queue.size() == 0)break;
			}*/
			System.out.print(t);
			if(i<N-1)System.out.print(", ");
			
		}
		System.out.println(">");
		

	}

}
