# Server-Client Communication with Different Threading Models

This repository demonstrates server-client communication in Java using three different threading models:

- **Single-threaded**
- **Multi-threaded (Thread-per-Client)**
- **Thread Pool**

Each model showcases a different approach to handling concurrent client requests, illustrating their trade-offs in terms of performance, resource usage, and complexity.

---

## 📚 Table of Contents

- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Compilation](#compilation)
  - [Running the Servers and Clients](#running-the-servers-and-clients)
- [Threading Models Explained](#threading-models-explained)
  - [Single-threaded](#single-threaded)
  - [Multi-threaded (Thread-per-Client)](#multi-threaded-thread-per-client)
  - [Thread Pool](#thread-pool)
- [Contributing](#contributing)
- [License](#license)

---

## 📘 Introduction

This project offers a comparative study of how servers handle multiple client connections using different threading paradigms. It is useful for students, developers, or anyone learning about **concurrent programming in Java**.

Each threading model is implemented in its own directory, allowing you to observe the differences in architecture, behavior, and performance.

---

## 🗂️ Project Structure
<pre>
.
├── single_threaded/
│ ├── Server.java
│ └── Client.java
├── multi_threaded/
│ ├── Server.java
│ └── Client.java
└── thread_pool/
├── Server.java
└── Client.java
</pre>


---

## 🚀 Getting Started

### ✅ Prerequisites

- Java Development Kit (JDK) 8 or higher  
  Install from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or use [OpenJDK](https://openjdk.org/).

---

### ⚙️ Compilation

Open your terminal and navigate to each directory to compile the files:

```bash
# Compile Single-threaded model
cd single_threaded
javac Server.java Client.java
cd ..

# Compile Multi-threaded model
cd multi_threaded
javac Server.java Client.java
cd ..

# Compile Thread Pool model
cd thread_pool
javac Server.java Client.java
cd ..
```

###▶️ Running the Servers and Clients

Use separate terminal windows to run the server and client(s).
Single-threaded

# Start Server
cd single_threaded
java Server

# In a new terminal - Start Client
cd single_threaded
java Client

    Only one client is handled at a time.

    Clients are processed sequentially.

    Multi-threaded (Thread-per-Client)

# Start Server
cd multi_threaded
java Server

# Start multiple Clients (in separate terminals)
cd multi_threaded
java Client

    Each client gets its own thread, allowing for concurrent processing.

    Thread Pool

# Start Server
cd thread_pool
java Server

# Start multiple Clients (in separate terminals)
cd thread_pool
java Client

    Uses a fixed pool of threads.

    Threads are reused, providing better performance under heavy load.
    🧵 Threading Models Explained
Single-threaded

    One thread handles all client connections, one at a time.

Pros:

    Easy to implement

    No thread safety issues

Cons:

    Not scalable

    Slower under heavy load

Multi-threaded (Thread-per-Client)

    A new thread is created for each client connection.

Pros:

    True concurrency

    Good for moderate number of clients

Cons:

    High memory/thread creation overhead

    Risk of thread exhaustion

Thread Pool

    A pre-created pool of threads handles all client requests.

Pros:

    Efficient resource usage

    Better scalability and performance

Cons:

    Slightly more complex to implement

    Requires careful pool size tuning

🤝 Contributing

Contributions are welcome! If you'd like to improve this project:

    Fork the repository

    Create a new branch (git checkout -b feature-name)

    Commit your changes (git commit -m "Add your message")

    Push to the branch (git push origin feature-name)

    Open a Pull Request
