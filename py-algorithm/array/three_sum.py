from typing import List


def solution(nums: List[int]) -> List[List[int]]:
    result = []

    nums = sorted(nums)

    for i in range(len(nums) - 2):
        if (0 < i) and (nums[i] == nums[i - 1]):
            continue

        left, right = i + 1, len(nums) - 1

        while left < right:
            sum = nums[i] + nums[left] + nums[right]

            if sum == 0:
                result.append([nums[i], nums[left], nums[right]])
                break

            elif sum < 0:
                left += 1
            else:
                right -= 1

    return result


if __name__ == '__main__':
    assert solution([-1, 0, 1, 2, -1, -4]) == [
        [-1, 0, 1],
        [-1, -1, 2]
    ]
