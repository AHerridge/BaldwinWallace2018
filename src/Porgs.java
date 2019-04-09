import java.util.Scanner;

public class Porgs
{
	public Porgs()
	{
		Scanner scanner = new Scanner(System.in);

		int caseCount = scanner.nextInt();

		for (int c = 0; c < caseCount; c++)
		{
			int length = scanner.nextInt();
			int[] seq = new int[length];

			for (int l = 0; l < length; l++)
			{
				seq[l] = scanner.nextInt();
			}

			int col = 0;
			while (col >= 0 && col < length && seq[col] != 0)
			{
				int val = seq[col];
				seq[col] = 0;
				col += val;
			}

			System.out.print("Case " + c + ": ");

			if (col < 0)
			{
				System.out.println("Left");
			}
			else if (col >= length)
			{
				System.out.println("Right");
			}
			else
			{
				System.out.println("Neither");
			}
		}
	}

	public static void main(String[] args)
	{
		new Porgs();
	}
}

/*
	3
	3
	2 -2 -1
	4
	1 2 3 -1
	4
	3 2 -1 -1
*/