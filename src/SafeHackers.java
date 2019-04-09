import java.util.Scanner;

public class SafeHackers
{
	private static int evaluate(int[] nums, String operation)
	{
		int total = nums[0];

		for (int i = 1; i < nums.length; i++)
		{
			switch (operation)
			{
				case "+":
					total += nums[i];
					break;
				case "-":
					total -= nums[i];
					break;
				case "*":
					total *= nums[i];
					break;
				case "/":
					total /= nums[i];
					break;
			}
		}

		return total;
	}

	private static boolean contains(int[] array, int value)
	{
		for (int num : array)
			if (num == value)
				return true;
		return false;
	}

	private static boolean checkTable(int[][] table)
	{
		for (int[] row : table)
			for (int i = 0; i < table.length; i++)
				if (!contains(row, i))
					return false;

		for (int i = 0; i < table[0].length; i++)
		{
			int[] col = new int[table.length];
			for (int j = 0; j < table.length; j++)
				col[j] = table[j][0];

			for (int j = 0; j < table.length; j++)
				if (!contains(col, j))
					return false;
		}

		return true;
	}

	private static boolean check(int[] nums, String operation, int total)
	{
		return evaluate(nums, operation) == total;
	}

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		int puzzleCount = console.nextInt();

		for (int puzzleIndex = 0; puzzleIndex < puzzleCount; puzzleIndex++)
		{
			int tableSize = console.nextInt();
			int[][] table = new int[tableSize][tableSize];

			for (int i = 0; i < tableSize; i++)
				for (int j = 0; j < tableSize; j++)
					table[j][i] = console.nextInt();

			int groupCount = console.nextInt();
			String[] groups = new String[groupCount];

			for (int i = 0; i < groupCount; i++)
				groups[i] = console.nextLine();

			if (checkTable(table))
			{
				for (String group : groups)
				{
					String[] atoms = group.split(" ");
					int[] nums = new int[atoms.length - 2];

					for (int i = 0; i < nums.length; i++)
						nums[i] = Integer.parseInt(atoms[i]);

					if (!check(nums, atoms[atoms.length - 2], Integer.parseInt(atoms[atoms.length - 1])))
					{
						System.out.println("Case " + (puzzleIndex + 1) + ": Solution is incorrect");
						return;
					}
				}

				System.out.println("Case " + (puzzleIndex + 1) + ": Solution is correct");
			}

			System.out.println("Case " + (puzzleIndex + 1) + ": Solution is incorrect");
		}
	}
}
