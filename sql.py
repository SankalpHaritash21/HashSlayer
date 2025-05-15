import sqlite3
import tkinter as tk
from tkinter import messagebox

# input -> ' OR 1=1 --
conn = sqlite3.connect("test.db")
cursor = conn.cursor()

cursor.execute("""
CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT,
    password TEXT
)
""")
cursor.execute("INSERT OR IGNORE INTO users (id, username, password) VALUES (1, 'admin', 'admin123')")
cursor.execute("INSERT OR IGNORE INTO users (id, username, password) VALUES (2, 'user', 'pass')")
conn.commit()

# Vulnerable Login Function (for demo)
def vulnerable_login():
    uname = username_entry.get()
    pwd = password_entry.get()

    query = f"SELECT * FROM users WHERE username = '{uname}' AND password = '{pwd}'"
    print(f"Running query: {query}")
    try:
        cursor.execute(query)
        result = cursor.fetchall()
        if result:
            messagebox.showinfo("Login Result", "✅ Login Successful (Vulnerable)")
        else:
            messagebox.showerror("Login Result", "❌ Login Failed")
    except Exception as e:
        messagebox.showerror("Error", str(e))

# GUI Setup
app = tk.Tk()
app.title("🔓 SQL Injection Demo (Vulnerable)")
app.geometry("400x250")
app.configure(bg="#f0f0f0")
app.resizable(False, False)

# Center the window
app.update_idletasks()
width = app.winfo_width()
height = app.winfo_height()
x = (app.winfo_screenwidth() // 2) - (width // 2)
y = (app.winfo_screenheight() // 2) - (height // 2)
app.geometry(f"+{x}+{y}")

# Title Label
title_label = tk.Label(app, text="🔓 SQL Injection Demo", font=("Arial", 16, "bold"), bg="#f0f0f0", fg="#333")
title_label.pack(pady=15)

# Username
username_frame = tk.Frame(app, bg="#f0f0f0")
username_frame.pack(pady=5)
tk.Label(username_frame, text="Username:", font=("Arial", 12), bg="#f0f0f0").pack(side="left", padx=5)
username_entry = tk.Entry(username_frame, font=("Arial", 12), width=25)
username_entry.pack(side="left", padx=5)

# Password
password_frame = tk.Frame(app, bg="#f0f0f0")
password_frame.pack(pady=5)
tk.Label(password_frame, text="Password:", font=("Arial", 12), bg="#f0f0f0").pack(side="left", padx=5)
password_entry = tk.Entry(password_frame, font=("Arial", 12), show="*", width=25)
password_entry.pack(side="left", padx=5)

# Login Button
login_button = tk.Button(app, text="Login", font=("Arial", 12, "bold"), bg="#007acc", fg="white", padx=20, pady=5, command=vulnerable_login)
login_button.pack(pady=20)

app.mainloop()
