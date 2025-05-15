"""
What is Command Injection?

Command Injection is a type of security vulnerability that allows an attacker to execute arbitrary system-level commands on a server or host through a vulnerable application.

Risks:
1. Data loss
2. System compromise
3. Privilege escalation
4. Denial of Service (DoS)

How to prevent:
1. Input Validation: Always validate and sanitize user inputs.
2. Use Parameterized Queries: For database interactions, use parameterized queries or prepared statements.


safe code:

import subprocess

filename = input("Enter a filename: ")

# Whitelisting (optional)
allowed = ["notes.txt", "data.txt"]
if filename in allowed:
    subprocess.run(["cat", filename])
else:
    print("Invalid filename.")

cons:
1. Goal of the Attacker:
2. Gain unauthorized access
3. Read, modify, or delete data
4. Run privileged commands
5. Sometimes, fully take control of the system

"""

# import os
# filename = input("Enter a file name:")
# os.system(f"rm {filename}")



# Windos user:
# import subprocess

# filename = input("Enter a file name: ")
# command = "cat " + filename
# print("[Debug] Running:", command)
# subprocess.call(command, shell=True)



# linux user:
# import subprocess

# filename = input("Enter a file name: ")
# command = "cat " + filename
# print("[Debug] Running:", command)
# subprocess.call(command, shell=True)


# import subprocess

# filename = input("Enter a file name: ").strip()

# # Pass arguments as a list, no shell interpretation
# subprocess.run(["cat", filename])




# for windows

import os

filename = input("Enter a file name: ")
command = f"bash -c 'rm {filename}'"
print("[Debug] Running:", command)
os.system(command)
