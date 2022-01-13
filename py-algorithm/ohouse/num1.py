"""
문제 설명
N개의 마을이 일렬로 1번부터 N번까지 순서대로 산등성이를 따라 있습니다. 각 마을이 있는 위치의 높이는 자연수로 표현됩니다.

어떤 연속한 구간을 선택했을 때, 그 구간이 적어도 2개 이상의 마을을 포함하면서 구간 양 끝에 위치하는 마을의 높이가 그 사이에 있는 모든 마을들의 높이보다 높다면, 그 구간에 해당하는 지형을 그릇(bowl) 지형이라고 부릅니다.

N개의 마을의 높이를 나타내는 크기 N인 배열 height가 주어집니다. 이 때, 찾을 수 있는 모든 그릇 지형들의 총 개수를 리턴하세요.

제한사항

마을의 개수 N은 1 이상 100만 이하인 자연수입니다.
배열 height의 길이는 N입니다.
height의 각 원소는 1 이상 10억 이하의 자연수입니다.
주의사항

시간 안에 작동하지 않는 풀이도 점수를 받을 수 있습니다. 시간 초과가 발생할 것으로 예상되는 풀이라고 해서 제출하지 않는 것보다는 제출하는 것이 좋습니다.

N<=500일 때 시간 안에 올바르게 작동하는 코드를 작성한 경우, 최소 30점을 얻을 수 있습니다.
N<=5000일 때 시간 안에 올바르게 작동하는 코드를 작성한 경우, 최소 60점을 얻을 수 있습니다.
N<=500000일 때 시간 안에 올바르게 작동하는 코드를 작성한 경우, 최소 90점을 얻을 수 있습니다.
입출력 예

N	height	result
5	[4,3,2,3,5]	6
4	[3,3,3,3]	3
입출력 예 설명
입출력 예 #1
i번째 마을부터 j번째 마을까지의 구간을 [i,j]로 표시합시다. 구간 [1,5]는 양 끝 마을의 높이가 4, 5로 그 사이에 있는 마을의 높이인 3, 2, 3 보다 모두 높기 때문에 그릇 지형입니다. 반면, 지형 [2,5]는 2번째 마을의 높이가 4번째 마을의 높이보다 높지 않기 때문에 그릇 지형이 아닙니다. 그릇 지형인 구간은 [1,2], [2,3], [3,4], [4,5], [2,4], [1,5] 의 6개입니다.

입출력 예 #2
모든 마을의 높이가 같기 때문에 두 마을로 이루어진 구간만 그릇 지형입니다. 따라서 그릇 지형은 총 3개입니다.
"""

# 굳이 모든 조합을 하나씩 돌지 않아도 될 것 같다
def solution(N, height):
    combinations = generate_all_combinations(height)
    return len([c for c in combinations if is_bowl(c)])

def generate_all_combinations(height_arr):
    combinations = []

    for i, _ in enumerate(height_arr):
        for j in range(i + 1, len(height_arr)):
            combinations.append(height_arr[i:j + 1])

    return combinations


def is_bowl(height_arr):
    if len(height_arr) == 2:
        return True

    first_height, last_height = height_arr[0], height_arr[-1]

    # iterate heights between first and last
    for i in range(1, len(height_arr) - 1):
        between_height = height_arr[i]

        if first_height <= between_height or last_height <= between_height:
            return False

    return True