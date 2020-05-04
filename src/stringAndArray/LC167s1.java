package stringAndArray;

public class LC167s1 {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0)
            return new int[0];
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] == target)
                return new int[]{left,right};
            if(numbers[left] + numbers[right] > target)
                right--;
            else {
                left++;
            }
        }
        return new int[0];
    }
}
