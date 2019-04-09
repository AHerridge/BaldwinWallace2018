import java.util.Arrays;
import java.util.Scanner;

public class CircuitBreaker
{
	public CircuitBreaker()
	{
		Scanner scanner = new Scanner(System.in);
		int caseCount = scanner.nextInt();

		for (int c = 0; c < caseCount; c++)
		{
			int startRow = scanner.nextInt();
			int startCol = scanner.nextInt();
			int moves = scanner.nextInt();
			boolean inc = scanner.nextInt() == 1;
			int[][] mat = new int[10][10];

			for (int row = 0; row < 10; row++)
			{
				for (int col = 0; col < 10; col++)
				{
					mat[row][col] = scanner.nextInt();
				}

				System.out.println(Arrays.toString(mat[row]));
			}

			int col = startCol;
			int row = startRow;
			int total = 0;

			for (int move = 0; move < moves; move++)
			{
				total += mat[row][col];
				int[] newCoords = getBestTile(mat, col, row, inc);

				if (inc)
				{
					mat[row][col] = Integer.MIN_VALUE;
				}
				else
				{
					mat[row][col] = Integer.MAX_VALUE;
				}

				col = newCoords[0];
				row = newCoords[1];
			}

			System.out.println("Case " + c + ":" + total);
		}
	}

	private int[] getBestTile(int[][] mat, int startCol, int startRow, boolean inc)
	{
		int[] bestTile = null;

		for (int row = Math.max(0, startRow - 1); row < Math.min(mat.length, startRow + 1); row++)
		{
			for (int col = Math.max(0, startCol - 1); col < Math.min(mat[0].length, startCol + 1); col++)
			{
				if (row != startRow || col != startCol)
				{
					if (bestTile == null)
					{
						bestTile = new int[]{row, col};
					}

					if (inc)
					{
						if (mat[row][col] > mat[bestTile[0]][bestTile[1]])
						{
							bestTile = new int[]{row, col};
						}
					}
					else
					{
						if (mat[row][col] < mat[bestTile[0]][bestTile[1]])
						{
							bestTile = new int[]{row, col};
						}
					}
				}
			}
		}

		return bestTile;
	}

	public static void main(String[] args)
	{
		new CircuitBreaker();
	}
}
