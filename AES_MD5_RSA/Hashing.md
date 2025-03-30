# 📚 What is Hashing?

**Hashing** is a one-way process that converts input data (such as a string or file) into a **fixed-length hash value**. This hash uniquely represents the original data but cannot be reversed to obtain the original content.

---

## ⚡ Characteristics of Hashing

### 🧠 1. Deterministic

- The same input **always** produces the same hash.
- **Example:**
  ```bash
  Input: "Hello"
  MD5 Hash: 8b1a9953c4611296a827abf8c47804d7
  ```

### 🔒 2. Irreversible

- It is impossible to derive the original data from the hash.

- Ideal for securing sensitive information.

### 🚫 3. Collision-Resistant

- Two different inputs rarely generate the same hash value.

- A good hash function minimizes the chances of hash collisions.

---

## Use Cases of Hashing

#### 1. Password Storage

- Hashing is used to store passwords securely.

- Salting adds random data before hashing to prevent attacks.

```bash
Password + Salt → Hash
```

### 2. Data Integrity Verification

- Hashing verifies that data remains unaltered during transmission or storage.

- Commonly used in file integrity checks.

```bash
Original File → Hash
Received File → Re-hash and Compare
```

### 3. Digital Signatures

- Ensures authenticity and integrity of digital documents.

- The hash is encrypted with a private key to generate a digital signature.

---

### 🚀 Popular Hashing Algorithms

| Algorithm | Hash Length | Security Level              |
| --------- | ----------- | --------------------------- |
| MD5       | 128-bit     | Weak (prone to collisions)  |
| SHA-1     | 160-bit     | Moderate (no longer secure) |
| SHA-256   | 256-bit     | Strong (high security)      |

---

## Additional Resources

- [MD5 vs SHA-256](https://en.wikipedia.org/wiki/SHA-2)

- [Salting and Hashing Explained](<https://en.wikipedia.org/wiki/Salt_(cryptography)>)
