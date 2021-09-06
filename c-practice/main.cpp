#include <iostream>
#include <string>

using std::string, std::cout, std::cin, std::endl;

string getName(int id);

void letsSortThisOut();
void badAddition();
void whatdIMiss();
void portals();
void mathInstructions();
void permutative();
void ngon();
void guessCounter();
void chainReaction();
void hugeNumbers();
void prefix();
void gcdAndLcm();
void graniteRock();

int main() {
    cout << "Welcome to the Sample Contest Problems Interface!\n";
    cout << "Read the Contest Problems PDF in the source code for problem details.\n";
    cout << "===\n===\n===" << endl;

    string input;

    while (true) {

        cout << R"(Give a number corresponding to the problem to run, "q" to quit, or "i" for info!)" << endl;

        cin >> input;

        if (cin.bad() || cin.eof() || cin.fail()) {
            cout << "Encountered a terrible issue reading input; ending program." << endl;
        }
        if (input == "q")
            break;
        else if (input == "i") {
            cout << "Problem Names:\n";
            for (int i = 1; i <= 20; ++i)
                cout << getName(i) << "\n";
            cout << endl;
            continue;
        }

        int selected;

        try {
            selected = std::stoi(input);
        } catch (std::exception& e) {
            cout << "Error; did you not give a number?" << endl;
            continue;
        }
        if (selected < 1 || selected > 20) {
            cout << "Enter a valid number!" << endl;
            continue;
        }

        // flush the buffer
        std::string temp;
        std::getline(cin, temp);


        cout << "Give input for " + getName(selected) << endl;
        switch(selected) {
            case 1:
                letsSortThisOut(); break;
            case 2:
                badAddition(); break;
            case 3:
                whatdIMiss(); break;
            case 4:
                portals(); break;
            case 5:
                mathInstructions(); break;
            case 6:
                permutative(); break;
            case 7:
                ngon(); break;
            case 8:
                guessCounter(); break;
            case 9:
                chainReaction(); break;
            case 10:
                hugeNumbers(); break;
            case 11:
                prefix(); break;
            case 12:
                gcdAndLcm(); break;
            case 15:
                graniteRock(); break;
        }

        cout << endl << endl;
    }

    cout << "Goodbye! :D" << endl;
    return 0;
}

string getName(int id) {
    switch(id) {
        case 1: return "01 - Let's Sort this Out";
        case 2: return "02 - Bad Addition";
        case 3: return "03 - What'd I Miss?";
        case 4: return "04 - Portals";
        case 5: return "05 - Math Instructions";
        case 6: return "06 - Permutative Yet Duplicative";
        case 7: return "07 - Ngon";
        case 8: return "08 - Guess Counter";
        case 9: return "09 - Chain Reaction";
        case 10: return "10 - Extreme Values";
        case 11: return "11 - Prefix Solver";
        case 12: return "12 - GCD and LCM";
        case 13: return "13 - Spin Cycle";
        case 14: return "14 - Non-Random Explosion";
        case 15: return "15 - Granite Rock";
        case 16: return "16 - Flip";
        case 17: return "17 - Tree Dating!";
        case 18: return "18 - Walk in the Park";
        case 19: return "19 - Magnetic Field";
        case 20: return "20 - Radiant Pearl";
        default: return "Unknown Problem.";
    }
}
