public class BufferOverflowExample {
    public static void main(String[] args) {
        int[] buffer = new int[5];  

        try {
            for (int i = 0; i < 10; i++) {
                buffer[i] = i;  
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}


// import java.nio.ByteBuffer;

// public class BufferOverflowExample {
//     public static void main(String[] args) {
//         ByteBuffer buffer = ByteBuffer.allocate(10); // Allocate only 10 bytes

//         try {
//             for (int i = 0; i < 15; i++) {  // Write more than capacity
//                 buffer.put((byte)i);
//                 System.out.println("Wrote: " + i);
//             }
//         } catch (Exception e) {
//             System.out.println("⚠️ Exception occurred: " + e);
//         }
//     }
// }
