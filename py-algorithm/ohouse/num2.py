def solution(N, height):
    result = 0

    for i, _ in enumerate(height):
        middle_max = 0

        for j in range(i + 1, len(height)):
            cc = height[i:j + 1]
            first_el, last_el = cc[0], cc[-1]

            if len(cc) == 2:
                result += 1

                if first_el < last_el:
                    break

            elif middle_max < last_el:
                result += 1

            if first_el == last_el:
                break

            middle_max = max(middle_max, last_el)

    return result
    # return combinations


if __name__ == '__main__':
    arr = [4, 3, 2, 3, 5]
    result = 0

    for i, _ in enumerate(arr):
        print("--------")

        middle_max = 0

        for j in range(i + 1, len(arr)):
            cc = arr[i:j + 1]
            first_el, last_el = cc[0], cc[-1]
            print(cc)

            if len(cc) == 2:
                result += 1

                if first_el < last_el:
                    break

            elif middle_max < last_el:
                result += 1

            if first_el == last_el:
                break

            middle_max = max(middle_max, last_el)

    print(result)

    # return combinations
