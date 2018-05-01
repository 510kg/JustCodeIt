import java.util.*;

class Solution {
    public List<List<Integer>> sumUp(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 2) {
            return results;
        }
        
        Map<Integer, List<Integer>> hash = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int num1 = num[i];
            int num2 = target - num1;
           // num1 == num2 
            if (hash.containsKey(num1)) {
                hash.get(num1).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                hash.put(num1, list);
            }
        }
        
        for (Map.Entry<Integer, List<Integer>> entry : hash.entrySet()) {
            int num1 = entry.getKey();5
            int num2 = target - num1;5
            if (num1 > num2) {
                continue;
            } else if (num1 == num2) {
                
            }
            if (hash.containsKey(num2)) {
                for (int i = 0; i < hash.get(num1).size(); i++) {
                    for (int j = i; j < hash.get(num2).size(); j++) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[hash.get(num2).get(j)]);
                        result.add(nums[hash.get(num1).get(i)]);
                        results.add(result);
                    }
                }
            }
        }
        
        return results;
    }
}



// [3, 4, 8, 2, 8] -> [(8, 2) (8, 2) (2, 8) (2,8) ]
[[2,4],[3]],[[2,4],[3]]

[5, 6, 2] -> emptyList

[5,5,5] -> [5,5] [5, 5] [5, 5]


