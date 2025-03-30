public class BufferOverflowExample {
    public static void main(String[] args) {
        try {
            // Allocate a buffer of size 10
            byte[] buffer = new byte[10];

            // Attempt to fill buffer beyond its capacity
            for (int i = 0; i <= 10; i++) {
                buffer[i] = (byte) i;
                System.out.println("Writing to buffer[" + i + "]: " + buffer[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Buffer overflow detected: " + e.getMessage());
        }
    }
}