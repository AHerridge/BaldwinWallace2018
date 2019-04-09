import java.util.Scanner;

public class InterceptedFrequencies
{
	private InterceptedFrequencies()
	{
		Scanner scanner = new Scanner(System.in);

		int caseCount = scanner.nextInt();

		for (int c = 0; c < caseCount; c++)
		{
			int lineCount = scanner.nextInt();
			String[][] messages = new String[lineCount][lineCount];

			for (int t = 0; t < lineCount; t++)
			{
				int m = scanner.nextInt();
				int l = scanner.nextInt();
				String line = scanner.nextLine().trim();

				messages[m][l] = line;
			}

			System.out.println("Case " + c + ":");

			for (int m = 0; m < messages.length; m++)
			{
				String[] message = messages[m];

				if (message[0] == null)
				{
					break;
				}

				System.out.println("Message " + m + ":");

				for (String line : message)
				{
					if (line == null)
					{
						break;
					}

					System.out.println(line);
				}
			}
		}
	}

	public static void main(String[] args)
	{
		new InterceptedFrequencies();
	}
}
