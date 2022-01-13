from typing import List


# O(n^2)
def get_combinations(nums: List[int], target: int) -> List[int]:
    for i in range(len(nums)):
        for j in range(i + 1, len(nums)):
            num1, num2 = nums[i], nums[j]

            if (num1 + num2) == target:
                return [i, j]


# O(n)
def get_combinations(nums: List[int], target: int) -> List[int]:
    nums_dict = {}

    for i, num in enumerate(nums):
        if (target - num) in nums_dict:
            return [nums_dict[target - num], i]

        nums_dict[num] = i


if __name__ == '__main__':
    assert get_combinations([2, 7, 11, 15], 9) == [0, 1]
