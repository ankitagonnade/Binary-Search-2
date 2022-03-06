// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int searchFirst(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1]<nums[mid]){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
    public int searchLast(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1]>nums[mid]){
                    return mid;
                }else{
                    low = mid+1;
                }
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int last;
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        if(nums[0] > target || nums[nums.length-1] <  target)return new int[]{-1,-1};
        int first = searchFirst(nums, 0, nums.length-1, target);
        if(first == -1){
            return new int[]{-1,-1};
        }else{
            last = searchLast(nums, first, nums.length-1, target);
        }
        return new int[]{first,last};
    }
}