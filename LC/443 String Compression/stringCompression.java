import java.util.*;

class Solution {
	Solution() {}

    public int compress(char[] chars) {
        if (chars == null) {
        	return 0;
        }
        if (chars.length < 2) {
        	return chars.length;
        }
        int prev = 0;
        int curr = 0;
        int count = 0;
        while (curr < chars.length) {
        	count++;
        	if (curr == chars.length - 1 || chars[curr] != chars[curr + 1]) {
        		chars[prev] = chars[curr];
                if (count != 1) {
        		    char[] arr = String.valueOf(count).toCharArray();
        		    for (int i = 0; i < arr.length; i++) {
        			    chars[++prev] = arr[i];
        		    }
                }
        		prev++;
        		count = 0;

        	}
        	curr++;
        }
        return prev;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

		char[] chars1 = new char[] {'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
		char[] chars2 = new char[] {'a', 'b', 'c'};
		char[] chars3 = new char[] {'a'};
		int result = solution.compress(chars1);
		System.out.println(result);
	}
}