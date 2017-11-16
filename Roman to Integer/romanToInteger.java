import java.util.*;

class Solution {
    public Solution() {}

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();
        int result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
        	if (map.get(s.charAt(i + 1)) <= map.get(s.charAt(i))) {
        		result += map.get(s.charAt(i));
        	} else {
        		result -= map.get(s.charAt(i));
        	}
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "XXX";
        String s2 = "VII";
        String s3 = "IM";

        int r1 = solution.romanToInt(s1);
        int r2 = solution.romanToInt(s2);
        int r3 = solution.romanToInt(s3);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
    }
}