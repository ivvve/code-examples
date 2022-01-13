"""
문제 설명
아래 3가지 유형 중 한 가지에 맞춰 휴대폰 번호를 입력받으려 합니다.

유형 1 : 010-XXXX-XXXX
유형 2 : 010XXXXXXXX
유형 3 : +82-10-XXXX-XXXX
'X'는 0부터 9까지의 숫자 중 하나입니다.

휴대폰 번호 phone_number가 매개변수로 주어질 때, 유형 1~3중 어디에 해당하는지 return 하도록 solution 함수를 완성해주세요. 만약, 어떤 유형에도 해당하지 않는다면 -1을 return 하면 됩니다.

제한 사항
phone_number는 길이가 1 이상 30 이하인 문자열입니다.
phone_number는 숫자, '+', '-' 만으로 이루어진 문자열입니다.

입출력 예
phone_number	result
"01012345678"	2
"010-1212-333"	-1
"+82-10-3434-2323"	3
"+82-010-3434-2323"	-1
입출력 예 설명
입출력 예 #1
유형 2에 해당합니다.

입출력 예 #2
어떤 유형에도 해당하지 않습니다(끝이 4자리가 아님).

입출력 예 #3
유형 3에 해당합니다.

입출력 예 #4
+82-010-3434-2323 부분만 보면 유형 1에 속합니다. 하지만, 휴대폰 번호의 앞뒤로 어떤 문자열도 허용하지 않으므로 어떤 유형에도 해당하지 않습니다. 따라서 -1을 return 합니다.
"""

import re

type1 = re.compile('^010-\d{4}-\d{4}$')
type2 = re.compile('^010\d{8}$')
type3 = re.compile('^\+82-10-\d{4}-\d{4}$')


def solution(phone_number):
    length = len(phone_number)

    if (length == 13) and type1.match(phone_number):
        return 1

    elif (length == 11) and type2.match(phone_number):
        return 2

    elif (length == 16) and type3.match(phone_number):
        return 3

    return -1


if __name__ == '__main__':
    assert solution("01012345678") == 2
    assert solution("010-1212-333") == -1
    assert solution("+82-10-3434-2323") == 3
    assert solution("+82-010-3434-2323") == -1
