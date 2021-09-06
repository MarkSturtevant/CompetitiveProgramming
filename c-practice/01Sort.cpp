//
// Created by sturt on 8/4/2021.
//

#include <vector>
#include <string>
#include <iostream>
#include <algorithm>

using std::cin, std::cout, std::endl, std::string, std::vector;

struct item {
    bool a;
    string b;
    int c;
};

/*
 *  SORTING ALGORITHM: very similar to java's, except the c++ compare function returns a
 *  bool, defining if item i goes before item j.
 */
bool sortAlg(const item& i, const item& j) {
    if (i.a != j.a)
        return ! i.a;
    if (i.b != j.b)
        return i.b.compare(j.b) < 0;
    return i.c < j.c;
}

void letsSortThisOut() {
    int N;
    cin >> N;

    vector<item> items;

    for (int i = 0; i < N; ++i) {
        string a, b;
        int c;
        cin >> a >> b >> c;

        item it{a == "TRUE", b, c};
        items.push_back(it);
    }

    // sort method
    std::sort(items.begin(), items.end(), sortAlg);

    for (const item& it : items)
        cout << (it.a ? "TRUE " : "FALSE ") << it.b << " " << it.c << "\n";
}