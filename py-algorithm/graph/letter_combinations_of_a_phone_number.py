"""
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
"""
from typing import List


class Solution:
    keyboard = {
        "2": "abc",
        "3": "def",
        "4": "ghi",
        "5": "jkl",
        "6": "mno",
        "7": "pqrs",
        "8": "tuv",
        "9": "wxyz",
    }

    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []

        def append_letter(index: int, combination: str):
            if len(combination) == len(digits):
                result.append(combination)
                return

            digit = digits[index]
            for letter in self.keyboard[digit]:
                append_letter(index + 1, combination + letter)

        result = []
        append_letter(0, "")
        return result


if __name__ == '__main__':
    assert Solution().letterCombinations("23") == ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    assert Solution().letterCombinations("") == []
    assert Solution().letterCombinations("2") == ["a", "b", "c"]
