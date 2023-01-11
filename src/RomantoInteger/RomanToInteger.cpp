package RomantoInteger;

#include <arrays>
#include <string>
#include <cctype>
#include <map>
#include <iostream>

using namespace std;
 class RomanToInteger {
    public:
     static int romanToInt(string s) {
        int value = 0;
        Map<Char, int> symbolValues;
        symbolValues['I'] = 1;
        symbolValues['V'] = 5;
        symbolValues['X'] = 10;
        symbolValues['L'] = 50;
        symbolValues['C'] = 100;
        symbolValues['D'] = 500;
        symbolValues['M'] = 1000;

        //convert the string to upper case
        for (int i = 0; i < s.size(); i++) {
           s[i] = toupper(s[i]);
        }

        //process input
        for (int i = 0; i < s.size(); i++) {
            char symbol = s.charAt(i);
            switch (symbol) {
                case 'I':
                    if (i + 1 != s.size() && (s[i + 1] == 'V' || s[i + 1] == 'X')) {
                        value += symbolValues[s[i + 1]] - 1;
                        i++;
                    } else {
                        value += symbolValues[symbol];
                    }
                    break;
                case 'X':
                    if (i + 1 != s.size() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                        value += symbolValues[s[i + 1]] - symbolValues[symbol];
                        i++;
                    } else {
                        value += symbolValues[symbol];
                    }
                    break;
                case 'C':
                    if (i + 1 != s.size() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                        value += symbolValues[s[i + 1]] - symbolValues[symbol];
                        i++;
                    } else {
                        value += symbolValues[symbol];
                    }
                    break;
                case 'V':
                case 'L':
                case 'D':
                case 'M':
                    value += symbolValues[symbol];
                    break;
                default:
                    break;
            }
        }
        return value;
    }


    int main(String[] args) {
        cout << romanToInt("CDD"));
        return 0;
    }

}

