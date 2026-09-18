# CSC 474 — Network Security

**NC State, Fall 2022.** Break some crypto, then write the tool that catches you doing it.

> Commit dates are the publication date; the work is from Fall 2022.

## 🔓 Breaking a repeating-key XOR — `hw1/Alan.java`

The one worth reading. 174 lines, no libraries, and it recovers a key it was never given:

1. Compute the **index of coincidence** across a 64-character alphabet to find the key *length*
   (it's 5 — the statistics say so before you ever guess a character).
2. Slice the ciphertext into 5 columns, one per key position.
3. Frequency-rank each column and brute-force against the most common English characters.
4. Out falls the key.

`Julius.java` is the warm-up: single-byte XOR, all 256 keys, read the one that's English.
The written analyses do the same IoC trick against a classical Vigenère — every key length tested,
length 6 chosen at IoC 0.0672.

## 🕵️ Scanning, evading, and getting caught — `hw5/`

An attack and its defence, written as a pair:

| File | Side |
|---|---|
| `PortScan.py` | Sequential TCP connect scan of all 65,535 ports, naming services as it goes |
| `PortScanToo.py` | Same scan, **randomized port order** — defeats anything looking for a sequential sweep |
| `PSDetect.py` | The defender. Scapy `sniff()`, a per-source-IP map of ports touched, entries expiring after 5s, alert at 15 distinct ports inside the window |

`PSDetect.py` is **39 lines** and contains the whole insight: no single packet is a port scan.
It's only a scan as a *rate over a window* — so detection is sliding-window bookkeeping, not
signature matching. Randomizing port order beats a naive detector and does nothing against this one.

## 🔨 Cracking — `hw3/`

hashcat against MD5 (6-char mask, GPU), SHA-256 (custom `?l?d?u` charset with `--increment`),
bcrypt against rockyou — plus a hand-written Python brute-forcer for a custom 100-round
MD5/SHA-256/SHA-512 construction. Written work covers nonce replay, MITM on a signing protocol,
and Kerberos.

## Not included

hw2 was a GPG key-signing party with ~35 classmates. Their keys and names are their data, not mine
to publish.

```bash
javac hw1-cryptanalysis/Alan.java && java Alan
pip install scapy && sudo python3 hw5-port-scanning/PSDetect.py
```

---

*More: [CSC 230](https://github.com/pbairoliya/csc230-c-software-tools) ·
[CSC 246](https://github.com/pbairoliya/csc246-operating-systems) ·
[CSC 484](https://github.com/pbairoliya/csc484-game-ai) ·
[where it started](https://github.com/pbairoliya/first-code)*
