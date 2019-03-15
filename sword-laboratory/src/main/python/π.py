from decimal import Decimal as Dec, getcontext as gc


def PI(max_k=70, prec=1008, disp=1007):
    gc().prec = prec
    K, M, L, X, S = 6, 1, 13591409, 1, 13591409
    for k in range(1, max_k + 1):
        M = (K ** 3 - 16 * K) * M // k ** 3
        L += 545140134
        X *= -262537412640768000
        S += Dec(M * L) / X
        K += 12
    pi = 426880 * Dec(10005).sqrt() / S
    pi = Dec(str(pi)[:disp])
    return pi


if __name__ == '__main__':
    Pi = PI(353, 5022, 5020)
    print(Pi)
