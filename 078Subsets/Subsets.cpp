

#include <vector>
#include <iostream>
#include <cstdlib>

class Subsets {
public:
    std::vector<std::vector<int> > subsets(std::vector<int>& nums) {
        std::vector<std::vector<int> > ans;
        std::vector<int> cur;
        this->subsetHelper(nums, cur, ans, 0);
        return ans;
    }

private:
    void subsetHelper(
        std::vector<int>& nums,
        std::vector<int>& cur,
        std::vector<std::vector<int> >& ans,
        int idx
    ) {
        ans.push_back(cur); // assume push_back copies the vector
        for (size_t i = idx; i < nums.size(); ++i) {
            cur.push_back(nums[i]);
            this->subsetHelper(nums, cur, ans, i + 1);
            cur.pop_back();
        }
    }
};


int main(void) {
    Subsets test;
    std::vector<int> test1;
    test1.push_back(1);
    test1.push_back(2);
    test1.push_back(3);
    std::vector<std::vector<int> > rslt1 = test.subsets(test1);
    std::cout << "[";
    for (size_t i = 0; i < rslt1.size(); ++i) {
        std::cout << "[";
        for (size_t j = 0; j < rslt1[i].size(); ++j) {
            std::cout << rslt1[i][j];
            if (j != rslt1[i].size() - 1) {
                std::cout << ",";
            }
        }
        std::cout << "]";
    }
    std ::cout << "]" << std::endl;
}
