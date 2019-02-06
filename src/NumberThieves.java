import java.util.Arrays;
import java.util.Collection;

public class NumberThieves {
    private static int getMin(Collection<Integer> nums) {
        int min = 0;

        for (Integer num : nums)
            if (num < min)
                min = num;

        return min;
    }

    private static int getMax(Collection<Integer> nums) {
        int max = 0;

        for (Integer num : nums)
            if (num > max)
                max = num;

        return max;
    }

    private static int getMissing(Collection<Integer> nums) {
        for (int i = getMin(nums); i < getMax(nums); i++)
            if (!nums.contains(i))
                return i;

        return getMax(nums) + 1;
    }

    public static void main(String[] args) {
        System.out.println(getMissing(Arrays.asList(1, 1, 2, 3, 5, 6)));
    }
}