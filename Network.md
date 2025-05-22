# Network

    A system of interconnected devices (like computers, printers, or servers) that can communicate and share resources with each other

1. Virtual Operations:
   Networks enable devices and users to operate remotely or virtually, supporting cloud computing, remote work, and virtualization.

2. Scalability:
   Networks can integrate and expand on a large scale, allowing thousands or even millions of devices to connect and communicate efficiently.

3. Quick Responsiveness:
   Networks are designed to respond quickly to changes, such as rerouting data during failures or load balancing under heavy traffic.

4. Data Security:
   Networks help in enforcing data security through firewalls, encryption, user authentication, and access controls—though security depends on how well the network is managed.

## Types of Networks

1. LAN (Local Area Network)

Connects computers within a small area like a home, school, or office.
Example: Office Wi-Fi connecting employees' computers.

2. MAN (Metropolitan Area Network)

Covers a larger area than LAN, like a city or campus.
Example: Network across multiple buildings of a university.

3. WAN (Wide Area Network)

Covers a very large geographical area, such as a country or the world.
Example: The Internet is the largest WAN.

4. PAN (Personal Area Network)

Very small network used for personal devices like smartphones, tablets, and smartwatches.
Example: Bluetooth connection between a phone and wireless earbuds.

4. VPN (Virtual Private Network)

A secure network that works over the internet to protect data and privacy.
Example: Used to access work networks securely from home.

## Components of a Network

1. Router

Connects different networks (like your home network to the internet).
Directs data packets between devices and networks.

2. Switch

Connects multiple devices within a LAN and enables communication between them.
Smarter than a hub. It sends data only to the intended device.

3. Modem

Converts digital signals to analog (and vice versa) for communication over telephone lines or cable.
Needed for internet access.

4. Access Point (AP)

Provides wireless connectivity to devices in a network.
Common in Wi-Fi setups.

5. Network Interface Card (NIC)

A hardware component inside computers and devices that allows them to connect to a network.
Can be wired or wireless.

6. Firewall

A security system that monitors and controls incoming/outgoing network traffic.
Protects against unauthorized access.

7. Server

A powerful computer that provides services like file storage, web hosting, or email to other computers (clients) on the network.

## Types of Network Topologies

1. Bus Topology

All devices are connected to a single central cable (the bus).

Advantage: Easy to set up and requires less cable.
Disadvantage: A failure in the main cable can bring down the entire network.

2. Star Topology

All devices are connected to a central device (like a switch or hub).

Advantage: Easy to manage and troubleshoot.
Disadvantage: If the central device fails, the whole network is affected.

3. Ring Topology

Devices are connected in a circular loop. Data travels in one direction (or both, in dual-ring).

Advantage: Predictable data flow.
Disadvantage: A break in the ring can disrupt the network.

4. Mesh Topology

Every device is connected to every other device.

Advantage: High reliability and fault tolerance.
Disadvantage: Expensive and complex to set up.

5. Tree Topology

A hybrid of star and bus topologies with a hierarchical flow.

Advantage: Scalable and easy to manage large networks.
Disadvantage: If the backbone fails, the entire network may collapse.

6. Hybrid Topology

Combines two or more topologies to take advantage of their strengths.

Advantage: Flexible and scalable.
Disadvantage: Complex design and maintenance.

## Network Protocols

Protocols are rules and standards that define how data is transmitted and received over a network. They ensure that devices can communicate effectively.

## Common Network Protocols

1. TCP/IP (Transmission Control Protocol/Internet Protocol)

The foundation of the internet.

Splits data into packets (TCP) and routes them to the correct address (IP).

Ensures reliable, ordered, and error-checked delivery.

2. HTTP (HyperText Transfer Protocol)

Used for accessing web pages.

When you enter a website URL, your browser uses HTTP to request the page.

Secure version: HTTPS, which encrypts the data.

3. FTP (File Transfer Protocol)

Used to transfer files between computers over a network.

Example: Uploading files to a web server.

