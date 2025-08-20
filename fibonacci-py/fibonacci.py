class Fibonacci:
    def fib(self, n):
        if n == 0:
            return 0
        if n == 1:
            return 1
        return self.fib(n - 2) + self.fib(n - 1)


# fibonacci
# 0 1 2 3 4 5 6 7
# 0 1 1 2 3 5 8 13
fib = Fibonacci()
valuePair = {0: 0, 1: 1, 2: 1, 3: 2, 4: 3, 5: 5}

for key, value in valuePair.items():
    assert fib.fib(key) == value
