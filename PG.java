import java.security.SecureRandom;

public class PG {
    // Define the characters that can be used in the generated password
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    public static void main(String[] args) {
        int length = 12; // Default password length
        boolean includeUpperCase = true;
        boolean includeLowerCase = true;
        boolean includeNumbers = true;
        boolean includeSpecialCharacters = true;

        // Generate and print the password
        String password = generatePassword(length, includeUpperCase, includeLowerCase, includeNumbers, includeSpecialCharacters);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, boolean includeUpperCase, boolean includeLowerCase,
                                          boolean includeNumbers, boolean includeSpecialCharacters) {
        StringBuilder validChars = new StringBuilder();

        // Include the required character sets based on user preferences
        if (includeUpperCase) {
            validChars.append(UPPER_CASE);
        }
        if (includeLowerCase) {
            validChars.append(LOWER_CASE);
        }
        if (includeNumbers) {
            validChars.append(NUMBERS);
        }
        if (includeSpecialCharacters) {
            validChars.append(SPECIAL_CHARACTERS);
        }

        // Check if at least one character set is included
        if (validChars.length() == 0) {
            throw new IllegalArgumentException("At least one character set should be included.");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder passwordBuilder = new StringBuilder(length);

        // Generate the password
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            passwordBuilder.append(validChars.charAt(randomIndex));
        }

        return passwordBuilder.toString();
    }
}
