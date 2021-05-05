"""
The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
"""
from typing import List


def reorder(logs: List[str]) -> List[str]:
    letter_logs, digit_logs = [], []
    for log in logs:
        if log.split(" ")[1].isdigit():
            digit_logs.append(log)
        else:
            letter_logs.append(log)

    letter_logs.sort(key=lambda log: ((log.split(" ")[1:]), log.split(" ")[0]))
    return letter_logs + digit_logs


if __name__ == '__main__':
    logs = ["dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"]
    assert reorder(logs) == ["let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"]
