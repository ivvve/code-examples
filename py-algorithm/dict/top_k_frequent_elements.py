"""
https://leetcode.com/problems/top-k-frequent-elements/
"""
from collections import Counter
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        return [common[0] for common in Counter(nums).most_common(k)]


if __name__ == '__main__':
    Solution().topKFrequent([1, 1, 1, 2, 2, 3], 2)
