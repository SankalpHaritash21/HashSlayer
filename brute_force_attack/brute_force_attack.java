// Import necessary classes from java.security package.
import java.security.*;

// Declare the public class BruteForceAttack.
public class BruteForceAttack {

    // ================================
    // 1. hashPassword(String password)
    // ================================
    /**
     * This method hashes a given password using the MD5 hashing algorithm.
     * @param password The password string to be hashed.
     * @return A hexadecimal string representing the MD5 hash of the input password.
     * @throws NoSuchAlgorithmException If the MD5 algorithm is not available.
     */
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        // Create an instance of the MessageDigest with MD5 algorithm.
        // MessageDigest generates a hash value from the input data.
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Convert the input password string into a byte array using the default character encoding.
        byte[] hashBytes = md.digest(password.getBytes());

        // Initialize a StringBuilder to build the final hash string in hexadecimal format.
        StringBuilder sb = new StringBuilder();

        // Loop through each byte in the hashBytes array.
        for (byte b : hashBytes) {
            // Convert each byte to a 2-character hexadecimal representation.
            // %02x → Ensures that the resulting string is always 2 characters wide, padding with 0 if necessary.
            sb.append(String.format("%02x", b));
        }

        // Return the final hashed password as a string.
        return sb.toString();
    }

    // ================================
    // 2. bruteForce(String targetHash, String charset, int maxLength)
    // ================================
    /**
     * Attempts to brute-force a password by trying all possible combinations of characters.
     * @param targetHash The target hash to compare with.
     * @param charset The set of characters to use in the brute-force attack.
     * @param maxLength The maximum length of the password to try.
     * @throws Exception If an error occurs during hashing.
     */
    public static void bruteForce(String targetHash, String charset, int maxLength) throws Exception {
        // Loop through all possible lengths of the password from 1 to maxLength.
        for (int length = 1; length <= maxLength; length++) {
            // Generate all possible combinations of the given charset and specified length.
            generateCombinations("", charset, length, targetHash);
        }
    }

    // ================================
    // 3. generateCombinations(String prefix, String charset, int length, String targetHash)
    // ================================
    /**
     * Generates all possible combinations of a given charset up to a specified length.
     * @param prefix The current prefix of the generated string.
     * @param charset The character set to use for generating combinations.
     * @param length The remaining length of the string to generate.
     * @param targetHash The hash to compare each generated combination with.
     * @throws Exception If an error occurs during hashing.
     */
    private static void generateCombinations(String prefix, String charset, int length, String targetHash) throws Exception {
        // Base case: If length is 0, a complete string has been generated.
        if (length == 0) {
            // Hash the generated string and compare it with the target hash.
            if (hashPassword(prefix).equals(targetHash)) {
                // If the hash matches, print the found password.
                System.out.println("[+] Password found: " + prefix);
                // Exit the program as the correct password has been found.
                System.exit(0);
            }
            // Return to stop further recursive calls.
            return;
        }

        // Loop through each character in the charset.
        for (int i = 0; i < charset.length(); i++) {
            // Append the current character to the prefix and reduce the remaining length.
            generateCombinations(prefix + charset.charAt(i), charset, length - 1, targetHash);
        }
    }

    // ================================
    // 4. main(String[] args)
    // ================================
    /**
     * The main method to initiate the brute-force attack.
     * @param args Command-line arguments (not used in this case).
     * @throws Exception If an error occurs during hashing or generation.
     */
    public static void main(String[] args) throws Exception {
        // Call the bruteForce() method to start brute-forcing.
        // "900150983cd24fb0d6963f7d28e17f72" is the target hash (MD5 of "abc").
        // "abc" is the character set used to generate combinations.
        // 3 is the maximum password length to try.
        bruteForce("900150983cd24fb0d6963f7d28e17f72", "abc", 3);
    }
}
