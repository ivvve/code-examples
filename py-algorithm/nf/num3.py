"""
온라인으로 시험을 보는 프로그래밍 학원이 있습니다. 모든 시험 문제는 프로그램에 의해 자동으로 채점되며, 부분점수가 부여됩니다. 채점은 답안 제출과 동시에 실시간으로 이루어지며, 채점 로그가 시험 관리자에게 전달됩니다. 관리자는 시험이 모두 끝난 후 채점 로그를 통해 부정행위자로 의심되는 사람들을 찾아내려고 합니다. 이를 위해 다음과 같은 조건을 정했습니다.

1. 두 수험자가 푼 문제 수가 같다. 단, 푼 문제 수가 5 미만인 경우는 제외한다.
2. 두 수험자가 푼 문제의 번호가 모두 같다.
3. 두 수험자가 푼 문제의 점수가 모두 같다.
임의의 두 수험자가 위 3가지 조건에 모두 부합하는 경우, 두 수험자를 부정행위자로 의심합니다.

수험자의 수험번호, 문제 번호, 받은 점수를 나타내는 문자열 배열 logs가 매개변수로 주어집니다. 위 조건에 해당하는 모든 부정행위 의심자의 수험번호를 배열에 담아 사전 순으로 정렬하여 return 하도록 solution 함수를 완성해주세요. 단, 부정행위자로 의심되는 수험자가 없는 경우에는 문자열 "None"을 배열에 담아 return 해주세요.

---

제한사항
logs의 길이는 1 이상 5,000 이하입니다.
logs의 원소는 한 수험자가 한 문제를 풀었을 때 받은 점수를 나타냅니다.
logs의 원소는 "수험번호 문제번호 점수" 형식의 문자열입니다.
수험번호는 길이가 4인 문자열이며 숫자로만 이루어져 있습니다.
문제번호는 1 이상 100 이하인 자연수입니다.
점수는 0 이상 100 이하인 정수입니다.
문제를 풀지 않은 경우는 logs에 기록되지 않습니다.
한 수험자가 같은 문제에 대해 여러 번 답안을 제출할 수 있습니다. 단, 마지막 제출의 채점 결과가 최종 점수입니다.
0점을 받는 답안 제출도 문제를 푼 것으로 칩니다.
"""

from collections import defaultdict


def solution(logs):
    target_user_scores = _get_target_user_scores_from(logs)

    answer = set()
    loop = len(target_user_scores)

    for i in range(loop):
        for j in range(i + 1, loop):
            user1, score1 = target_user_scores[i]
            user2, score2 = target_user_scores[j]

            if (user1 in answer) and (user2 in answer):
                continue

            if score1 == score2:
                answer.add(user1)
                answer.add(user2)

    if len(answer) == 0:
        return ['None']

    return sorted(list(answer))


def _get_target_user_scores_from(logs):
    user_scores = _parse_logs(logs)
    return [
        (user, score)
        for user, score in user_scores.items()
        if 5 <= len(score)
    ]


def _parse_logs(logs):
    """
    {
      id: {
        num: score,
      },
      ...
    }
    """
    user_scores = defaultdict(lambda: defaultdict(lambda: 0))

    for log in logs:
        id, num, score = log.split()
        user_scores[id][int(num)] = int(score)

    return user_scores


if __name__ == '__main__':
    # assert solution(
    #     ["0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90",
    #      "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"]) == ["0001", "0002"]
    # assert solution(["1901 10 50", "1909 10 50"]) == ["None"]
    assert solution(
        ["1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100",
         "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95",
         "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100",
         "1102 9 100"]) == ["1101", "1102", "1901", "1902", "1903"]
