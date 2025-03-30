# What is XSS?

Cross-Site Scripting (XSS) is a security vulnerability that allows an attacker to inject malicious scripts into websites, which are then executed by the browser of unsuspecting users. This happens when untrusted data is included in web pages without proper validation or sanitization.

## ⚠️ Types of XSS Attacks

1. Stored XSS (Persistent XSS):

   - Malicious script is stored in the database and served to users.
   - Example: Comment boxes, user profiles, forums, etc.

2. Reflected XSS (Non-Persistent XSS):

   - Script is reflected off the server and returned to the user.
   - Example: Search queries, URL parameters.

3. DOM-Based XSS:

   - Occurs when JavaScript modifies the DOM without properly sanitizing user input.
   - Example: innerHTML, document.write(), eval().
