"""
문제 설명
택배를 이용해 총 n개의 옷을 배송하려고 합니다. 택배 회사에는 현재 옷 3개, 5개를 담을 수 있는 상자가 준비되어 있습니다. 상자의 크기에 상관없이 상자의 개수로 배송비를 받기 때문에, 상자의 개수를 최소한으로 줄이려고 합니다. 단, 상자를 보내기 위해서는 상자에 반드시 들어갈 수 있는 옷이 모두 들어가야 합니다. 즉, 옷을 2개만 담은 상자는 배송할 수 없습니다. 보내야 할 옷의 개수 n이 주어질 때, 배송비를 최소화할 수 있는 상자의 개수를 return하도록 solution 함수를 완성하세요. 어떠한 방법으로도 모든 옷을 보낼 수 없다면 -1을 반환하면 됩니다.

제한사항
옷의 개수 n : 3 ≤ n ≤ 1,000,000,000

n	result
15	3
7	-1
"""


def solution(n):
    div5, mod5 = divmod(n, 5)

    if mod5 == 0:
        return div5

    div3, mod3 = divmod(mod5, 3)

    if mod3 == 0:
        return div5 + mod3

    # ---

    div3, mod3 = divmod(mod5 + 5, 3)


def solution(n):
    div5, mod5 = divmod(n, 5)

    if mod5 == 0:
        return div5

    for i in reversed(range(div5)):
        n_for_3 = n - (5 * i)

        div3, mod3 = divmod(n_for_3, 3)

        if mod3 == 0:
            return i + div3

    return -1

