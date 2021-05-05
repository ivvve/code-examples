"""
Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
"""
import collections
import re
from typing import List


# Using naive grammar
# def get_most_common_word(paragraph: str, banned: List[str]) -> str:
#     words = re.sub(r'\W+', ' ', paragraph).lower().split(" ")
#     common_words = collections.Counter(words).most_common()
#
#     for word_and_count in common_words:
#         word = word_and_count[0]
#         if word not in banned:
#             return word
#
#     raise ValueError()

# Using pythonic way
def get_most_common_word(paragraph: str, banned: List[str]) -> str:
    words = [word
             for word in re.sub(r'\W+', ' ', paragraph).lower().split(" ")
             if word not in banned]
    return collections.Counter(words).most_common()[0][0]


if __name__ == '__main__':
    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    banned = ["hit"]

    most_common_word = get_most_common_word(paragraph, banned)
    assert most_common_word == "ball"
