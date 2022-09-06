import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_���ؿ� {
	static int N, M, K, min;
	static int[][] arr, arr_og, inst;
	static int[] selected;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		min = -1;
		arr = new int[N][M];
		arr_og = new int[N][M];
		inst = new int[K][3];
		selected = new int[K];
		isSelected = new boolean[K];
		
		//==========�迭�Է�==================
		for(int n = 0;n<N;n++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int m = 0;m<M;m++) {
				arr_og[n][m] = Integer.parseInt(st.nextToken());
				arr[n][m] = arr_og[n][m];
			}
		}
		
		//=============��ɾ� �Է�======================
		for(int k = 0;k<K;k++) {
			st = new StringTokenizer(br.readLine()," ");
			inst[k][0] = Integer.parseInt(st.nextToken());
			inst[k][1] = Integer.parseInt(st.nextToken());
			inst[k][2] = Integer.parseInt(st.nextToken());			 
		}
		solve(0);
		System.out.println(min);
	}
	
	public static void solve(int cnt) {
		if(cnt == K) {
			//System.out.println(Arrays.toString(selected));
			init_arr();
			for(int i = 0; i<K; i++) {
				int t = selected[i];
				rotation(inst[t][0],inst[t][1],inst[t][2]);
			}
			int mint = getmin();
			if(mint<min || min == -1) {
				min = mint;
			}
			
			return;
		}
		
		for(int i = 0;i<K;i++) {
			if(isSelected[i]) continue;
			
			selected[cnt] = i;
			if(isSelected[i]) continue;
			
			selected[cnt] = i;
			isSelected[i] = true;
			
			solve(cnt+1);
			isSelected[i] = false;
		}
		
	}
	
	
	//�迭 ȸ����Ű��
	public static void rotation(int r, int c, int s) {
		int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
		int[][] arr2 = arr;
		
		for(int dep = 0; dep<s;dep++) {	//dep�� �ٱ����� ���° ���簢�� ����Ŭ���� �ǹ�(0���� ����)
			int cur_dir = 0;	//Ž�� ���� 0�� 1�� 2�� 3��
			int cur_r = r-s-1+dep;	//���� �� �ʱ�ȭ.
			int cur_c = c-s-1+dep;	//���� �� �ʱ�ȭ
			int temp = arr2[cur_r][cur_c];	//
			for(int rot = 0; rot<4; rot++) {
				for(int strait = 0; strait<(s-dep)*2; strait++) {
					int next_r = cur_r+dir[cur_dir][0];	//���� ĭ�� ��
					int next_c = cur_c+dir[cur_dir][1];	//���� ĭ�� ��
					int temp2 = arr2[next_r][next_c];	//���� ĭ �� ����
					arr2[next_r][next_c] = temp;			//���� ĭ ���� ����ĭ ������ �ٲ�
					temp = temp2;
					cur_r = next_r;
					cur_c = next_c;
				}
				cur_dir++;
			}
		}
	}
	
	//arr�� ���� �Է¹޾Ҵ� ������ �ʱ�ȭ
	public static void init_arr() {
		for(int n = 0;n<N;n++) {
			for(int m = 0;m<M;m++) {
				arr[n][m] = arr_og[n][m];
			}
		}
	}
	
	//�迭�� �� ���� ���� ���� �ּҰ��� ��ȯ
	public static int getmin() {
		int min = -1;
		for(int n = 0;n<N;n++) {
			int temp = 0;
			for(int m = 0;m<M;m++) {
				temp += arr[n][m];
			}
			if(min == -1 || min>temp) min = temp;
		}
		
		return min;
	}

}
