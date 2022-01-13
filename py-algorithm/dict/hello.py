import collections


def solution(arr):
    x_arr = [x for x, y in arr]
    y_arr = [y for x, y in arr]

    return [
        collections.Counter(x_arr).most_common(2)[1][0],
        collections.Counter(y_arr).most_common(2)[1][0]
    ]


if __name__ == '__main__':
    assert solution([[1, 5], [3, 5], [3, 10]]) == [1, 10]
    assert solution([[1, 1], [2, 2], [1, 2]]) == [2, 1]
