import collections
import re

from typing import Deque


# Using Deque
def is_valid(value: str) -> bool:
    chars: Deque = collections.deque()

    for char in value:
        if char.isalnum():
            chars.append(char.lower())

    while 1 < len(chars):
        if chars.popleft() != chars.pop():
            return False

    return True


# Using string slicing
def is_valid(value: str) -> bool:
    filtered_lower_value = re.sub(r'\W+', '', value).lower()
    return filtered_lower_value == filtered_lower_value[::-1]


if __name__ == '__main__':
    assert is_valid("ABCBA") is True
    assert is_valid("aBCbA") is True  # 대소문자 구분 X
    assert is_valid("2aBCbA2") is True

    assert is_valid("A BC B  A") is True

    assert is_valid("ABB") is False
    assert is_valid("aBbB") is False
