"""
https://leetcode.com/problems/number-of-islands/
"""

from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        nums = 0

        for y in range(len(grid)):
            for x in range(len(grid[0])):

                if grid[y][x] == "1":
                    nums += 1
                    self.check(grid, x, y)

        return nums

    def check(self, grid, x, y):
        grid[y][x] = "2"

        # 상
        if (0 < y) and (grid[y - 1][x] == "1"):
            self.check(grid, x, y - 1)

        # 좌
        if (0 < x) and (grid[y][x - 1] == "1"):
            self.check(grid, x - 1, y)

        # 하
        if (y < len(grid) - 1) and grid[y + 1][x] == "1":
            self.check(grid, x, y + 1)

        # 우
        if (x < len(grid[0]) - 1) and grid[y][x + 1] == "1":
            self.check(grid, x + 1, y)


if __name__ == '__main__':
    grid = [
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"]
    ]
    assert Solution().numIslands(grid) == 1

    for i in grid:
        print(i)
    print()

    grid = [
        ["1", "1", "0", "0", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "1", "0", "0"],
        ["0", "0", "0", "1", "1"]
    ]
    assert Solution().numIslands(grid) == 3

    for i in grid:
        print(i)
    print()

    grid = [
        ["1", "0", "1", "1", "1"],
        ["1", "0", "1", "0", "1"],
        ["1", "1", "1", "0", "1"]
    ]
    assert Solution().numIslands(grid) == 1
