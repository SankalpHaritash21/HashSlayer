# Aim

##### To understand the fundamental concepts of encryption and hashing, focusing on symmetric and asymmetric encryption, and analyzing AES, MD5, and RSA with real-world use cases and Java code examples.

# 🔐 Symmetric vs Asymmetric Encryption

## 📚 Introduction

Encryption is a method of securing data by transforming it into an unreadable format using algorithms and keys. There are two main types of encryption:

- **Symmetric Encryption**: Same key is used for encryption and decryption.
- **Asymmetric Encryption**: Uses a pair of keys (public and private) for encryption and decryption.

---

## ⚡ 1. Symmetric Encryption

### 📖 Definition

Symmetric encryption uses a **single secret key** to both encrypt and decrypt information. The same key must be shared between the sender and the receiver to maintain confidentiality.

### 🔥 Examples

- **AES (Advanced Encryption Standard)**
- **DES (Data Encryption Standard)**
- **3DES (Triple DES)**

### 📌 Use Cases

- Securing stored data
- Encrypting database fields (e.g., passwords, credit card details)
- File encryption for confidentiality

### ✅ Pros

- Faster and efficient for large datasets.
- Easier to implement and manage.

### ❌ Cons

- Key distribution is a challenge.
- If the key is compromised, the entire system is vulnerable.

---

## 🔐 2. Asymmetric Encryption

### 📖 Definition

Asymmetric encryption uses a **pair of keys**:

- **Public Key**: Used for encryption.
- **Private Key**: Used for decryption.

### 🔥 Examples

- **RSA (Rivest–Shamir–Adleman)**
- **ECC (Elliptic Curve Cryptography)**

### 📌 Use Cases

- Secure communication (e.g., HTTPS, SSL/TLS)
- Digital signatures for authentication and integrity
- Email encryption (PGP, S/MIME)

### ✅ Pros

- Enhanced security due to key pairs.
- No need to share private keys for communication.

### ❌ Cons

- Slower compared to symmetric encryption.
- Computationally expensive for large data sets.

---

## 📊 Key Differences

| Feature          | Symmetric Encryption              | Asymmetric Encryption                 |
| ---------------- | --------------------------------- | ------------------------------------- |
| Key Type         | Single key                        | Key pair (public/private)             |
| Speed            | Faster                            | Slower                                |
| Security         | Less secure if key is compromised | More secure                           |
| Key Distribution | Difficult to manage               | Easier as only public key is shared   |
| Best Use Cases   | Large data encryption             | Secure communication & authentication |

---

## 💡 When to Use Which?

- **Symmetric Encryption**: Ideal for encrypting large amounts of data where speed is a priority.
- **Asymmetric Encryption**: Best for securing communications, authenticating users, and establishing secure connections.

---

## For Code:

- **AES**: [Advanced Encryption Standard](./Advanced_Encryption_Standard/Advanced_Encryption_Standard.java)

- **RSA**: [Rivest Shamir Adleman](./Rivest_Shamir_Adleman/Rivest_Shamir_Adleman.java)

- **Md5**: [Message Digest Algorithm5](./Message_Digest_Algorithm_5/Message_Digest_Algorithm_5.java)
- **How MD5 work**: [MD5 Details](../Dictionary_Attack/MD5.md)
