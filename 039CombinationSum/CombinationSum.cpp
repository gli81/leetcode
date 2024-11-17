

#include<vector>

class CombinationSum {
public:
    std::vector<std::vector<int> > combinationSum(
        std::vector<int>& candidates, int target
    ) {
        std::vector<std::vector<int> > ans;
        std::vector<int> cur;
        this->combSumHelper(candidates, target, ans, cur, 0);
        return ans;
    }

private:
    void combSumHelper(
        std::vector<int>& nums,
        int target,
        std::vector<std::vector<int> >& ans,
        std::vector<int>& cur,
        int idx
    ) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.push_back(cur);
            return;
        }
        for (int i = idx; i < nums.size(); ++i) {
            cur.push_back(nums[i]);
            this->combSumHelper(nums, target - nums[i], ans, cur, i);
            cur.pop_back();
        }
    }
};