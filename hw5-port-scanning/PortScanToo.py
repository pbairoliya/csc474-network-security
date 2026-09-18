
import sys
import socket
import time
import random

# Defining a target
if len(sys.argv) == 2:

  # translate hostname to IPv4
  target = socket.gethostbyname(sys.argv[1])
else:
  print("Invalid amount of Argument")

startTime = time.time()

num = 0
totalPorts = 65535
portDictionary = {}
r = list(range(totalPorts))
random.shuffle(r)
try:
  for x in r:
    try:
      servName = socket.getservbyport(x)
    except:
      serverName = "[unassigned]"
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    result = s.connect_ex((target, x))

    if result == 0:
      num = num + 1
      portDictionary[x] = servName

    s.close()
  print("-" * 25)

except :
  print("\n Program Crashed")


endTime = time.time()

totalTime = float(endTime - startTime)
print(num," ports found")
print(round(totalTime,2), " seconds elapsed")
portsPerSecond = totalPorts/totalTime
print(round(portsPerSecond,2), " ports per second")
print("\nOpen Ports:")
print("-" * 25)

for key, value in portDictionary.items():
    print(key, ' : ', value)