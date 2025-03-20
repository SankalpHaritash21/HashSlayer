# Dictionary Attack

A dictionary attack is a type of cyberattack aimed at cracking passwords or encryption keys by systematically trying every word in a precompiled list (a "dictionary") of likely candidates. Unlike brute-force attacks that try all possible combinations, dictionary attacks use curated lists of words, phrases, or commonly used passwords, making them faster and more efficient.

## How It Works

1. Target Identification:

- The attacker obtains a password hash (e.g., from a breached database) or gains access to a login system.
- Example: A stolen database of hashed passwords like 5f4dcc3b5aa765d61d8327deb882cf99 (MD5 hash of "password").

2. Dictionary Creation:

- A list of potential passwords is compiled. This list may include:
- Common passwords (e.g., "123456", "password", "qwerty").
- Words from a language dictionary (e.g., "apple", "sunshine").
- Leaked passwords from past breaches (e.g., the "RockYou" breach list).
- Variations with substitutions (e.g., "p@ssw0rd", "adm1n").

3. Automated Guessing:

- The attacker uses software to hash each word in the dictionary and compare it to the target hash.

### If a match is found, the password is cracked.

```
Example Workflow
Hashing Process:

The word "secret" is hashed using MD5: 5ebe2294ecd0e0f08eab7690d2a6ee69.

Compare with the target hash.
If they match, the password is "secret".

```

Tools Used:

Tools like John the Ripper, Hashcat, or custom Python/Java scripts automate this process.

### Why Dictionary Attacks Are Effective

1. Human Behavior:

- People often use simple, memorable passwords (e.g., "iloveyou", "admin").
- 80% of passwords can be cracked using the top 1,000 most common passwords.

2. Speed:

- Modern GPUs can hash millions of passwords per second.
- Example: Hashcat can test 350 billion MD5 hashes per second on an RTX 4090 GPU.

3. Hybrid Attacks:

- Combine dictionary words with numbers/symbols (e.g., "password123", "summer2023").

### Types of Passwords Vulnerable

1. Default Passwords:

- Routers, IoT devices (e.g., "admin:admin").

2. Personalized Passwords:

- Pet names, birthdays, or favorite sports teams.

3. Leaked Passwords:

- Reused passwords from past breaches (e.g., "LinkedIn_2012" breach).

4. Mitigation Strategies

- Strong Password Policies:

## What is Salting:

Add a unique random value ("salt") to each password before hashing.

Example: hash("password" + "x7gH!") instead of hash("password").

1. Slow Hashing Algorithms:

Use bcrypt, Argon2, or PBKDF2 instead of fast algorithms like MD5 or SHA-1.

2. Multi-Factor Authentication (MFA):

Even if a password is cracked, MFA adds another layer (e.g., SMS code, biometrics).

3. Account Lockouts:

Lock accounts after 3-5 failed login attempts to block automated attacks.

A dictionary attack exploits human predictability in password creation. While efficient against weak passwords, its success diminishes with strong password practices, salting, and modern security protocols. Always use unique, complex passwords and enable MFA to protect against such attacks. 🔒
