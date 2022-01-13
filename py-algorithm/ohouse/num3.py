"""
문제 설명
o, h 두 종류의 문자로 이루어진 길이 N의 문자열 str이 주어져 있습니다.
당신은 종이에 이 문자열을 여러가지 색의 펜으로 쓰려고 합니다.

문자열을 다 적고 나서, 만약 특정한 색으로 쓴 글자가 정확히 3개이고 왼쪽에서부터 순서대로 읽었을때 o,h,o가 되는 경우 그 색을 오늘의색깔이라고 합니다.

오늘의색깔의 개수가 최대가 되도록 할 때, 그 때 오늘의색깔의 개수를 구해 리턴하세요. 단, 당신은
굉장히 많은 색의 펜을 가지고 있기 때문에, 펜 종류가 부족해서 오늘의색깔의 개수가 적어지는 일은 발생하지 않는다고 가정합니다.

제한사항

1 <= N <= 100
주의사항

시간 안에 작동하지 않는 풀이도 점수를 받을 수 있습니다. 시간 초과가 발생할 것으로 예상되는 풀이라고 해서 제출하지 않는 것보다는 제출하는 것이 좋습니다.

N<=15일 때 시간 안에 올바르게 작동하는 코드를 작성한 경우, 최소 50점을 얻을 수 있습니다.

입출력 예

str	result
"oohhoooh"	2
"ohohohohoooo"	4
입출력 예 설명
입출력 예 #1
1, 3, 5 번째 문자를 빨간색 펜,
2, 4, 6 번째 문자를 파란색 펜으로 쓰면 두 색 모두 오늘의색깔이 됩니다.

입출력 예 #2

1,2,12번째 문자를 빨간색 펜,
3,4,11번째 문자를 파란색 펜,
5,6,10번째 문자를 초록색 펜,
7,8,9번째 문자를 노란색 펜,
나머지 문자를 검은색 펜으로 쓰면 오늘의색깔은 빨간색, 파란색, 초록색, 노란색의 4개가 됩니다.
"""
from itertools import permutations


def solution(str):
    index_char_arr = [(index, char) for index, char in enumerate(str)]

    max_cnt = 0

    # 1. 문자열에서 3문자 씩 묶을 수 있는 조합을 찾는다
    for index_char_combination in permutations(index_char_arr, len(index_char_arr)):
        # 2. 3문자 씩 묶인 배열에서 oho인 원소들의 갯수를 구한다.
        str_arr = split_and_sort_str_arr(index_char_combination)
        cnt = len([_str for _str in str_arr if is_color_of_today(_str)])

        # 3. 다른 조합들의 oho인 원소들의 갯수와 비교한다.
        max_cnt = max(max_cnt, cnt)

    return max_cnt


def split_and_sort_str_arr(index_char_combination):
    result = []

    for i in range(0, len(index_char_combination), 3):
        index_char_arr = sorted(index_char_combination[i:i + 3], key=lambda index_char: index_char[0])
        result.append("".join(index_char[1] for index_char in index_char_arr))

    return result


def is_color_of_today(str):
    return str == "oho"