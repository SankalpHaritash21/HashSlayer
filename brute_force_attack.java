import java.security.*;

public class BruteForceAttack {
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) sb.append(String.format("%02x", b));
        return sb.toString();
    }

    public static void bruteForce(String targetHash, String charset, int maxLength) throws Exception {
        for (int length = 1; length <= maxLength; length++) {
            generateCombinations("", charset, length, targetHash);
        }
    }

    private static void generateCombinations(String prefix, String charset, int length, String targetHash) throws Exception {
        if (length == 0) {
            if (hashPassword(prefix).equals(targetHash)) {
                System.out.println("[+] Password found: " + prefix);
                System.exit(0);
            }
            return;
        }
        for (int i = 0; i < charset.length(); i++) {
            generateCombinations(prefix + charset.charAt(i), charset, length - 1, targetHash);
        }
    }

    public static void main(String[] args) throws Exception {
        bruteForce("900150983cd24fb0d6963f7d28e17f72", "abc", 3);
    }
}