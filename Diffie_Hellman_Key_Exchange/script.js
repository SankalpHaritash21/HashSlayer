// 📢 Main Diffie-Hellman Function
function diffieHellman() {
  // 🎯 Get user inputs
  const p = parseInt(document.getElementById("prime").value);
  const g = parseInt(document.getElementById("generator").value);
  const a = parseInt(document.getElementById("aliceKey").value);
  const b = parseInt(document.getElementById("bobKey").value);

  // ⚠️ Validate inputs
  if (!isPrime(p)) {
    alert("⚠️ Prime (p) must be a valid prime number!");
    return;
  }
  if (a <= 0 || a >= p || b <= 0 || b >= p) {
    alert("⚠️ Private keys must be between 1 and p-1!");
    return;
  }

  // 🔑 Compute public keys
  const A = calculatePublicKey(g, a, p);
  const B = calculatePublicKey(g, b, p);

  // 🔐 Compute shared secrets
  const aliceSecret = calculateSharedSecret(B, a, p);
  const bobSecret = calculateSharedSecret(A, b, p);

  // ✅ Check if secrets match
  const match =
    aliceSecret === bobSecret
      ? "✅ Secrets Match!"
      : "❌ Secrets DO NOT Match!";

  // 📄 Display Results
  document.getElementById("output").innerHTML = `
        <p>🟢 Prime (p): <strong>${p}</strong></p>
        <p>🟢 Generator (g): <strong>${g}</strong></p>
        
        <p>🔐 Alice's Private Key: <strong>${a}</strong></p>
        <p>🔑 Alice's Public Key: <strong>${A}</strong></p>
        
        <p>🔐 Bob's Private Key: <strong>${b}</strong></p>
        <p>🔑 Bob's Public Key: <strong>${B}</strong></p>
        
        <p>🔐 Alice's Shared Secret: <strong>${aliceSecret}</strong></p>
        <p>🔐 Bob's Shared Secret: <strong>${bobSecret}</strong></p>

        <p><strong>${match}</strong></p>
    `;
}

// 📡 Calculate public key: A = g^a mod p
function calculatePublicKey(g, privateKey, p) {
  return modExp(g, privateKey, p);
}

// 🔐 Calculate shared secret: S = B^a mod p
function calculateSharedSecret(publicKey, privateKey, p) {
  return modExp(publicKey, privateKey, p);
}

// 🔢 Modular exponentiation: (base^exp) % mod
function modExp(base, exp, mod) {
  let result = 1;
  base = base % mod;
  while (exp > 0) {
    if (exp % 2 === 1) {
      result = (result * base) % mod;
    }
    exp = Math.floor(exp / 2);
    base = (base * base) % mod;
  }
  return result;
}

// 🧠 Check if a number is prime
function isPrime(num) {
  if (num <= 1) return false;
  if (num <= 3) return true;

  if (num % 2 === 0 || num % 3 === 0) return false;

  let i = 5;
  while (i * i <= num) {
    if (num % i === 0 || num % (i + 2) === 0) return false;
    i += 6;
  }
  return true;
}
