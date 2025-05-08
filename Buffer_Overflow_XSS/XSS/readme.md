# What is XSS?

Cross-Site Scripting (XSS) is a security vulnerability that allows an attacker to inject malicious scripts into websites, which are then executed by the browser of unsuspecting users. This happens when untrusted data is included in web pages without proper validation or sanitization.

# How Does XSS Work?

1. User input is not properly validated or sanitized.
2. Malicious scripts are embedded in the page.
3. When a legitimate user loads the page, the script runs as if it came from the website.

This breaks the browser's same-origin policy and trust boundary.

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

# Real-World Consequences

1. Session Hijacking
2. Cookie Theft
3. Defacement
4. Phishing attacks
5. Browser exploitation

Prevention Techniques
Input Validation – Accept only expected input.

Output Encoding – Encode data before rendering in HTML, JS, URLs.

Content Security Policy (CSP) – Restrict resources the browser can load.

Use Security Libraries – Like DOMPurify for client-side protection.

HTTPOnly Cookies – Prevent access to cookies via JavaScript.
