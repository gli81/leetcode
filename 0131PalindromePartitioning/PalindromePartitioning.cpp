

#include <vector>
#include <string>
#include <cstdlib>

class PalindromePartitioning {
public:
    std::vector<std::vector<std::string> > partition3(std::string s) {
        std::vector<std::vector<std::string> > ans;
        std::vector<std::string> cur;
        partitionHelper(s, ans, cur, 0);
        return ans;
    }

private:
    void partitionHelper(
        std::string& s,
        std::vector<std::vector<std::string> >& ans,
        std::vector<std::string>& cur,
        size_t idx
    ) {
        if (idx >= s.size()) {
            // all letters checked
            ans.push_back(cur);
            return;
        }
        for (size_t i = idx; i < s.size(); ++i) {
            if (isPalindrome(s.substr(idx, i - idx + 1))) {
                cur.push_back(s.substr(idx, i - idx + 1));
                partitionHelper(s, ans, cur, i + 1);
                cur.pop_back();
            }
        }
    }

    bool isPalindrome(std::string s) {
        size_t l, r;
        l = 0;
        r = s.size() - 1;
        while (l < r) {
            if (s[l++] != s[r--]) return false;
        }
        return true;
    }
};


int main() {
    return EXIT_SUCCESS;
}
