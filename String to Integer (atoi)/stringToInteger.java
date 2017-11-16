class Solution {
    Solution() {}

    public int myAtoi(String str) {
        if (str == null) {
        	return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
        	return 0;
        }
        int sign = 1;
        int index = 0;
        if (str.charAt(index) == '+') {
        	index++;
        } else if (str.charAt(index) == '-') {
        	index++;
        	sign = -1;
        }//if no sign then skip below

        long num = 0;

        for (; index < str.length(); index++) {
        	if (str.charAt(index) > '9' || str.charAt(index) < '0') {
        		break;
        	}
        	num = num*10 + (str.charAt(index) - '0');
        	if (num > Integer.MAX_VALUE) {
        		break;
        	}
        }

        if (num * sign >= Integer.MAX_VALUE) {
        	return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE) {
        	return Integer.MIN_VALUE;
        }

        return (int)num*sign;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();

    	String s1 = "    010";
    	String s2 = "-1678";
    	String s3 = "+12361278";
    	long eg = (long)Integer.MAX_VALUE + 2;
    	String s4 = String.valueOf(eg);

    	int r1 = solution.myAtoi(s1);
    	int r2 = solution.myAtoi(s2);
    	int r3 = solution.myAtoi(s3);
    	int r4 = solution.myAtoi(s4);

    	System.out.println(r1);
    	System.out.println(r2);
    	System.out.println(r3);
    	System.out.println(r4);
    }
}