def solution(board):
    # tree로 변환 후 가장 끝 node 까지 경로를 모두 가져와
    # 해당 경로들의 마지막 점수값을 구하고 최대 점수를 리턴

    # 0,0부터 마지막 지점까지 모든 경로를 리턴한다
    # returns [ [(x, y), (x, y), ... , (x,y)], [(x, y), (x, y), ... , (x,y)] ]
    def _get_all_paths():
        # TODO implement
        return []

    # 해당 경로의 점수를 리턴한다
    def _calculate_total_score_of(path):
        total_score = 0

        for x, y in path:
            score = board[x][y]

            if score == 0:
                total_score *= -1
            else:
                total_score += score

        return total_score

    paths = _get_all_paths()
    return max([_calculate_total_score_of(path) for path in paths])
