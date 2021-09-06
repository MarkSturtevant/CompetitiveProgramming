//
// Created by sturt on 7/30/2021.
//

#include <unordered_map>
#include <iostream>

using std::unordered_map, std::cin, std::cout, std::endl;

void portals() {
    // map - tree map
    // unordered_map - hash map

    int N;
    cin >> N;

    unordered_map<int, int> map;

    for (int i = 0; i < N; ++i) {
        int x1, x2;
        cin >> x1 >> x2;

        // two ways to insert; inserting via function and passing a pair OR using the [] = operator.
        // in this case, we want to use [] = instead of insert() as we want to replace old values for x1.

        if (map.find(x2) == map.end()) {
            // x2 is not in the map; simply map x1 -> x2
            map[x1] = x2;
        } else {
            // x2 maps to another x value;  map x1 -> where x2 goes
            map[x1] = map[x2];
        }
    }

    int T;
    cin >> T;

    for (int i = 0; i < T; ++i) {
        int next;
        cin >> next;

        if (map.find(next) == map.end()) {
            // no portals; simply output original location
            cout << next << "\n";
        } else {
            // output what next maps to since it goes through portals
            cout << map[next] << "\n";
        }
    }
}
