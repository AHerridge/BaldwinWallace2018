import java.util.Scanner;

public class TwinBinaryEngine
{
	private static int log2(long value)
	{
		return (int) (Math.log(value) / Math.log(2));
	}

	private static int numbersWithXDigits(int x)
	{
		return x >= 3 ? (int) Math.pow(2, x - 1) : 2;
	}

	private static long getAvgBinaryLength(int input)
	{
		int log = log2(input);
		long total = 0;

		for (int i = 1; i <= log; i++)
			total += numbersWithXDigits(i) * i;

		total += (input - Math.pow(2, log)) * (log + 1);

		return total / input;
	}

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		int numInputs = console.nextInt();

		for (int i = 0; i < numInputs; i++)
			System.out.println("Case " + i + ": " + getAvgBinaryLength(console.nextInt()));

		console.close();
	}
}