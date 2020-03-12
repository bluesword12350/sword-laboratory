import itchat

if __name__ == '__main__':
    itchat.auto_login(hotReload=True)
    itchat.send('Hello AlicFeng', toUserName='filehelper')
