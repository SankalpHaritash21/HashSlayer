# 🚀 Brute Force Attack Implementation in Python and Java

## 📚 Project Overview

This project demonstrates a **Brute Force Attack** used to systematically guess a password by trying all possible combinations of characters from a defined character set. The attack compares the hashed value of each combination with the target hash to identify the correct password.

✅ **Goal:**

- Try all possible combinations of characters to identify the original password.
- Works by comparing the MD5 hash of generated strings with the target hash.

---

## 📌 How It Works

- **Step 1:** Input a character set (`charset`) and the maximum password length (`max_length`).
- **Step 2:** Generate all possible combinations of the characters for lengths ranging from 1 to `max_length`.
- **Step 3:** Hash each generated combination using the **MD5 algorithm**.
- **Step 4:** Compare the hash of each combination to the target hash.
- **Step 5:** If a match is found, display the password and stop the attack.

---

🐍 Python Code (brute_force.py)

```
import itertools
import hashlib


def brute_force_attack(charset, max_length, target_hash):
    for length in range(1, max_length + 1):
        for guess in itertools.product(charset, repeat=length):
            guess_word = ''.join(guess)
            # Generate MD5 hash of the guessed word
            if hashlib.md5(guess_word.encode()).hexdigest() == target_hash:
                print(f"[+] Password found: {guess_word}")
                return
    print("[-] Password not found")
```

# Example Usage:

brute_force_attack("abc", 3, "900150983cd24fb0d6963f7d28e17f72")
☕ Java Code (BruteForceAttack.java)

```
import java.security.*;

public class BruteForceAttack {
    // Hashing function to generate MD5 hash
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) sb.append(String.format("%02x", b));
        return sb.toString();
    }

    // Main function to initiate brute force attack
    public static void bruteForce(String targetHash, String charset, int maxLength) throws Exception {
        for (int length = 1; length <= maxLength; length++) {
            generateCombinations("", charset, length, targetHash);
        }
    }

    // Recursive function to generate all combinations
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

    // Main method to run the Java program
    public static void main(String[] args) throws Exception {
        bruteForce("900150983cd24fb0d6963f7d28e17f72", "abc", 3);
    }
}

```
