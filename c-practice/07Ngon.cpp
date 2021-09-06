//
// Created by sturt on 7/30/2021.
//

#include <iostream>
#include <cmath>
#include <iomanip>

using std::cin, std::cout, std::endl;
using std::sqrt, std::sin, std::cos, std::pow, std::atan2;

void ngon() {
    int N;
    cin >> N;

    double x1, y1, x2, y2;
    cin >> x1 >> y1 >> x2 >> y2;

    double magnitude, direction, angleChange;

    // get polygon data (edge length, direction, angle change, etc.
    magnitude = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    direction = atan2(y2 - y1, x2 - x1);
    angleChange = M_PI - (M_PI * (N-2) / N);

    // build the polygon.
    double x = x2, y = y2;
    direction += angleChange;
    for (int i = 0; i < N-2; ++i) {
        x += magnitude * cos(direction);
        y += magnitude * sin(direction);
        direction += angleChange;

        cout << std::setprecision(5) << x << " " << y << "\n";
    }
}