import sys
import time
import socket
from collections import deque
import pprint as pp

import scapy.all as scapy
from scapy.all import sniff, TCP, sr1,IP,ICMP

ipDictionary = {}


def handler(packet):
    timeStart = round(time.time())
    if not packet or IP not in packet:
        return packet    
    src = packet[IP].src
    dst = packet[IP].dst
    dport = packet.dport
    sport = packet.sport
    tempDict = {dport: round(time.time())}
    if(ipDictionary.get(src)== None):
        ipDictionary[src] = tempDict
    else:
        ipDictionary[src][dport] = time.time()
    length = len(ipDictionary[src])
    for ipAdress in ipDictionary:
        for port in ipDictionary[ipAdress]:
            if(timeStart - ipDictionary[ipAdress][port] > 5):
                length = length - 1
    
    if(length>=15):
        print("Scanner detected. The scanner originated from host", str(src) ,".")


sniff( iface="lo", prn=handler, store=0)



    