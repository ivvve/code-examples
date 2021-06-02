"""
https://leetcode.com/problems/longest-substring-without-repeating-characters/
"""


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        longest = 0

        for i in range(len(s)):
            chars = set()

            for j in range(i, len(s)):
                c = s[j]

                if c in chars:
                    break

                chars.add(c)

            if longest < len(chars):
                longest = len(chars)

        return longest


if __name__ == '__main__':
    assert Solution().lengthOfLongestSubstring("abcabcbb") == 3
    assert Solution().lengthOfLongestSubstring("bbbbb") == 1
    assert Solution().lengthOfLongestSubstring("pwwkew") == 3
    assert Solution().lengthOfLongestSubstring("") == 0
