//
// Created by sturt on 8/4/2021.
//

#include <unordered_set>
#include <unordered_map>
#include <iostream>
#include <queue>

using std::cin, std::cout, std::endl, std::unordered_set, std::unordered_map, std::queue;

void chainReaction() {

    int N, M;
    cin >> N >> M;

    unordered_map<int, unordered_set<int>> paths;
    unordered_map<int, int> heights;

    for (int i = 0; i < M; ++i) {
        int a, b;
        cin >> a >> b;
        paths[a].insert(b);
        paths[b].insert(a);
    }

    heights[0] = 1;
    queue<int> queue;
    queue.push(0);
    int max = 1;

    while (! queue.empty()) {
        int next = queue.front();
        queue.pop();

        int me = heights[next];

        for (int path : paths[next]) {
            if (heights[path] != 0)
                continue;
            heights[path] = me + 1;
            queue.push(path);
            max = std::max(max, me+1);
        }
    }

    cout << (max - 1) * 5 << endl;
}

