graph = {
    1: [2, 3, 4],
    2: [5],
    3: [5],
    4: [],
    5: [6, 7],
    6: [],
    7: [3],
}


def dfs(v, visited=[]):
    visited.append(v)

    for e in graph[v]:
        if e not in visited:
            visited = dfs(e, visited)

    return visited


if __name__ == '__main__':
    print(dfs(1))
