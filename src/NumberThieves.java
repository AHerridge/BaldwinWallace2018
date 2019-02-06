import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class NumberThieves
{
	private static int getMin(Collection<Integer> nums)
	{
		int min = Integer.MAX_VALUE;

		for (Integer num : nums)
			if (num < min)
				min = num;

		return min;
	}

	private static int getMax(Collection<Integer> nums)
	{
		int max = 0;

		for (Integer num : nums)
			if (num > max)
				max = num;

		return max;
	}

	private static int getMissing(Collection<Integer> nums)
	{
		for (int i = getMin(nums) + 1; i < getMax(nums); i++)
			if (!nums.contains(i))
				return i;

		return getMax(nums) + 1;
	}

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		int numInputs = console.nextInt();

		for (int i = 0; i < numInputs; i++)
		{
			ArrayList<Integer> nums = new ArrayList<>();
			int length = console.nextInt();

			for (int j = 0; j < length; j++)
				nums.add(console.nextInt());

			System.out.println("Case " + (i + 1) + ": " + getMissing(nums));
		}

		console.close();
	}
}