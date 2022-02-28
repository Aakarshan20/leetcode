package questions;

import java.util.HashMap;

public class TwoSum {
    /**
     *
     Question:
     Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Example:
     Given nums = [2, 7, 11, 15], target = 9,
     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].

     time: O(n)
     space: O(n)

     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target){
        int[] result = new int[]{-1,-1};// 初始化返回結果
        if(nums == null || nums.length < 2){ // 如果nums裡面的值不足以加總
            return result;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        // array to hashmap
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target- nums[i])){ // 判斷map中是否已有與當前array元素加成target
                result[0] =  map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 180;
        int[] result = twoSum(nums,target);
        for(int index: result){
            System.out.println(index);
        }
    }
}
