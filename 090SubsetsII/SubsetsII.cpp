

#include <vector>
#include <algorithm>
#include <iostream>
#include <cstdlib>

class SubsetsII {
public:
    std::vector<std::vector<int> > subsetsWithDup(std::vector<int>& nums) {
        std::sort(nums.begin(), nums.end());
        // for (size_t i = 0; i < nums.size(); ++i) {
        //     std::cout << nums[i] << std::endl;
        // }
        std::vector<std::vector<int> > ans;
        std::vector<int> cur;
        subsets_helper(nums, ans, cur, 0);
        return ans;
    }
private:
    void subsets_helper(
        std::vector<int>& nums,
        std::vector<std::vector<int> >& ans,
        std::vector<int>& cur,
        int idx
    ) {
        ans.push_back(cur);
        for (size_t i = (size_t)idx; i < nums.size(); ++i) {
            // if (i > 0 && nums[i] == nums[i - 1]) {
            // > idx not > 0
            // bc being the first after last append can lead to new perm
            if (i > (size_t)idx && nums[i] == nums[i - 1]) {
                continue;
            } else {
                cur.push_back(nums[i]);
                subsets_helper(nums, ans, cur, i + 1);
                cur.pop_back();
            }
        }
    }
};


int main(void) {
    SubsetsII test;
    std::vector<int> test1;
    test1.push_back(1);
    test1.push_back(2);
    test1.push_back(2);
    std::vector<std::vector<int> > rslt1 = test.subsetsWithDup(test1);
    std::cout << "[";
    for (size_t i = 0; i < rslt1.size(); ++i) {
        std::cout << "[";
        for (size_t j = 0; j < rslt1[i].size(); ++j) {
            std::cout << rslt1[i][j];
            if (j != rslt1[i].size() - 1) {
                std::cout << ", ";
            }
        }
        std::cout << "]";
        if (i != rslt1.size() - 1) std::cout << ", ";
        
    }
    std::cout << "]" << std::endl;
    return EXIT_SUCCESS;
}