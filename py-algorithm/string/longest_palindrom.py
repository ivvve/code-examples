def find_longest(word: str) -> str:
    if word == word[::-1]:
        return word

    result = ""

    for i in range(len(word)):
        # Odd
        left, right = i, i
        while (0 <= left) and (right < len(word)) and (word[left] == word[right]):
            palindrom_word = word[left:right]

            if len(result) < len(palindrom_word):
                result = palindrom_word

        # Even
        left, right = i, i + 1
        while (0 <= left) and (right < len(word)) and (word[left] == word[right]):
            palindrom_word = word[left:right]

            if len(result) < len(palindrom_word):
                result = palindrom_word

    return result


def find_longest(word: str) -> str:
    if word == word[::-1]:
        return word

    result = ""

    for i in range(len(word)):
        result = max(
            result,
            _find_longest_palindrom_from(word, i, i),
            _find_longest_palindrom_from(word, i, i + 1),
            key=len
        )

    return result


def _find_longest_palindrom_from(word: str, left: int, right: int) -> str:
    result = ""

    while (0 <= left) and (right < len(word)) and (word[left] == word[right]):
        result = word[left:right + 1]
        left -= 1
        right += 1

    return result


if __name__ == '__main__':
    assert find_longest("ww") == "ww"
    assert find_longest("bab") == "bab"
    assert find_longest("cbbd") == "bb"
    assert find_longest("cbbbd") == "bbb"
