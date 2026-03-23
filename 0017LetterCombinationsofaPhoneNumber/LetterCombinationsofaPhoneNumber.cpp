

#include <vector>
#include <string>

class LetterCombinationsofaPhoneNumber {
public:
    std::vector<std::string> letterCombinations(std::string digits) {
        std::vector<std::string> ans;
        if (digits.size() == 0) return ans;
        combHelper(digits, ans, "", 0);
        return ans;
    }

private:
    void combHelper(
        std::string& digits,
        std::vector<std::string>& ans,
        std::string pre,
        size_t len
    ) {
        if (digits.length() == len) {
            ans.push_back(pre);
            return;
        }
        std::string KEYS[10] = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        std::string letters = KEYS[digits[len] - '0'];
        for (size_t i = 0; i < letters.length(); ++i) {
            combHelper(
                digits, ans, pre.append(std::string(1, letters[i])), len + 1
            );
            pre.pop_back();
        }
    }
};
