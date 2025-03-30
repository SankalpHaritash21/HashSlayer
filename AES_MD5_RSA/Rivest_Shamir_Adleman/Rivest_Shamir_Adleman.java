import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class AsymmetricRSA {

    /*
    
generateRSAKeyPair() – Generates and returns an RSA key pair.

encryptData(PublicKey publicKey, String data) – Encrypts data using the public key.

decryptData(PrivateKey privateKey, byte[] encryptedData) – Decrypts the encrypted data using the private key.

encodeToBase64(byte[] data) – Encodes the encrypted byte array to a Base64 string for readability.

decodeFromBase64(String data) – (Optional) Decodes Base64 back to byte array.

printPlainText(String data) – Prints the original plain text.

printEncryptedText(String encryptedText) – Prints the encrypted text.

printDecryptedText(String decryptedText) – Prints the decrypted text.

    */

    // 🎯 Generate RSA Key Pair
    private static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA"); // RSA Algorithm
        keyGen.initialize(2048); // RSA Key Size: 2048 bits
        return keyGen.generateKeyPair(); // Generate and return the key pair
    }

    // ✨ Encrypt Data using Public Key
    private static byte[] encryptData(PublicKey publicKey, String data) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA"); // Get RSA cipher instance
        cipher.init(Cipher.ENCRYPT_MODE, publicKey); // Initialize cipher for encryption
        return cipher.doFinal(data.getBytes()); // Encrypt the data and return as byte array
    }

    // 🔓 Decrypt Data using Private Key
    private static byte[] decryptData(PrivateKey privateKey, byte[] encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA"); // Get RSA cipher instance
        cipher.init(Cipher.DECRYPT_MODE, privateKey); // Initialize cipher for decryption
        return cipher.doFinal(encryptedData); // Decrypt and return the original data
    }

    // 📡 Encode Encrypted Data to Base64
    private static String encodeToBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data); // Convert to Base64 string
    }

    // 📚 Decode Base64 Encoded Data (Optional if needed)
    private static byte[] decodeFromBase64(String data) {
        return Base64.getDecoder().decode(data); // Decode from Base64 to byte array
    }

    // 📝 Print Original Plain Text
    private static void printPlainText(String data) {
        System.out.println("Plain Text: " + data);
    }

    // 🔐 Print Encrypted Text (Base64 Encoded)
    private static void printEncryptedText(String encryptedText) {
        System.out.println("Encrypted (Base64): " + encryptedText);
    }

    // 🔓 Print Decrypted Text
    private static void printDecryptedText(String decryptedText) {
        System.out.println("Decrypted: " + decryptedText);
    }


private static void printByteConversion(byte[] encryptedData) {
        System.out.println("\n Encrypted Data Byte Conversion:");
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-20s\n", "Index", "Decimal", "Hex", "Binary");
        System.out.println("--------------------------------------------------------");

        int limit=10;

        for (int i = 0; i < (encryptedData.length>limit ? limit : encryptedData.length); i++) {
            int value = encryptedData[i] & 0xFF; // Get unsigned byte value
            String hexValue = String.format("%02X", value); // Convert to hex
            String binaryValue = String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0'); // Convert to binary
            System.out.printf("%-10d %-10d %-10s %-20s\n", i, value, hexValue, binaryValue);
        }

        System.out.println("--------------------------------------------------------");
    }

    public static void main(String[] args) throws Exception {
        // 🎯 Step 1: Generate RSA Key Pair
        KeyPair keyPair = generateRSAKeyPair();

        // 🔑 Step 2: Extract Public and Private Keys
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // 📚 Step 3: Define Data to Encrypt
        String data = "Hello, RSA!"; // Data to be encrypted

        // ✨ Step 4: Encrypt Data using Public Key
        byte[] encryptedData = encryptData(publicKey, data);

        // 📡 Step 5: Encode Encrypted Data to Base64
        String encryptedText = encodeToBase64(encryptedData);

        // 📝 Step 6: Print Plain Text and Encrypted Data
        printPlainText(data);
        printByteConversion(encryptedData);
        printEncryptedText(encryptedText);

        // 🔓 Step 7: Decrypt Data using Private Key
        byte[] decryptedData = decryptData(privateKey, encryptedData);

        // 📚 Step 8: Convert Decrypted Data to String
        String decryptedText = new String(decryptedData);
        printDecryptedText(decryptedText);
    }

   
}
