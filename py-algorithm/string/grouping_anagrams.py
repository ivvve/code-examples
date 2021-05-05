import collections
from typing import List


def group(words: List[str]) -> List[List[str]]:
    anagrams = collections.defaultdict(list)

    for word in words:
        sorted_word = "".join(sorted(word))
        anagrams[sorted_word].append(word)

    return list(anagrams.values())


if __name__ == '__main__':
    words = ["eat", "tea", "tan", "ate", "nat", "bat"]
    assert group(words) == [
        ["eat", "tea", "ate"],
        ["tan", "nat"],
        ["bat"]
    ]
