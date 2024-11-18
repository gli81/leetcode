

#include <vector>
#include <algorithm>

class Permutations {
public:
    std::vector<std::vector<int> > permute2(std::vector<int>& nums) {
        std::vector<std::vector<int> > ans;
        std::vector<int> cur;
        perm2Helper(nums, ans, cur);
        return ans;
    }
private:
    void perm2Helper(
        std::vector<int>& nums,
        std::vector<std::vector<int> >& ans,
        std::vector<int>& cur
    ) {
        if (nums.size() == cur.size()) {
            ans.push_back(cur);
            return;
        }
        for (size_t i = 0; i < nums.size(); ++i) {
            if (std::find(cur.begin(), cur.end(), nums[i]) != cur.end()) {
                continue;
            }
            cur.push_back(nums[i]);
            perm2Helper(nums, ans, cur);
            cur.pop_back();
        }
    }
};