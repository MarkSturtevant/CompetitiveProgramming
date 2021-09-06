//
// Created by sturt on 7/30/2021.
//

#include <string>
#include <iostream>

using std::stoi, std::string, std::getline, std::cin, std::cout, std::endl, std::to_string;

void guessCounter() {
    string in;
    getline(cin, in);

    // iterate through each number of digits the first number could have.  Test the rest of the string
    // based on the first number guessed.
    for (int f = 1; f <= 6; ++f) {
        // take the first number based on f, number of digits.
        string first = in.substr(0, f);

        // now take the next number, also a guess.
        for (int g = 1; g <= 6; ++g) {
            // ensure we don't go beyond string length
            if (g + f > in.length())
                break;

            // take the next number based on g, number of digits.
            string current = in.substr(f, g);
            int pos = f + g;
            int cnt = 2;
            int change = stoi(current) - stoi(first);
            bool successful = true;

            while (pos < in.length()) {
                // get next number
                int next = stoi(current) + change;

                // check next to ensure it is not out of bounds
                if (next <= 0) {
                    successful = false;
                    break;
                }

                // update current
                current = to_string(next);

                if (pos + current.length() > in.length()) {
                    // went past string; cannot account for remaining characters.
                    successful = false;
                    break;
                }

                // iterate through current; does the input have the expected number at this position?
                for (int j = 0; j < current.length(); ++j) {
                    if (current[j] != in[pos + j])
                        successful = false;
                }

                if (! successful)
                    break;

                pos += current.length();
                cnt++;
            }

            if (successful && cnt > 2) {
                // found a string that fits; output.
                cout << cnt << endl;
                return;
            }
        }

    }

    cout << "Got nothing?  Is the input wrong?" << endl;
}