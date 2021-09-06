//
// Created by sturt on 7/30/2021.
//

#include <iostream>
#include <vector>
#include <string>

using std::cin, std::cout, std::vector, std::endl, std::string, std::getline;

struct Instruction {
    char operation;
    int number;
};

void mathInstructions() {
    int N;
    cin >> N;

    // flush buffer
    string line;
    getline(cin, line);

    vector<Instruction> instructions;

    for (int i = 0; i < N; ++i) {
        string line;
        getline(cin, line);

        // get first character of input line
        char c = line[0];

        // depending on what the letter (operation) is, get the substring that is an integer.
        int num = 0;
        switch(c) {
            case 'A': // addition
                num = std::stoi(line.substr(4));
                break;
            case 'S': // subtraction
                num = std::stoi(line.substr(9));
                break;
            case 'M': // multiplication
                num = std::stoi(line.substr(12));
                break;
            case 'D': // division
                num = std::stoi(line.substr(10));
                break;
        }

        // create instance of Instruction with initialized values
        Instruction inst{c, num};

        // add instance to vector
        instructions.push_back(inst);
    }

    int T;
    cin >> T;

    for (int i = 0; i < T; ++i) {
        int value;
        cin >> value;

        // go through every instruction
        for (int j = 0; j < N; ++j) {
            // get current instruction
            Instruction inst = instructions[j];

            // follow instruction
            switch(inst.operation) {
                case 'A': // addition
                    value += inst.number; break;
                case 'S': // addition
                    value -= inst.number; break;
                case 'M': // addition
                    value *= inst.number; break;
                case 'D': // addition
                    value /= inst.number; break;
            }
        }

        cout << value << "\n";
    }
}