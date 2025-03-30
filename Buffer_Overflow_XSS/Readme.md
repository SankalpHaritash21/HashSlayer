# 📚 1. Buffer Overflow

##### Buffer overflow occurs when data is written beyond the allocated memory boundary, causing it to overwrite adjacent memory. However, Java has built-in protection from buffer overflows due to its automatic memory management and bounds-checking.

## Java and Buffer Overflow:

1.  Java uses the Java Virtual Machine (JVM) to manage memory and ensure bounds checking.
2.  Array and buffer bounds are strictly enforced.
3.  Attempting to exceed buffer boundaries results in:

```bash
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
```

### Buffer Overflow Simulation

```java
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
```

### Countermeasures for Buffer Overflow in Java

1.  Automatic Bounds Checking
    Java automatically throws an ArrayIndexOutOfBoundsException if buffer limits are exceeded.

2.  Use try-catch for Handling Exceptions

```java
try {
   buffer[10] = 50; // Attempting to overwrite boundary
} catch (ArrayIndexOutOfBoundsException e) {
   System.out.println("Buffer overflow prevented.");
}
```

3.  Use ByteBuffer with Safe Boundaries

```java

import java.nio.ByteBuffer;

public class SafeBufferExample {
   public static void main(String[] args) {
       ByteBuffer buffer = ByteBuffer.allocate(10);

       try {
           for (int i = 0; i <= 10; i++) {
               buffer.put((byte) i);
           }
       } catch (Exception e) {
           System.err.println("Buffer overflow prevented: " + e.getMessage());
       }
   }
}

```
