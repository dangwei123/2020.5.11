给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是最短的，请输出它的长度。
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        if(n<=1) return 0;
        int minIndex=-1;
        int min=nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i]>min){
                minIndex=i;
            }
            min=Math.min(min,nums[i]);
        }
        if(minIndex==-1) return 0;

        int maxIndex=-1;
        int max=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<max){
                maxIndex=i;
            }
            max=Math.max(max,nums[i]);
        }
        return maxIndex-minIndex+1;
    }
}

最长可整合子数组
public class GetLIL {
    public int getLIL(int[] arr){
        HashSet<Integer> set=new HashSet<>();
        int res=0;
        for(int i=0;i<arr.length;i++){
            int max=arr[i];
            int min=arr[i];
            set.add(arr[i]);
            for(int j=i+1;j<arr.length;j++){
                if(set.contains(arr[j])){
                    break;
                }
                max=Math.max(max,arr[j]);
                min=Math.min(min,arr[i]);
                if(max-min==j-i){
                    res=Math.max(res,j-i+1);
                }
            }
            set.clear();
        }
        return res;
    }
}


