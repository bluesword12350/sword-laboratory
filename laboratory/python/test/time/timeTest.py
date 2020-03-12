import time

if __name__ == '__main__':
    print(time.strftime("%Y-%m-%d %H:%M:%S %z", time.localtime(time.time())))
