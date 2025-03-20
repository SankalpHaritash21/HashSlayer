import hashlib

def load_dictionary(file_path):
    with open(file_path, "r") as file:
        return [line.strip() for line in file.readlines()]

def dictionary_attack(dictionary_file, target_hash):
    dictionary = load_dictionary(dictionary_file)
    for word in dictionary:
        if hashlib.md5(word.encode()).hexdigest() == target_hash:
            print(f"[+] Password found: {word}")
            return
    print("[-] Password not found")

# Example Usage:
dictionary_attack("dictionary.txt", "5f4dcc3b5aa765d61d8327deb882cf99")