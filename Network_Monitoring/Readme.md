# 📡 Network Monitoring and Analysis Tools Setup

## 🎯 Objective:

Set up and use popular network monitoring tools like Wireshark, Tcpdump, and Nmap to analyze and observe data transfer in client-server communication using UDP and TCP.

---

## 🛠️ 1. Tools Overview

- Wireshark: GUI-based network protocol analyzer that captures and analyzes network packets.

- Tcpdump: Command-line packet analyzer that captures and filters packets for detailed analysis.

- Nmap (Network Mapper): Network scanner used for discovering open ports, identifying services, and performing OS detection.

## ⚡ 2. Installation Instructions

### 🖥️ 2.1 Installation on Windows

```
 1. Wireshark:
    - Download from Wireshark Official Website.
    - Run the installer and follow the on-screen instructions.
    - Select Npcap during installation to capture packets.
    - Launch Wireshark after installation.

 2. Nmap:
    - Download from Nmap Official Website.
    - Follow the installation instructions.
    - Add nmap to the system PATH during installation.

 3. Tcpdump (WinDump):
    - Download from WinDump.
    - Install WinPcap during the process.
```

## 📡 3. Capturing and Analyzing Network Traffic

### 🌐 3.1 Using Wireshark

1. Launch Wireshark and select a network interface.
2. Click Start Capture.
3. Apply filters to capture desired traffic:

   - TCP Traffic: tcp
   - UDP Traffic: udp

4. Stop and save capture:

```rest
File -> Save As -> capture.pcap
```

### ⚡ 3.2 Using Tcpdump

```
1. Start capturing packets
sudo tcpdump -i eth0 -n

2. Capture TCP Traffic
sudo tcpdump -i eth0 tcp

3. Capture UDP Traffic
sudo tcpdump -i eth0 udp

4. Save captured packets to a file
sudo tcpdump -i eth0 -w capture.pcap
```

## 📡 3.3 Using Nmap for Scanning

### Scan for open ports on a target IP

nmap <target-ip>

### Scan TCP and UDP Ports

nmap -sT <target-ip>
nmap -sU <target-ip>

### Detect running services and OS

nmap -sV -O <target-ip>

### Run vulnerability scan

nmap --script vuln <target-ip>

## 🎯 4. Simulate Client-Server Communication Using TCP/UDP

### 🔥 4.1 TCP Client-Server Setup

### 📡 TCP Server (server.py)

```
import socket
```

### Create TCP socket

```
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
```

### Bind to localhost and port 12345

```
server_socket.bind(('0.0.0.0', 12345))
server_socket.listen(1)
print("TCP Server listening on port 12345...")
```

### Accept connection

```
conn, addr = server_socket.accept()
print(f"Connection established with {addr}")
```

### Receive data

```
data = conn.recv(1024).decode()
print(f"Received: {data}")
```

### Send response

```
conn.send(b"Hello, TCP Client!")
conn.close()
```

## 📡 TCP Client (client.py)

```
import socket
```

### Create TCP socket

```
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
```

### Connect to server

```
client_socket.connect(('127.0.0.1', 12345))
client_socket.send(b"Hello, TCP Server!")
```

# Receive response

```
response = client_socket.recv(1024).decode()
print(f"Response from server: {response}")
client_socket.close()
```

### 🚀 4.2 UDP Client-Server Setup

#### 📡 UDP Server (udp_server.py)

```
import socket
```

#### Create UDP socket

```
server_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
```

#### Bind to localhost and port 54321

```
server_socket.bind(('0.0.0.0', 54321))
print("UDP Server listening on port 54321...")
```

#### Receive data

```
data, addr = server_socket.recvfrom(1024)
print(f"Received '{data.decode()}' from {addr}")
```

#### Send response

```
server_socket.sendto(b"Hello, UDP Client!", addr)
📡 UDP Client (udp_client.py)
```

```
import socket

# Create UDP socket
client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Send data to server
client_socket.sendto(b"Hello, UDP Server!", ('127.0.0.1', 54321))

# Receive response
data, addr = client_socket.recvfrom(1024)
print(f"Response from server: {data.decode()}")
client_socket.close()

```

## 📊 5. Observing and Analyzing Data Transfers

#### ✅ 5.1 Capture Data Using Wireshark

1. Run the TCP or UDP client-server scripts.
2. Open Wireshark and select the appropriate interface.
3. Apply filters to focus on the communication: - TCP Traffic: tcp.port == 12345 - UDP Traffic: udp.port == 54321

4. Analyze packets and observe data exchange.

#### ✅ 5.2 Capture Packets Using Tcpdump

```
# Capture TCP Traffic on port 12345
sudo tcpdump -i eth0 port 12345 -w tcp_capture.pcap

# Capture UDP Traffic on port 54321
sudo tcpdump -i eth0 port 54321 -w udp_capture.pcap

```

# Summary

1. Wireshark: GUI-based packet capture and protocol analysis.
2. Tcpdump: CLI-based packet capture for detailed analysis.
3. Nmap: Network scanning, open ports identification, and vulnerability detection.
4. Client-Server Simulation: Simulate TCP/UDP communication to analyze data exchange.
