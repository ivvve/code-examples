"""
https://leetcode.com/problems/combination-sum/
"""
from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(combination: List[int], left_nums: List[int]):
            if sum(combination) == target:
                result.append(combination)
                return

            if sum(combination) > target:
                return


            for i in range():
                pass

            for num in left_nums:
                dfs(added(combination, num), left_nums)

            dfs(removed_last(combination), removed_first(left_nums))

        result = []
        dfs([], candidates)
        return result


def added(nums: List[int], num: int) -> List[int]:
    return nums + [num]


def removed_first(nums: List[int]) -> List[int]:
    return nums[1:]

def removed_last(nums: List[int]) -> List[int]:
    return nums[:-1]

if __name__ == '__main__':
    assert Solution().combinationSum([2, 3, 6, 7], 7) == [[2, 2, 3], [7]]
    assert Solution().combinationSum([2, 3, 5], 8) == [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
    assert Solution().combinationSum([2], 1) == []
    assert Solution().combinationSum([1], 1) == [[1]]
    assert Solution().combinationSum([1], 2) == [[1, 1]]
