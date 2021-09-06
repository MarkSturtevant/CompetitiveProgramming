//
// Created by sturt on 8/4/2021.
//

#include <iostream>

using std::cin, std::cout, std::endl;

int gcd(int a, int b) {
    if (a == 0 || b == 0)
        return 0;
    if (a > b) {
        int temp = a;
        a = b;
        b = temp;
    }
    while (a != 0) {
        int temp = a;
        a = b % a;
        b = temp;
    }
    return b;
}

void gcdAndLcm() {
    int a, b, c, g;
    cin >> a >> b >> c;

    g = gcd(gcd(a, b), c);
    cout << g << endl;

    a /= g;
    b /= g;
    c /= g;

    int lcm = g;

    do {
        g = gcd(a, b);
        a /= g;
        b /= g;
        lcm *= g;
    } while (g != 1);

    do {
        g = gcd(a, c);
        a /= g;
        c /= g;
        lcm *= g;
    } while (g != 1);

    do {
        g = gcd(b, c);
        b /= g;
        c /= g;
        lcm *= g;
    } while (g != 1);

    lcm *= a * b * c;

    cout << lcm << endl;

}