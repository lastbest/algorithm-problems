import java.util.Scanner;

public class Main_17478_���ؿ� {
	public static int ja(int n, int m) {
		StringBuilder sb = new StringBuilder();
		StringBuilder ub = new StringBuilder();
		for(int i = 0;i<m-n;i++)
			ub.append("____");
		if(n>0) {
			sb.append(ub);
			sb.append("\"����Լ��� ������?\"\n");
			sb.append(ub);
			sb.append("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n");
			sb.append(ub);
			sb.append("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n");
			sb.append(ub);
			sb.append("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n");
			System.out.print(sb);
			ja(n-1,m);
		}
		else {
			System.out.print(ub);
			System.out.println("\"����Լ��� ������?\"");
			System.out.print(ub);
			System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
		}
		System.out.print(ub);
		System.out.println("��� �亯�Ͽ���.");
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		ja(N,N);
		
	}

}
