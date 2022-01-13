"""
두 문자열의 앞뒤를 겹쳐서 만들 수 있는 문자열 중, 더 짧은 문자열을 구하려합니다.

예를 들어 "xyZA"와 "ABCxy"가 주어졌을 때, 두 문자열을 겹치는 방법은 다음과 같습니다.

방법1. "xyZA" 뒤에 "ABCxy" 겹치기
"""


def solution(s1, s2):
    solution1 = get_shortest_sum(s1, s2)
    solution2 = get_shortest_sum(s2, s1)

    if len(solution1) < len(solution2):
        return solution1

    elif len(solution2) < len(solution1):
        return solution2

    else:
        return sorted([solution1, solution2])[0]


def get_shortest_sum(s1, s2):
    shortest = ""

    s1_length = len(s1)

    for i in range(1, s1_length + 1):
        s1_back = s1[s1_length - i:]
        s2_front = s2[:i]

        if s1_back == s2_front:
            s2_back = s2[i:]

            shortest = s1 + s2_back

    return shortest


if __name__ == '__main__':
    print(solution("xyZA", "ABCxy"))
