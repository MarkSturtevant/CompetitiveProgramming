//
// Created by sturt on 8/4/2021.
//

#include <string>
#include <iostream>

using std::cout, std::cin, std::endl, std::string;

/*
 * Typically, this problem would use stacks but an easier, recursive solution was found.
 * To use stacks, they have essentially the same methods as a queue (see 09).
 */

int prefixRecur() {
    string next;
    cin >> next;

    if (next == "+")
       return prefixRecur() + prefixRecur();
    else if (next == "-")
        return prefixRecur() - prefixRecur();
    else if (next == "*")
        return prefixRecur() * prefixRecur();
    else if (next == "/")
        return prefixRecur() / prefixRecur();
    else
        return std::stoi(next);
}

void prefix() {
    cout << prefixRecur() << endl;
}