4. SMTP (Simple Mail Transfer Protocol)

Used for sending emails from client to server.

Works with POP or IMAP to retrieve emails.

5. POP3 (Post Office Protocol version 3) and IMAP (Internet Message Access Protocol)

Used for retrieving emails from the server.

POP3 downloads and deletes messages from the server.

IMAP keeps emails on the server for access from multiple devices.

6. DNS (Domain Name System)

Converts domain names (like google.com) into IP addresses.

Acts like the internet’s phonebook.

7. DHCP (Dynamic Host Configuration Protocol)

Automatically assigns IP addresses to devices in a network.

Reduces manual configuration.

## What is an API?

- API (Application Programming Interface)
- API is a set of rules that allows different software applications to communicate and interact with each other.

### APIs are often used to:

    - Send or retrieve data over the internet or internal networks.
    - Interact with web servers using protocols like HTTP or HTTPS.
    - Access services like weather data, payment gateways, maps, etc.

Exmple: REST API, GraphQL, etc.

1. REST API – Best for standard CRUD applications
   Use when:
   You’re building typical web or mobile apps where real-time data isn’t required.

Pros:

Widely supported
Simple to use and understand
Caches well
Works great with standard HTTP tools

Cons:

May require multiple calls for complex data
Over-fetching or under-fetching data is common

2. GraphQL – Best for complex data or mobile apps
   Use when:
   You want fine control over what data is sent and received, especially in apps with lots of nested data.

Pros:

Fetch exactly what you need in one request
Great for frontend performance
Reduces number of network calls

Cons:

Steeper learning curve
Caching is more complex
Can be overkill for simple APIs

3. WebSockets – Best for real-time communication
   Use when:
   You’re building chat apps, live dashboards, collaboration tools, games, or stock tickers.

Pros:

Real-time two-way communication
Efficient (no need to open new HTTP request each time)
Low latency

Cons:

More complex to implement and scale
Not cacheable like REST
Needs good connection management

#### What is a Checksum?

A checksum is a small piece of data (a short binary or hexadecimal number) that is generated from a larger block of data to detect errors during data transmission or storage.

To ensure data integrity. When data is sent over a network or saved to disk, it might get corrupted. A checksum helps detect if any bits were changed.

## How It Works:

1. Sender Side:

   - he sender calculates a checksum based on the data.
   - Sends the data + checksum to the receiver.

2. Receiver Side:

   - The receiver calculates a new checksum from the received data.
   - Compares it with the sent checksum.
   - If they match -> Data is intact.
   - If not -> Data is corrupted.

   ```python
   def calculate_checksum(data):
   return 255 - (sum(data) % 256)

   # Sender Side
   data_to_send = [10, 20, 30, 40]  # Example bytes
   checksum = calculate_checksum(data_to_send)

   packet = data_to_send + [checksum]  # Append checksum to data
   print("Sent packet:", packet)

   # Receiver Side
   def verify_checksum(received_data):
       data = received_data[:-1]        # All except last item
       received_checksum = received_data[-1]
       calculated_checksum = calculate_checksum(data)
       return calculated_checksum == received_checksum

   # Simulate Receiving
   received_packet = packet
   if verify_checksum(received_packet):
       print("✅ Data is intact.")
   else:
       print("❌ Data is corrupted.")

   ```

### The TCP/IP Protocol Suite

The TCP/IP model, also known as the Internet Protocol Suite, is the cornerstone of how data is transmitted across the Internet and many other modern networks. This four-layer framework simplifies the process of network communication and is the foundation upon which most internet services function.

#### Overview of TCP/IP Model

TCP/IP stands for Transmission Control Protocol/Internet Protocol.
It provides end-to-end connectivity, specifying how data should be packetized, addressed, transmitted, routed, and received.

Unlike the OSI model which has 7 layers, the TCP/IP model is more practical and has 4 layers:

1. Application Layer
2. Transport Layer
3. Internet Layer
4. Network Access Layer

Each layer interacts with the one above and below it, ensuring a seamless flow of data from source to destination.

