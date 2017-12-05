import java.util.*;

class Solution {
    Solution() {}

	public boolean isValid(String s) {
        if (s == null || s.length() < 2) {
        	return false;
        }

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
        	char curr = s.charAt(i);
        	if (curr == '(' || curr == '{' || curr == '[') {
        		stack.push(curr);
        	} else if (curr == ')' && !stack.isEmpty() && stack.peek() == '(') {
        		stack.pop();
        	} else if (curr == '}' && !stack.isEmpty() && stack.peek() == '{') {
        		stack.pop();
        	} else if (curr == ']' && !stack.isEmpty() && stack.peek() == '[') {
        		stack.pop();
        	} else {
        		return false;
        	}
        }

        return stack.isEmpty();
	}

	public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "{[{()[]}]}";
        String s2 = "{[}]";
        String s3 = "{[(((";
        String s4 = "{}[]()";

        boolean r1 = solution.isValid(s1);
        boolean r2 = solution.isValid(s2);
        boolean r3 = solution.isValid(s3);
        boolean r4 = solution.isValid(s4);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
	}
}