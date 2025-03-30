import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class SymmetricAES {
    /*
    
    generateAESKey(int keySize) – Generates the AES key of the specified size.

initializeCipher(SecretKey secretKey, int mode) – Initializes the Cipher for encryption or decryption.

encryptData(Cipher cipher, String data) – Encrypts the given data and returns the encrypted byte array.

encodeToBase64(byte[] data) – Converts encrypted byte array to Base64 for easy readability.

printPlainText(String data) – Prints the original plain text.

printByteArray(byte[] encryptedData) – Displays the encrypted byte array.

printByteConversion(byte[] encryptedData) – Prints byte conversion (decimal, hex, and binary).

printEncryptedText(String encryptedText) – Prints the final Base64 encoded encrypted text.

    */

    // 🎯 Generate AES Key
    private static SecretKey generateAESKey(int keySize) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES"); // Specify AES algorithm
        keyGenerator.init(keySize); // Initialize key size (128, 192, or 256 bits)
        return keyGenerator.generateKey(); // Generate and return the secret key
    }

    // 🔐 Initialize Cipher
    private static Cipher initializeCipher(SecretKey secretKey, int mode) throws Exception {
        Cipher cipher = Cipher.getInstance("AES"); // Get AES cipher instance
        cipher.init(mode, secretKey); // Initialize cipher with mode (ENCRYPT/DECRYPT)
        return cipher;
    }

    // ✨ Encrypt Data
    private static byte[] encryptData(Cipher cipher, String data) throws Exception {
        return cipher.doFinal(data.getBytes()); // Encrypt data and return byte array
    }

    // 📡 Encode Encrypted Data to Base64
    private static String encodeToBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data); // Encode and return Base64 string
    }

    // 📝 Print Original Plain Text
    private static void printPlainText(String data) {
        System.out.println("Plain Text: " + data);
    }

    // 📊 Print Encrypted Data as Byte Array
    private static void printByteArray(byte[] encryptedData) {
        System.out.print("\nByte Array: [");
        for (int i = 0; i < encryptedData.length; i++) {
            System.out.print(encryptedData[i] + (i < encryptedData.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    // 📊 Print Encrypted Data Byte Conversion
    private static void printByteConversion(byte[] encryptedData) {
        System.out.println("\n🔢 Encrypted Data Byte Conversion:");
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-20s\n", "Index", "Decimal", "Hex", "Binary");
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < encryptedData.length; i++) {
            int value = encryptedData[i] & 0xFF; // Get unsigned byte value
            String hexValue = String.format("%02X", value); // Convert to hex
            String binaryValue = String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0'); // Convert to binary
            System.out.printf("%-10d %-10d %-10s %-20s\n", i, value, hexValue, binaryValue);
        }

        System.out.println("--------------------------------------------------------");
    }

    // 🔐 Print Encrypted Text (Base64 Encoded)
    private static void printEncryptedText(String encryptedText) {
        System.out.println("\nEncrypted (Base64): " + encryptedText);
    }




    public static void main(String[] args) throws Exception {
        // 🎯 Step 1: Generate AES Key
        SecretKey secretKey = generateAESKey(128);

        // 🔐 Step 2: Initialize Cipher for AES Encryption
        Cipher cipher = initializeCipher(secretKey, Cipher.ENCRYPT_MODE);

        // 📚 Step 3: Define Data to Encrypt
        String data = "Hello, World!"; // Plain text to be encrypted

        // ✨ Step 4: Encrypt the Data
        byte[] encryptedData = encryptData(cipher, data);

        // 📡 Step 5: Encode Encrypted Data to Base64
        String encryptedText = encodeToBase64(encryptedData);

        // 📝 Step 6: Print Original Plain Text
        printPlainText(data);

        // 📊 Step 7: Print Encrypted Data as Byte Array
        printByteArray(encryptedData);

        // 📊 Step 8: Print Encrypted Data Byte Conversion
        printByteConversion(encryptedData);

        // 🔐 Step 9: Print Encrypted Text (Base64 Encoded)
        printEncryptedText(encryptedText);
    }
}
