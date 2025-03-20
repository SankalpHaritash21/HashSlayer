import itertools
import hashlib

def brute_force_attack(charset, max_length, target_hash):
    for length in range(1, max_length + 1):
        for guess in itertools.product(charset, repeat=length):
            guess_word = ''.join(guess)
            if hashlib.md5(guess_word.encode()).hexdigest() == target_hash:
                print(f"[+] Password found: {guess_word}")
                return
    print("[-] Password not found")

# Example Usage:
brute_force_attack("abc", 3, "900150983cd24fb0d6963f7d28e17f72")