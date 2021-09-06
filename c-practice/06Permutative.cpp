//
// Created by sturt on 7/30/2021.
//

#include <iostream>
#include <unordered_set>
#include <string>

using std::unordered_set, std::cin, std::cout, std::endl, std::string, std::getline;


void permutativeRecursion(int index, int wordLength, string& word, unordered_set<string>& set) {
    if (index == wordLength-1) {
        set.insert(word);
        return;
    }
    permutativeRecursion(index+1, wordLength, word, set);
    for (int j = index+1; j < wordLength; ++j) {
        std::swap(word[index], word[j]);
        permutativeRecursion(index+1, wordLength, word, set);
        std::swap(word[index], word[j]);
    }
}

void permutative() {
    string word;
    getline(cin, word);

    unordered_set<string> perms;

    permutativeRecursion(0, word.length(), word, perms);

    cout << perms.size() << endl;
}

