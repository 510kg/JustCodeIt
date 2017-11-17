import java.util.*;

class Solution {
    public Solution() {}

    private int lo, maxLen;

    public String longestPalindrome1(String s) {
	    lo = 0;
	    maxLen = 0;
    if (s == null || s.length() < 2) {
        return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            searchPalindrome(s, i, i);
            searchPalindrome(s, i, i + 1);
        }

        return s.substring(lo, lo + maxLen);
    }

    private void searchPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (maxLen < right - left - 1) {//when the loop ends, there is extra ++ and -- happened.
            lo = left + 1;
            maxLen = right - left - 1;
        }
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String result = "";
        int curLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - curLen - 1, i)) {
                result = s.substring(i - curLen - 1, i + 1);
                curLen += 2;
            } else if (isPalindrome(s, i - curLen, i)) {
                result = s.substring(i - curLen, i + 1);
                curLen += 1;
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (left < 0) {
            return false;
        }
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "abccba";
        String s2 = "aaaaaaaaaa";
        String s3 = "abcdefg";

        String res11 = solution.longestPalindrome1(s1);
        String res21 = solution.longestPalindrome1(s2);
        String res31 = solution.longestPalindrome1(s3);

        String res12 = solution.longestPalindrome2(s1);
        String res22 = solution.longestPalindrome2(s2);
        String res32 = solution.longestPalindrome2(s3);

        System.out.println(res11);
        System.out.println(res21);
        System.out.println(res31);

        System.out.println(res12);
        System.out.println(res22);
        System.out.println(res32);
    }
}
