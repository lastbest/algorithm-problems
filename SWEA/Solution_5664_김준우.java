import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5664_김준우 {
	static int M, A;	//이동시간, 충전기 개수
	
	static LinkedList<Integer> dir_A, dir_B;	//이동정보
	static int[][] AP;	//AP 충전기 정보 
	static int[] dirx = {0,0,1,0,-1};	//X 정지 상우하좌
	static int[] diry = {0,-1,0,1,0};	//Y 정지 상우하좌
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T;t++) {
			//=====input 1st line==========
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			dir_A = new LinkedList<Integer>();	dir_A.add(0);
			dir_B = new LinkedList<Integer>();	dir_B.add(0);
			AP = new int[A][4];
			
			//======input movement================
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0;i<M;i++) {
				dir_A.add(Integer.parseInt(st.nextToken())	);
			}
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0;i<M;i++) {
				dir_B.add(Integer.parseInt(st.nextToken())	);
			}
			
			//========input information of APs============
			for(int i = 0;i<A;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0;j<4;j++) {
					AP[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#");sb.append(t);sb.append(" ");
			sb.append(solution());
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int solution() {
		int Ax = 1;		int Ay = 1;
		int Bx = 10;	int By = 10;
		int sum = 0;
		for(int i = 0;i<=M;i++) {
			int ad = dir_A.pop();
			int bd = dir_B.pop();
			Ax += dirx[ad];	Ay += diry[ad];
			Bx += dirx[bd];	By += diry[bd];
			sum += charge(Ax,Ay,Bx,By);
		}
		return sum;
	}
	
	public static int charge(int ax, int ay, int bx, int by) {
		int[] a_ap = new int[A];int[] b_ap = new int[A];
		int a =0; int b= 0;
		int charged = 0;
		for(int i = 0;i<A;i++) {
			int X = AP[i][0];
			int Y = AP[i][1];
			int C = AP[i][2];
			int P = AP[i][3];
			if(Math.abs(ax-X) + Math.abs(ay-Y) <= C ) {
				a_ap[i] = 1;
				a++;
			}
			if(Math.abs(bx-X) + Math.abs(by-Y) <= C  ) {
				b_ap[i] = 1;
				b++;
			}
		}
		
		for(int i = 0;i<A;i++) {
			for(int j = 0;j<A;j++) {
				if(a_ap[i] == 0 && b_ap[i] == 0 ) continue;
				int amount = 0;
				if(a_ap[i] == 1) {
					amount += AP[i][3];
				}
				if(b_ap[j] == 1) {
					amount += AP[j][3];
				}
				if(i == j && a_ap[i] == 1 && b_ap[i] == 1) {
					amount = amount/2;
				}
				if(charged<amount) charged =amount;
			}
		}
		
		return charged;
	}

}
