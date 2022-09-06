import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_6808_김준우 {
	static int[] selected;
	static boolean[] isSelected;
	static ArrayList<Integer> deck1, deck2;	//규영, 인영이덱
	static int win, lose;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t= 1;t<=T;t++) {
			deck1 = new ArrayList<Integer>();	//구영덱
			deck2 = new ArrayList<Integer>();
			selected = new int[9];
			isSelected = new boolean[9];
			win = 0; lose = 0;
			
			//규영이 카드 입력
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0; i<9;i++) {
				deck1.add(Integer.parseInt(st.nextToken()));
			}
			
			//규영이 덱에 없는 숫자는 인영이 덱에 넣기
			for(int i = 1; i<=18;i++) {
				if(!deck1.contains(i)) {
					deck2.add(i);
				}
			}
			
			permutation(0);
			
			sb.append("#");sb.append(t);sb.append(" ");
			sb.append(win);sb.append(" ");sb.append(lose);sb.append("\n");
			}
		System.out.println(sb);
	}
	
	public static void permutation(int cnt) {
		if(cnt == 9) {
			int win_t = 0; int lose_t = 0;
			for(int i = 0;i<9;i++) {
				if(selected[i]<deck1.get(i)) { 
					win_t += selected[i]+deck1.get(i); 
				}
				else if(selected[i]>deck1.get(i)) { 
					lose_t += selected[i]+deck1.get(i);
				}
			}
			if (win_t > lose_t) {
				win++;
			}
			else if (win_t < lose_t) { 
				lose++; 
			}
			return;
		}
		for(int i = 0;i<9;i++) {
			if(isSelected[i]) continue;
			
			selected[cnt] = deck2.get(i);
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
		
	}

}

 
