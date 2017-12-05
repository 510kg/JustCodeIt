import java.util.*;

class Solution {
    public Solution() {}

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int fast = 0;
        int slow = 0;
        Set<Character> set = new HashSet<>();

        while (fast < s.length()) {
            if (set.contains(s.charAt(fast))) {
                if (max < fast - slow) {
                    max = fast - slow;
                }
                while (s.charAt(slow) != s.charAt(fast)) {//eg. abcb
                set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            } else {
                set.add(s.charAt(fast));
            }
            fast++;
        }

        return Math.max(max, fast - slow);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "abcbdebbacdwot";
        String s2 = "aaaaaa";
        String s3 = "abcabcbb";

        int result1 = solution.lengthOfLongestSubstring(s1);
        int result2 = solution.lengthOfLongestSubstring(s2);
        int result3 = solution.lengthOfLongestSubstring(s3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}