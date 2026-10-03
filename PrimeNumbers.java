5import java.util.Scanner;

class PrimeNumbers {

	private static Scanner scn = new Scanner(System.in);

	public static void main(String args[]) {
		System.out.println("Enter total (N) prime numbers: ");
		String input = scn.nextLine();
		int totalNumber = Integer.parseInt(input);
		int count = 0;
		System.out.println("A List of the first " + totalNumber + " prime numbers");

		for (int num = 2; count < totalNumber; num++) {
			boolean isPrime = true;

			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime == true) {
				System.out.println(num);
				count++;
			}
		}
	}
}