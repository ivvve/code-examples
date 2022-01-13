"""
문제 설명
투썸플레이스 OO 지점에서는 사은 이벤트로 매일 고객 한 명을 임의로 선정해 커피 무료 쿠폰을 발송합니다.
배열 arr에는 고객들의 ID가 이벤트에 당첨된 순서대로 들어있으며, 각 고객의 ID는 자연수입니다.
쿠폰에 당첨된 고객 중, 가장 빨리 중복으로 당첨된 고객은 며칠 만에 중복 당첨됐는지를 return 하도록 solution 함수를 작성하세요.
단, 중복으로 당첨된 고객이 없는 경우 -1을 return 하세요.

제한사항
배열의 길이는 1 이상 100,000 이하입니다.
배열의 원소는 1 이상 1,000,000,000 이하의 자연수입니다.

입출력 예
arr	result
[2, 1, 3, 1, 4, 2, 1, 3]	2
[1, 2, 3]	-1
입출력 예 설명
입출력 예 #1
배열이 [2, 1, 3, 1, 4, 2, 1, 3]이라면 (arr[1], arr[3], arr[6])에서 1번 고객이 중복해서 나타나서 2일만에 중복으로 당첨된 기록이 있고,
(arr[0], arr[5])에서 2번 고객이 5일만에 중복해서 당첨된 기록이 있습니다. 또 (arr[2], arr[7])에서 3번 고객이 5일만에 당첨되었습니다.
이 중, 1번 고객이 가장 짧은 2일만에 중복 당첨되었으므로 2를 return합니다.

입출력 예 #2
배열이 [1, 2, 3]일때 중복해서 나타나는 수가 없으므로 -1을 return합니다.
"""

import sys


def solution(arr):
    win_history = {}
    shortest_dup = sys.maxsize

    for index, id_ in enumerate(arr):
        if id_ in win_history:
            shortest_dup = min(index - win_history[id_], shortest_dup)

        win_history[id_] = index

    if shortest_dup == sys.maxsize:
        return -1

    return shortest_dup


if __name__ == '__main__':
    assert solution([1, 9, 8, 2, 1, 2]) == 2
    assert solution([2, 1, 3, 1, 4, 2, 1, 3]) == 2
    assert solution([1, 2, 3]) == -1
