

#include <vector>
#include <string>
#include <iostream>
using std::vector;
using std::string;

class NQueens {
public:
    vector<vector<string> > solveNQueens(int n) {
        vector<vector<string> > ans;
        vector<size_t> cur;
        nQueensHelper(n, ans, cur);
        return ans;
    }

private:
    void nQueensHelper(
        int n, vector<vector<string> >& ans, vector<size_t>& pos)//, size_t y
     {
        for (size_t i = 0; i < (size_t)n; ++i) {
            if (isValid(pos, i)) {
                pos.push_back(i);
                if (pos.size() == (size_t)n) {
                    // add to ans
                    // construct a list of list of strings
                    vector<string> tmp((size_t)n, string(n, '.'));
                    for (size_t j = 0; j < (size_t)n; ++j) {
                        tmp[j][pos[j]] = 'Q';
                    }
                    ans.push_back(tmp);
                    pos.pop_back();
                    return;
                }
                nQueensHelper(n, ans, pos);//, pos.length + 1);
                pos.pop_back();
            }
        }
    }

    bool isValid(vector<size_t>& pos, size_t x) {
        size_t n = pos.size();
        // std::cout << "inside isValid\t";
        // for (size_t i = 0; i < n; ++i) {
            // std::cout << pos[i];
            // if (i != n - 1) {std::cout << ", ";}
        // }
        // std::cout << "; " << x;
        for (size_t i = 0; i < n; ++i) {
            if (pos[i] == x) {
                // std::cout << "\tnot valid" << std::endl;
			    return false;
            }
            if (pos[i] == x + n - i) {
                // std::cout << "\tnot valid" << std::endl;
                return false;
            }
            if (x - n + i >= 0 && pos[i] == x - n + i) {
                // std::cout << "\tnot valid" << std::endl;
                return false;
            }
        }
        // std::cout << "\tVALID" << std::endl;
        return true;
    }
};


int main() {
    NQueens test;
    vector<vector<string> > rslt1 =  test.solveNQueens(3);
    for (size_t i = 0; i < rslt1.size(); ++i) {
        std::cout << "[";
        for (size_t j = 0; j < rslt1[i].size(); ++j) {
            std::cout << rslt1[i][j];
        }
        std::cout << "]";
        if (i != rslt1.size() - 1) {
            std::cout << ", ";
        }
    }
    std::cout << std::endl;
    // std::cout << "SSSSS";
    vector<vector<string> > rslt2 = test.solveNQueens(4);
    for (size_t i = 0; i < rslt2.size(); ++i) {
        std::cout << "[";
        for (size_t j = 0; j < rslt2[i].size(); ++j) {
            std::cout << rslt2[i][j];
            if (j != rslt2[i].size() - 1) std::cout << ", ";
        }
        std::cout << "]";
        if (i != rslt2.size() - 1) {
            std::cout << " ";
        }
    }
    std::cout << std::endl;
}
