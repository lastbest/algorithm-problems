import java.util.ArrayList;
import java.util.Scanner;

public class Solution_5215_±èÁØ¿ì {
	static int N, L;
	//static int cur_cal;
	static int[] numbers;
	static int[] taste;
	static int[] kcal;
	static ArrayList<Integer> score;
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t<T; t++) {
			N = sc.nextInt();//Àç·á °¹¼ö
			L = sc.nextInt();//Á¦ÇÑ Ä®·Î¸®
			
			numbers = new int[N];
			isSelected = new boolean[N];
			taste = new int[N];//¸ÀÁ¡¼ö ¹è¿­
			kcal = new int[N];//Ä®·Î¸® ¹è¿­
			score = new ArrayList<Integer>();
			for(int n = 0; n<N; n++) {
				taste[n] = sc.nextInt();
				kcal[n] = sc.nextInt();
			}
			permutation(0,0);
			for(int i = 0; i<score.size(); i++) {
				System.out.println(score.get(i));
				
			}
			
			
		}
	}
	public static void permutation(int cnt, int cur_cal) {
		boolean end = true;
		for(int i = 0; i<N;i++) {
			if(isSelected[i]) continue;
			if(cur_cal+kcal[i]>L) continue;
			numbers[cnt] = i;
			isSelected[i] =true;
			end = false;
			permutation(cnt+1,cur_cal+kcal[i]);
		}
		if(end) {
			int tempscore =0;
			for(int i = 0;i<cnt+1;i++) {
				tempscore += taste[i];
			}
			score.add(tempscore);
			
		}
	}

}
