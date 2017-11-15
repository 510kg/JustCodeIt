class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<Character>();
        int max = 0;
        int slow = 0;
        int fast = 0;
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
}