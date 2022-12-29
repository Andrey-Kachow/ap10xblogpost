import subprocess
import time
import os
import signal

INTERVAL = 10
pr = None

try:
    while True:
        pr = subprocess.Popen(os.path.join(".", "build.sh"))

        time.sleep(INTERVAL)

        pr.send_signal(signal.SIGINT)
        pr = None
        time.sleep(3)
        
except KeyboardInterrupt:
    if p is not None:
        pr.send_signal(signal.SIGINT)