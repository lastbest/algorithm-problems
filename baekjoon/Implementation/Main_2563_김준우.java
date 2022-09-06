import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_김준우{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] white = new int[100][100];	//100X100 �Ͼ� ��ȭ�� �迭
		int N = Integer.parseInt(br.readLine());	//������ ����
		int black = 0;	//���� ������ ����
		int cnt = 0;
		
		for(int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());	//���� ���� �Ÿ�
			int p = Integer.parseInt(st.nextToken());	//���� ���� �Ÿ�
			for(int i=0;i<10;i++) {
				for(int j = 0;j<10;j++) {
					//�ش� �鿡 �����̰� �÷��� ���� ���� ��쿡�� ������ ���̸� ������Ų��.
					if(white[i+p][j+v]!=1) {
						white[i+p][j+v] = 1;
						black+=1;
					}
				}
			}
		}
		System.out.println(black);
	}

}