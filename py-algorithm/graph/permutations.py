"""
https://leetcode.com/problems/permutations/
"""
from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def dsf(combination: List[int], left_nums: List[int]):
            if len(combination) == len(nums):
                result.append(combination)
                return

            for num in left_nums:
                dsf(get_added(combination, num), get_removed(left_nums, num))

        result = []
        dsf([], nums)
        return result


def get_added(nums: List[int], num: int) -> List[int]:
    nums = nums[:]
    nums.append(num)
    return nums


def get_removed(nums: List[int], num: int) -> List[int]:
    nums = nums[:]
    nums.remove(num)
    return nums


if __name__ == '__main__':
    assert Solution().permute([1, 2, 3]) == [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    assert Solution().permute([0, 1]) == [[0, 1], [1, 0]]
    assert Solution().permute([1]) == [[1]]
