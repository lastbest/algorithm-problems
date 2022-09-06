import java.util.Scanner;

public class Solution_1954_���ؿ� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case =0; test_case<T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];	//������ �迭
			int nums = N*N;	//�� ������ ����
			int[][] dir = {{0,0},{0,1},{1,0},{0,-1},{-1,0}};	//���� ��� ����, �����»� ������ ���ư�
			int cur_r =0; int cur_c =0; int cur_dir = 0;	//���� ��� ��ġ �� ���� ���� 
			for(int i =0; i < nums; i++) {
				int temp_r = cur_r + dir[cur_dir][0];
				int temp_c = cur_c + dir[cur_dir][1];
				//�迭�� �Ѿ�ų� �̹� ���� ��ϵ� ��� ������� ������ ����
				if(temp_r < 0 || temp_c < 0 || temp_r >= N || temp_c >= N || arr[temp_r][temp_c] != 0) {	
					if(cur_dir>=4) 
						cur_dir = 1;
					else
						cur_dir++;
					temp_r = cur_r + dir[cur_dir][0];
					temp_c = cur_c + dir[cur_dir][1];
				}
				cur_r = temp_r;
				cur_c = temp_c;
				arr[cur_r][cur_c] = (i+1);
				if(cur_dir == 0)cur_dir++;
				//System.out.println(cur_r);System.out.println(cur_c);
			}
			System.out.println("#"+(test_case+1));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}
}
