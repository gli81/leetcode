#include <vector>
#include <ostream>

class DiagonalTraverse {
public:
    std::vector<int> findDiagonalOrder(std::vector<std::vector<int> >& mat) {
        size_t m, n;
        m = mat.size();
        n = mat[0].size();
        std::vector<int> ans(m*n);
        int ct = 0;
        for (size_t i = 0; i < m+n-1; ++i) {
            int min_, x, y;
            if (i % 2 == 0) {
                min_ = std::min(i, m-1);
                x = min_;
                y = i-min_;
                while (x >= 0 && y < n) {
                    ans[ct++] = mat[x--][y++];
                }
            } else {
                min_ = std::min(i, n-1);
                x = i-min_;
                y = min_;
                while (x < m && y >= 0) {
                    ans[ct++] = mat[x++][y--];
                }
            }
        }
        return ans;
    }
};