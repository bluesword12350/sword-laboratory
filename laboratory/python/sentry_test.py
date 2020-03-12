import sentry_sdk

if __name__ == '__main__':
    sentry_sdk.init("dsn",
                    debug=True)
    sentry_sdk.capture_message("日志输出测试 by python")
