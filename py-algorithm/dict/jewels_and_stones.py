"""
https://leetcode.com/problems/jewels-and-stones/
"""


class Solution:
    def numJewelsInStones1(self, jewels: str, stones: str) -> int:
        count = 0

        for stone in stones:
            if stone in jewels:
                count += 1

        return count

    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        return sum([s in jewels for s in stones])


if __name__ == '__main__':
    print(Solution().numJewelsInStones("aA", "aAAbbbb"))
    print(Solution().numJewelsInStones("z", "ZZ"))