1. Application Layer

The Application layer is the topmost layer and interacts directly with the end-user or application. It provides protocols that applications use to communicate over the network.

Common Protocols:

1. HTTP/HTTPS – Used for web browsing.
2. FTP/SFTP – File transfer.
3. SMTP/IMAP/POP3 – Email communication.
4. DNS – Resolving domain names to IP addresses.
5. Telnet/SSH – Remote login.

6. Transport Layer

This layer is responsible for the delivery of data between devices. It ensures the reliability, flow control, error detection, and correction of transmitted data.

- Key Protocols:
  1. TCP (Transmission Control Protocol) – Reliable, connection-oriented.
  2. UDP (User Datagram Protocol) – Fast, connectionless.

3. Internet Layer

Handles logical addressing, routing, and packet forwarding. Its job is to get data packets from source to destination across multiple networks.

- Key Protocols:
  1. IP (Internet Protocol) – Handles addressing and routing.
  2. ICMP (Internet Control Message Protocol) – Sends error messages (e.g., "destination unreachable").
  3. ARP (Address Resolution Protocol) – Resolves IP addresses to MAC addresses.
  4. IGMP (Internet Group Management Protocol) – Used in multicast groups.

4. Network Access Layer (Also called Link Layer or Network Interface Layer)

This layer defines how data is physically sent over the network – whether via cables (Ethernet) or wirelessly (Wi-Fi). It includes hardware addressing (MAC) and deals with frames, bit-level transmission, and physical media.

Key Technologies:

1. Ethernet – Wired LAN communication.
2. Wi-Fi (IEEE 802.11) – Wireless LAN.
3. PPP (Point-to-Point Protocol) – Used over serial connections.
4. DSL, Fiber, Coaxial, Bluetooth – Different media standards.

#### OSI Model: The 7 Layers

```
Layer | Name           | Function Summary
------------------------------------------------
7     | Application    | End-user interaction (e.g., browsers, email clients)
6     | Presentation   | Data format translation, encryption/decryption (e.g., SSL)
5     | Session        | Manages sessions (start/end of communication)
4     | Transport      | Ensures reliable delivery (TCP/UDP)
3     | Network        | Logical addressing and routing (IP)
2     | Data Link      | Physical addressing (MAC), error detection
1     | Physical       | Actual transmission via media (cables, radio waves)


```

🔍 Layer-by-Layer Explanation with Security Context

```
Layer 7 – Application Layer
Function: Interface for end-user services (web browsers, email clients, FTP, etc.).

Protocols: HTTP/HTTPS, SMTP, FTP, DNS, SNMP.

Examples: Visiting websites, sending emails, file transfers.

Security Relevance:

Application-layer attacks: Target the app logic.

Examples:

XSS (Cross-site Scripting)
SQL Injection

```

```
Layer 6 – Presentation Layer
Function: Ensures data is in a usable format. Handles data translation, encryption, and compression.

Examples:

Encoding formats (JPEG, MPEG, ASCII, EBCDIC).

Encryption protocols (SSL/TLS).

Security Relevance:

Encryption/Decryption happens here.

TLS/SSL protect confidentiality and integrity.

Attacks:

SSL stripping

Protocol downgrade attacks
```

```
Layer 5 – Session Layer
Function: Establishes, manages, and terminates sessions between applications.

Examples:

Session tokens in web apps.

Remote Procedure Call (RPC).

Security Relevance:

Session hijacking, session fixation

Improper session management can expose secure data or authentication states.
```

```
Layer 4 – Transport Layer
Function: Provides reliable (TCP) or fast (UDP) end-to-end communication.

Protocols: TCP, UDP

Port numbers identify services (e.g., HTTP = 80, HTTPS = 443).

Security Relevance:

Port Scanning: Reconnaissance to find open services.

SYN Flood: Denial of Service (DoS) using half-open connections.

TCP Reset Attacks, UDP Flooding
```

