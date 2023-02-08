import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.*;

public class Exercise18_01 {
    public static void main(String[] args) {
        // Get user input, match input against "correct" pattern, create BigInteger of the input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer of any size: ");
        String userInput = scanner.nextLine();
        Matcher matcher = Pattern.compile("\\d").matcher(userInput);
        String matched = "";
        while(matcher.find()) {
            matched = matched + matcher.group();
        }

        if (matched.length() == 0) {
            System.out.println("Incorrect input, please try again.");
            System.exit(1);
        }

        BigInteger number = new BigInteger(matched);

        // Compute factorial
        number = factorial(number);

        // Print output
        System.out.printf("Factorial of %s is %s", matched, number);
    }

    // Factorial recursive method
    public static BigInteger factorial(BigInteger number) {
        return factorial(number, new BigInteger("1"));
    }

    // Factorial tail recursive helper method
    private static BigInteger factorial(BigInteger number, BigInteger result) {
        if (number.toString().equals("0")) {
            return result;
        }
        return factorial(number.subtract(new BigInteger("1")), number.multiply(result));
    }

}
