import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_���ؿ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t= 1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] room = new int[N][N];		//�Է¹޴� ��. �濡 ���� ����
			int start = N*N; int max_rooms = 0;	//����� ��. ����ؾ��� ��, �ִ� �̵��� �� ���� 
			
			for(int i = 0; i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j<N;j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i<N;i++) {
				for(int j = 0; j<N;j++) {
					int cur_r = i;	//���� Ž�� ��
					int cur_c = j;	//���� Ž�� ��
					int cnt = 0;	//�̵��� �� ����
					while(true) {
						cnt++;	//�̵��� �� ���� üũ
						int cur_value = room[cur_r][cur_c];
						int up = -1;int down = -1;int left = -1;int right = -1;
						
						if(cur_r>0) up = room[cur_r-1][cur_c];
						if(cur_r<N-1) down = room[cur_r+1][cur_c];
						if(cur_c>0) left = room[cur_r][cur_c-1];
						if(cur_c<N-1) right = room[cur_r][cur_c+1];
						
						if(up == cur_value+1) {
							cur_r --;
							continue;
						}
						else if(down == cur_value+1) {
							cur_r ++;
							continue;
						}
						else if(left == cur_value+1) {
							cur_c --;
							continue;
						}
						else if(right == cur_value+1) {
							cur_c ++;
							continue;
						}
						else {
							//System.out.println(cnt+"ȸ, ���۷� "+i+","+j + " �� " + room[i][j]);
							break;
						}
					}
					if(cnt > max_rooms) {
						max_rooms = cnt;
						start = room[i][j];
					}
					if(cnt == max_rooms) {
						max_rooms = cnt;
						if(room[i][j] < start) {
							start = room[i][j];
						}
					}
				}
			}
			
			sb.append("#" + t + " ");
			sb.append(start + " ");
			sb.append(max_rooms + " \n");
		}
		
		System.out.println(sb);
		
		
	}

}
