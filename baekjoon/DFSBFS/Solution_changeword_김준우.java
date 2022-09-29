package _0412_DFSBFS;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_changeword_김준우 {
	static boolean[] visited;
	
	public static int bfs(String start, String target, String[] words) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(start);
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			String str = queue.poll();
			
			
			for (int i = 0; i < words.length; i++) {
				String str2 = words[i];
				
				if(isValid(str,str2) && !visited[i]) {
					if(str2.equals(target)) {
						//System.out.println("***"+str2+ cnt);
						return cnt;
					}
					//System.out.println(str2+cnt);
					queue.offer(str2);
					visited[i]= true;
				}
			}
			
			cnt++;
		}
		
		return 0;
	}
	
	public static boolean isValid(String word1, String word2) {
        int cnt = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) cnt++;
        }

        return cnt == 1;
    }
	
	public static boolean isContain(String[] words, String target) {
		for (String word : words) {
			if (word.equals(target)) {
				return true;
			}
		}
		return false;
	}
	
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        
        if(!isContain(words, target))return 0;
        
        for (int i = 0; i < words.length; i++) {
        	if(words[i].equals(begin)) visited[i]= true;
        }
        
        return bfs(begin, target, words);
        
        //return answer;
    }
    
	public static void main(String[] args) {
		/*
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin, target, words));
		*/
		String begin = "aab";
		String target = "aba";
		String[] words = {"abb", "aba"};
		System.out.println(solution(begin, target, words));
	}

}
