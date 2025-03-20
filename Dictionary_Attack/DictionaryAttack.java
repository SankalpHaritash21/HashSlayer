//  Password Attacks

import java.security.*;
import java.io.*;

public class DictionaryAttack {
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) sb.append(String.format("%02x", b));
        return sb.toString();
    }

    public static void dictionaryAttack(String targetHash, String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            if (hashPassword(line).equals(targetHash)) {
                System.out.println("[+] Password found: " + line);
                br.close();
                return;
            }
        }
        System.out.println("[-] Password not found.");
        br.close();
    }

    public static void main(String[] args) throws Exception {
        dictionaryAttack("5f4dcc3b5aa765d61d8327deb882cf99", "dictionary.txt");
    }
}