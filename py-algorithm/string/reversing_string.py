from typing import List


# Using two pointer swapping
# def reverse(value: List[str]):
#     left, right = 0, len(value) - 1
#     while left < right:
#         value[left], value[right] = value[right], value[left]
#         left += 1
#         right -= 1


# Using List.reverse
def reverse(value: List[str]):
    value.reverse()

# Using List slicing
# def reverse(value: List[str]):
#     value[:] = value[::-1]


if __name__ == '__main__':
    chars = ["h", "e", "l", "l", "o"]
    reverse(chars)
    assert chars == ["o", "l", "l", "e", "h"]

    chars = ["h", "e", "l", "l", "o"]
    reverse(chars)
    assert chars != ["o", "l", "l", "e", "e"]
