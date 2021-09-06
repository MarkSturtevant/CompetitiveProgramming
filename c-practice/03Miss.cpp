//
// Created by sturt on 7/30/2021.
//

#include <iostream>
#include <set>

using std::cout, std::cin, std::endl, std::set;

void whatdIMiss() {
    int N;
    cin >> N;

    int missing = 0;

    set<int> set;
    for (int i = 0; i < N; ++i) {
        int next;
        cin >> next;

        if (next < 1 || next > N) {
            missing++;
            continue;
        }

        // test if 'next' is in set.  If so, there are duplicates
        if (set.find(next) != set.end()) {
            missing++;
            continue;
        }

        set.insert(next);
    }

    cout << missing;
}