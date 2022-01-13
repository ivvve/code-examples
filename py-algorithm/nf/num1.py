"""
XX 페이를 이용해서 물품을 구매한 고객들에게 10% 할인 쿠폰을 지급하려 합니다. 쿠폰을 지급하는 방법은 다음과 같습니다.

물품을 구매한 고객은 하루에 최대 1장씩 할인 쿠폰을 받습니다.
고객 한 명당 최대 k장까지 할인 쿠폰을 받을 수 있습니다.
예를 들어 고객 한 명당 k = 2장까지 할인 쿠폰을 받을 수 있고, A 고객이 3일 동안 매일 물건을 구매했다면, 이 고객은 할인 쿠폰을 두 장 받습니다.

각 날짜별로 XX 페이를 이용해 물품을 구매한 고객들의 ID가 문자열 형태로 담긴 배열 id_list, 고객 한 명당 받을 수 있는 최대 쿠폰 수 k가 매개변수로 주어질 때, 고객들에게 지급된 쿠폰은 모두 몇 장인지 return 하도록 solution 함수를 완성해주세요.

제한사항
- id_list의 길이는 1 이상 1,000 이하입니다.
  - id_list의 원소는 각 날짜별로 물품을 구매한 고객 ID가 담긴 문자열입니다.
  - 각 문자열의 길이는 1 이상 10,000 이하입니다.
  - 문자열에서 고객 ID는 공백으로 구분되어 있습니다.
  - 고객 ID의 길이는 1 이상 10 이하이며, 알파벳 대문자로만 되어있습니다.
  - 하루에 물품을 여러 번 구매한 고객이 있을 수 있습니다.
- k는 1 이상 id_list의 길이 이하인 자연수입니다.


"""

from collections import defaultdict


def solution(id_list, k):
    id_and_daily_purchase_count = _get_id_and_daily_purchase_count(id_list)
    return _sum_total_max_coupon_count(id_and_daily_purchase_count, k)


def _get_id_and_daily_purchase_count(id_list):
    id_and_daily_purchase_count = defaultdict(lambda: 0)

    for ids in id_list:
        ids = set(ids.split())  # 하루에 여러 번 구입하는 경우 제외

        for id in ids:
            id_and_daily_purchase_count[id] += 1

    return id_and_daily_purchase_count


def _sum_total_max_coupon_count(id_and_daily_purchase_count, max_coupon_count):
    total_coupon_count = 0

    for day_purchases_count in id_and_daily_purchase_count.values():
        total_coupon_count += _get_max_coupon_count(day_purchases_count, max_coupon_count)

    return total_coupon_count


def _get_max_coupon_count(daily_purchase_count, max_coupon_count):
    if daily_purchase_count < max_coupon_count:
        return daily_purchase_count
    return max_coupon_count


if __name__ == '__main__':
    assert solution(["A B C D", "A D", "A B D", "B D"], 2) == 7
    assert solution(["JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"], 3) == 8
