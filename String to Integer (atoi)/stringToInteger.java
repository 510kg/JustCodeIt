class Solution {
    Solution() {}

    public int myAtoi(String str) {
        if (str == null) {
        	return 0;
        }
        str.trim();
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

        if (num >= Integer.MAX_VALUE) {
        	return Integer.MAX_VALUE;
        }
        if (num <= Integer.MIN_VALUE) {
        	return Integer.MIN_VALUE;
        }

        return (int)num*sign;
    }

    public static void main(String[] args) {
    	Solution solution = new Solution();

    	String s1 = "987124";
    	String s2 = "-1678";
    	String s3 = "+12361278";
    	long eg = (long)Integer.MAX_VALUE + 2;
    	String s4 = String.valueOf(eg);

    	System.out.println(s1);
    	System.out.println(s2);
    	System.out.println(s3);
    	System.out.println(s4);
    }
}