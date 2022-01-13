"""
n x n 크기의 빈 격자와, 정수 jump가 주어집니다. 당신은 이 격자의 최 좌측 상단 칸부터 달팽이처럼 시계방향으로 회전하면서 1부터 n2 까지의 숫자를 차례대로 채우려고 합니다.
아래는 n = 5인 경우, 숫자를 채워나가는 방향을 그림으로 표현한 것입니다.

숫자를 채워나가는 규칙은 다음과 같습니다.

최 좌측 상단 칸에 1을 채웁니다.
시계방향으로 회전하면서 숫자가 채워지지 않은 jump - 1 개의 빈칸을 지나친 후, jump 번째로 만나는 빈칸에 다음 숫자를 적습니다.

2-1. 이미 숫자가 채워진 칸은 세지 않고 그냥 지나칩니다.
2-2. 만약 격자의 중앙 부분에 도착하여 더 이상 갈 곳이 없다면, 다시 최 좌측 상단의 칸으로 돌아가서 하던 작업을 반복합니다.

모든 격자에 1부터 n2 까지의 숫자가 채워질 때까지 2번 작업을 반복합니다.

격자의 세로 좌표는 위에서부터 아래로 1부터 n이며, 가로 좌표는 좌측에서 우측으로 1부터 n입니다. 따라서, 시작하는 칸은 1행 1열이 됩니다. 격자의 크기를 나타내는 n과 숫자를 채워나가는 간격 jump가 매개변수로 주어집니다. 이때, 마지막 숫자가 들어가는 행과 열을 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
"""


def solution(n, jump):
    # 경로를 1차원 배열로 펼친 후에 마지막에 도달하면 제일 처음으로 다시 이동
    total = n * n
    dimension1_map = [0] * total

    seq = 1
    curr_idx = 0

    dimension1_map[curr_idx] = seq

    # 다음 빈 공간에 해당하는 array의 index를 리턴한다
    def _get_next_index():
        # TODO implement
        pass

    # 1차원 배열의 index에 해당하는 2차원 배열의 좌표를 리턴한다
    def _index_to_point():
        # TODO implement
        pass

    while seq < total:
        seq += 1
        curr_idx = _get_next_index()
        dimension1_map[curr_idx] = seq

    return _index_to_point(curr_idx)
