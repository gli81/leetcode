def test(x, y):
    ans = 0
    for n in range(1, 10001):
        add_ = ((y+(4*y/n/x))/(x/2)) ** n
        ans += add_
    return ans / 10000

print(
        test(4, 2)
    )
