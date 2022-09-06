import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1228_���ؿ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc;
		int N, inst_n;	//��ȣ�� ����, ��ɾ� ����
		for(int T = 1;T<=10;T++) {
			LinkedList<Integer> origin = new LinkedList<Integer>();	//���� ��ȣ��
			LinkedList<Integer> inst = new LinkedList<Integer>();	//��ɾ�
		
		
			N = Integer.parseInt(br.readLine());
			sc = new StringTokenizer(br.readLine()," ");
			while(sc.hasMoreTokens()) {
				origin.offer(Integer.parseInt(sc.nextToken()));	//ť�� ���� ��ȣ�� ����
			}
			inst_n = Integer.parseInt(br.readLine());
			
			sc = new StringTokenizer(br.readLine()," ");
			while(sc.hasMoreTokens()) {
				String temp = sc.nextToken();
				if(!temp.equals("I")) {
					inst.offer(Integer.parseInt(temp));	//ť�� ��ɾ� ����
				}
			}
			
			//System.out.println(inst);
			
			while(!inst.isEmpty()) {
				int x = inst.poll();
				int y = inst.poll();
				LinkedList<Integer> temp = new LinkedList<Integer>();	//������ ���� ����
				for(int i = 0;i<y;i++) {
					temp.offer(inst.poll());
					//origin.add(x,t);
				}
				for(int i = 0;i<y;i++) {
					int te = temp.pollLast();
					origin.add(x,te);
				}
				//System.out.println(temp);
				
			}
			System.out.print("#"+T+" ");
			for(int i=0;i<10;i++) {
				System.out.print(origin.get(i)+" ");
			}
			System.out.println();
		}
		
		
	}

}
