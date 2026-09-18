# CSC 474 — Network Security

Coursework from **NC State University, Fall 2022**. Java and Python.
Published later, so commit dates are the publication date, not when the work was done.

## hw1 — classical cryptanalysis

`Julius.java` brute-forces single-byte XOR over a base64 payload — all 256 keys, print every
candidate, read the one that's English.

`Alan.java` (174 lines) is the real one: a **repeating-key XOR breaker**. It computes the
**index of coincidence** across a 64-character alphabet to recover the key length (5), then
frequency-ranks the bytes in each position and brute-forces against the most common English
characters to recover the key itself. The written analyses apply the same IoC method to a
classical Vigenère — every key length tested, length 6 selected at IoC 0.0672.

## hw3 — password cracking

Write-ups rather than code: hashcat against MD5 with a 6-character mask on GPU, SHA-256 with a
custom `?l?d?u` charset under `--increment`, and bcrypt against rockyou — plus a hand-written
Python brute-forcer for a custom 100-round MD5/SHA-256/SHA-512 construction. The written portion
covers nonce replay protection, a MITM against a signing protocol, and Kerberos authentication.

## hw5 — port scanning, and catching it

The interesting pair on this repo: an attack and the defence for it.

| File | Role |
|---|---|
| `PortScan.py` | Sequential TCP connect scan across all 65,535 ports, naming services via `getservbyport`, reporting ports/sec |
| `PortScanToo.py` | The same scan in randomized port order, to defeat detectors that look for sequential sweeps |
| `PSDetect.py` | The defender — a Scapy `sniff()` handler keeping a per-source-IP map of ports touched, expiring entries older than 5 seconds, and alerting when one host hits 15 distinct ports inside that window |

`PSDetect.py` is 39 lines and contains the whole idea: a port scan isn't identifiable by any single
packet, only by a rate across a time window, so detection is a sliding-window problem rather than a
signature-matching one.

## Not included

hw2 was a GPG web-of-trust exercise — a key-signing party with about 35 classmates. Their keys and
names are other people's data, so that assignment is left out of this repo.

## Running

```bash
javac hw1-cryptanalysis/Alan.java && java Alan
pip install scapy && sudo python3 hw5-port-scanning/PSDetect.py   # needs raw sockets
```
