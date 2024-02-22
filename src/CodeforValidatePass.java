import java.util.*;

public class CodeforValidatePass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password;
        System.out.println("Hello!");
        do {

            System.out.println("Please create a password: ");
            System.out.println(
                    "1. The password length must be between 8 and 16 characters." +
                            "\n2. The password must contain four of the following categories:" +
                            "\n   a) Lowercase letters (a-z)" +
                            "\n   b) Uppercase letters (A-Z)" +
                            "\n   c) Numbers (0-9)" +
                            "\n   d) Special symbols: ~!@#$%^&*()-=+_");

            password = input.nextLine();
        } while (!is_Valid_Password(password));

        System.out.println("Password is valid!");
    }

    public static boolean is_Valid_Password(String password) {
        if (password.length() >= 8 && password.length() <= 16) {
            int charUpperCount = 0;
            int charLowerCount = 0;
            int digitCount = 0;
            int specialCharCount = 0;

            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    charUpperCount++;
                } else if (Character.isLowerCase(c)) {
                    charLowerCount++;
                } else if (Character.isDigit(c)) {
                    digitCount++;
                } else if ("~!@#$%^&*()-=+_".contains(String.valueOf(c))) {
                    specialCharCount++;
                }
            }

            // Validate category counts
            return charUpperCount >= 1 && charLowerCount >= 1 && digitCount >= 1 && specialCharCount >= 1;
        } else {
            System.out.println("Invalid password. Please try again.");
            return false;
        }
    }
}