package moveZeros;

public class Solution {
    final private String url = "https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/567/";

    public void moveZeroes(int[] nums) {
        int index_head = 0;
        int index_tail = 0;
        while (index_head < nums.length) {
            while (nums[index_head] == 0){
                index_head += 1;
                if (index_head >= nums.length){
                    break;
                }
            }
            if (index_head < nums.length){
                int temp = nums[index_head];
                nums[index_head] = nums[index_tail];
                nums[index_tail] = temp;

                index_head += 1;
                index_tail += 1;
            }

        }
    }

    public void bestMemorySolution(int[] nums) {
        int counterWithoutNulls = 0;
        int counterWithNulls = 0;
        int length = nums.length;
        while (counterWithNulls < length) {
            if (nums[counterWithNulls] == 0) {// находим нулевые элементы и увеличиваем счётчик
                counterWithNulls++;
            } else { // сдвигаем элементы на количество найденных нулевых элементов слева
                nums[counterWithoutNulls++] = nums[counterWithNulls++];
            }
        }
        while (counterWithoutNulls < length) {
            nums[counterWithoutNulls++] = 0;// заполняем последние элементы массива нулями согласно счётчику нулей
        }
    }

    class BestRuntimeSolution {
        public void moveZeroes(int[] nums) {
            int n = nums.length;
            int c =0;
            for(int i=0;i<n;i++)
            {
                if(nums[i]==0)
                {
                    moveIt(nums,c,i);
                    break;
                }
            }
        }
        public void moveIt(int[] nums,int c,int i)
        {
            c++;
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[j]==0)
                {
                    moveIt(nums,c,j);
                    return;
                }
                nums[j-c]=nums[j];
            }
            for(int k=1;k<c+1;k++)
            {
                nums[nums.length-k]=0;
            }
        }
    }
}
