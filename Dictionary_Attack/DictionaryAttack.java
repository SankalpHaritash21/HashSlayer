//  Password Attacks

import java.security.*;
import java.io.*;

public class DictionaryAttack {
    // Method to hash a given password using the MD5 hashing algorithm.
public static String hashPassword(String password) throws NoSuchAlgorithmException {
    // Step 1: Create an instance of the MD5 MessageDigest.
    // MessageDigest is a class provided by java.security package to generate hash values.
    MessageDigest md = MessageDigest.getInstance("MD5");
    
    // Step 2: Convert the input password string to a byte array.
    // The getBytes() method encodes the string into a sequence of bytes using the platform's default charset.
    byte[] hashBytes = md.digest(password.getBytes());

    System.out.print("Hashed password bytes: [");
    for (int i = 0; i < hashBytes.length; i++) {
        System.out.print(hashBytes[i]);
        if (i < hashBytes.length - 1) {
            System.out.print(", ");
        }
    }
    System.out.println("]");
    
    // Step 3: Initialize a StringBuilder to store the hexadecimal representation of the hash.
    // StringBuilder is used for building the final hashed string efficiently.
    StringBuilder sb = new StringBuilder();
    
    // Step 4: Loop through each byte in the hashBytes array.
    for (byte b : hashBytes) {
        // Step 5: Convert each byte to a 2-character hexadecimal string.
        // %02x → Formats the byte as a 2-digit hexadecimal number.
        // - %: Indicates that the format specifier is being used.
        // - 02: Ensures that the result is always 2 characters wide, padding with 0 if necessary.
        // - x: Converts the byte to a hexadecimal string.
        sb.append(String.format("%02x", b));
    }
    
    // Step 6: Convert the StringBuilder to a string and return the final hashed password.
    // The toString() method converts the StringBuilder content to a regular String.
    return sb.toString();
}


    public static void dictionaryAttack(String targetHash, String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("Checking password: " + line);
            if (hashPassword(line).equals(targetHash)) {
                System.out.println("Password found: " + line);
                br.close();
                return;
            }
        }
        System.out.println("Password not found.");
        br.close();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("MD5 Hash to Crack: 5f4dcc3b5aa765d61d8327deb882cf99 \n");
        System.out.println("Dictionary File: dictionary.txt\n");
        dictionaryAttack("5f4dcc3b5aa765d61d8327deb882cf99", "dictionary.txt");
    }
}