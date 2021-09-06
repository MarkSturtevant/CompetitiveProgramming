//
// Created by sturt on 8/4/2021.
//
#include <iostream>

using std::cout, std::cin, std::endl, std::string;

int BASE = 10;

unsigned int digit_to_decimal(char digit) {

    int val = ((digit >= 'a') ? (digit - 'a' + 10) : (digit - '0'));
    if (val >= BASE || val < 0)
        throw std::invalid_argument("digit not in the provided based");
    return val;
}

char decimal_to_digit(unsigned int decimal) {
    unsigned int base = BASE;
    if (decimal >= base)
        throw std::invalid_argument("digit not in the provided base");
    return static_cast<char>((decimal < 10) ? (decimal + '0') : (decimal + 'a' - 10));
}

string trim_leading_zeros(string num) {
    bool negative = num.at(0) == '-';
    if (negative)
        num = num.substr(1, num.length());
    while(num.find("0") == 0 && num.length() > 1)
        num = num.substr(1, num.length());
    if (negative)
        num = "-" + num;
    if (num == "-0")
        return "0";
    return num;
}

string add_leading_zeroes(string shorter, string longer) {
    while (shorter.length() < longer.length())
        shorter = "0" + shorter;
    return shorter;
}

string add(string lhs, string rhs);

string subtract(string lhs, string rhs) {
    // handle negatives
    if (lhs.at(0) == '-') {
        lhs = lhs.substr(1, lhs.length());
        if (rhs.at(0) == '-') { // lhs neg, rhs neg
            rhs = rhs.substr(1, rhs.length());
            string output = subtract(lhs, rhs);
            return output.at(0) == '-' ? output.substr(1, output.length()) : ("-" + output);
        }
        else // lhs neg, rhs NOT neg
            return "-" + add(lhs, rhs);
    }
    else if (rhs.at(0) == '-') { // lhs NOT neg, rhs neg
        rhs = rhs.substr(1, rhs.length());
        return add(lhs, rhs);
    }

    // add leading zeroes
    if (lhs.length() < rhs.length())
        lhs = add_leading_zeroes(lhs, rhs);
    else rhs = add_leading_zeroes(rhs, lhs);

    // subtract
    int carryOver = 0;
    string result = "";
    for (int i = lhs.size() - 1; i >= 0; --i) {
        int sum = digit_to_decimal(lhs.at(i)) - digit_to_decimal(rhs.at(i)) + carryOver;
        carryOver = (sum - BASE + 1) / BASE;
        int digToAdd = sum % BASE + (sum < 0 && sum % BASE != 0 ? BASE : 0);
        result = decimal_to_digit(digToAdd) + result;
    }

    // account for negative result
    if (carryOver != 0) {
        string big = "1";
        int length = lhs.length();
        for (int i = 0; i < length; ++i)
            big.push_back('0');
        result = "-" + subtract(big, result);
    }

    return trim_leading_zeros(result);
}

string add(string lhs, string rhs) {
    // handle negatives
    if (lhs.at(0) == '-') {
        lhs = lhs.substr(1, lhs.length());
        if (rhs.at(0) == '-') { // lhs neg, rhs neg
            rhs = rhs.substr(1, rhs.length());
            return "-" + add(lhs, rhs);
        }
        else // lhs neg, rhs NOT neg
            return subtract(rhs, lhs);
    }
    else if (rhs.at(0) == '-') { // lhs NOT neg, rhs neg
        rhs = rhs.substr(1, rhs.length());
        return subtract(lhs, rhs);
    }

    // add leading zeroes
    if (lhs.length() < rhs.length())
        lhs = add_leading_zeroes(lhs, rhs);
    else rhs = add_leading_zeroes(rhs, lhs);

    // add
    int carryOver = 0;
    string result = "";
    for (int i = lhs.size() - 1; i >= 0; --i) {
        int sum = digit_to_decimal(lhs.at(i)) + digit_to_decimal(rhs.at(i)) + carryOver;
        carryOver = sum / BASE;
        result = decimal_to_digit(sum % BASE) + result;
    }
    if (carryOver != 0)
        result = decimal_to_digit(carryOver) + result;

    return result;
}

string multiply(string lhs, string rhs) {
    // remove negatives and count the number of operands that were negative.
    int negCount = 0;
    if (lhs.at(0) == '-')
    {++negCount; lhs = lhs.substr(1, lhs.length());}
    if (rhs.at(0) == '-')
    {++negCount; rhs = rhs.substr(1, rhs.length());}

    // perform multiplication
    string result = "0";
    for (int i = lhs.length() - 1; i >= 0; --i) {
        string miniResult = "";
        int carryOver = 0;
        for (int j = rhs.length() - 1; j >= 0; --j) {
            int sum = digit_to_decimal(lhs.at(i)) * digit_to_decimal(rhs.at(j)) + carryOver;
            carryOver = sum / BASE;
            miniResult = decimal_to_digit(sum % BASE) + miniResult;
        }
        if (carryOver != 0)
            miniResult = decimal_to_digit(carryOver) + miniResult;
        for (int j = lhs.length() - 1; j > i; --j)
            miniResult += "0";

        result = add(result, miniResult);
    }

    // add negative sign if applicable
    if (negCount == 1)
        result = "-" + result;

    return result;
}

void hugeNumbers() {
    string a, b;
    char which;
    int N;
    cin >> N;
    for (int i = 0; i < N; ++i) {
        cin >> which >> a >> b;
        cout << (which == 'A' ? add(a, b) : multiply(a, b)) << "\n";
    }
    cout << endl;
}