```
Layer 3 – Network Layer
Function: Routing of packets across networks using logical addressing (IP).

Protocols: IP (IPv4/IPv6), ICMP, IPsec.

Devices: Routers, Layer 3 switches.

Security Relevance:

IP Spoofing: Faking source IP addresses.

Route Injection: Malicious routes added to disrupt traffic.

ICMP misuse: (e.g., Ping of Death, Smurf attacks)

Man-in-the-Middle (MitM) via ARP/IP manipulation
```

```
Layer 2 – Data Link Layer
Function: Responsible for node-to-node delivery. Uses MAC addresses.

Sub-layers:

LLC (Logical Link Control)

MAC (Media Access Control)

Devices: Switches, NICs (Network Interface Cards)

Security Relevance:

MAC Spoofing: Impersonating another device's MAC.

ARP Spoofing/Poisoning: Redirects traffic via fake MAC addresses.

VLAN hopping: Gaining unauthorized access across VLANs.
```

```
Layer 1 – Physical Layer
Function: Physical transmission of data using cables, radio waves, signals.

Examples: Ethernet cables, fiber optics, Wi-Fi signals.

Devices: Hubs, repeaters, physical network interfaces.

Security Relevance:

Physical access attacks: Unplugging cables, tapping lines.

Signal jamming in wireless networks.

TEMPEST attacks: Eavesdropping on electromagnetic emissions.
```

```
MAC Address = Like your laptop's serial number → unique to the device.

IP Address = Like your home address → can change if you move, and is needed for others to send you messages.

```

# Understanding IPv4 and IPv6

## What is an IP Address?

An **IP address** (Internet Protocol address) is a unique identifier assigned to every device connected to a network that uses the Internet Protocol for communication. It allows devices to locate and communicate with each other over a network.

---

## IPv4 (Internet Protocol Version 4)

- **Format:** IPv4 addresses are 32-bit numbers, usually written in decimal as four numbers separated by dots (called dotted-decimal notation).  
  Example: `192.168.1.1`

- **Address Space:** IPv4 can support approximately **4.3 billion** unique addresses (`2^32`).

- **Structure:** Divided into four octets (8 bits each).  
  Each octet ranges from 0 to 255.

- **Limitations:**
  - Due to the rapid growth of devices connected to the internet, IPv4 address space is nearly exhausted.
  - Requires techniques like NAT (Network Address Translation) to extend usability.

---

## IPv6 (Internet Protocol Version 6)

- **Format:** IPv6 addresses are 128-bit numbers, written in hexadecimal and separated by colons.  
  Example: `2001:0db8:85a3:0000:0000:8a2e:0370:7334`

- **Address Space:** IPv6 supports an extremely large number of unique addresses: approximately `3.4 × 10^38` (`2^128`).

- **Structure:** Divided into eight groups of four hexadecimal digits.

- **Advantages over IPv4:**
  - Vastly larger address space, solving IPv4 exhaustion.
  - Simplified header for efficient processing.
  - Built-in features like improved security (IPSec).
  - No need for NAT, allowing true end-to-end connectivity.

---

## Summary Table

| Feature            | IPv4                                     | IPv6                                             |
| ------------------ | ---------------------------------------- | ------------------------------------------------ |
| Address length     | 32 bits                                  | 128 bits                                         |
| Address format     | Decimal, dotted-quad (e.g., 192.168.1.1) | Hexadecimal, colon-separated (e.g., 2001:db8::1) |
| Total addresses    | ~4.3 billion (`2^32`)                    | ~340 undecillion (`2^128`)                       |
| Address exhaustion | Near exhaustion                          | Virtually unlimited                              |
| Header complexity  | More complex                             | Simplified                                       |
| Security           | Optional (IPSec)                         | Mandatory support (IPSec)                        |
| NAT required?      | Often                                    | Not required                                     |

---

## Why IPv6?

With billions of devices connected worldwide—smartphones, IoT gadgets, servers—the IPv4 address pool is insufficient. IPv6 provides a scalable solution ensuring future internet growth.
