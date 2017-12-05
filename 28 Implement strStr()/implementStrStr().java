class Solution {
	Solution() {}
    
    //Regular Solution
    public int strStr(String haystack, String needle) {
    	if (haystack == null || haystack.length() == 0 || haystack.length() < needle.length()) {
    		return -1;
    	}
    	if (needle == null || needle.length() == 0) {
    		return 0;
    	}
    	for (int i = 0; i <= haystack.length() - needle.length(); i++) {
    		int j = 0;
    		for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                	break;
                }
    		}

    		if (j == needle.length()) {
    			return i;
    		}
    	}
    	return -1;
    }

    public int strStrMostVoted(String haystack, String needle) {
    	if (haystack == null || needle == null) {
    		return -1;
    	}
    	for (int i = 0; ; i++) {
    		for (int j = 0; ; j++) {
    			if (j == needle.length()) {
    				return i;
    			}
    			if (i + j == haystack.length()) {
    				return -1;
    			}
    			if (haystack.charAt(i + j) != needle.charAt(j)) {
    				break;
    			}
    		}
    	}
    }


	public static void main(String[] args) {
        Solution solution = new Solution();

        String source1 = "fdshaulknw";
        String target1 = "hau";
        String target2 = "fdshaulknw";

        int res1 = solution.strStr(source1, target1);
        int res2 = solution.strStr(source1, target2);

        System.out.println(res1);
        System.out.println(res2);
	}
}