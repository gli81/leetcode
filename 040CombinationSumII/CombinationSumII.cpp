

#include <vector>
#include <algorithm>

class CombinationSumII {
public:
    std::vector<std::vector<int> > combinationSum2(
        std::vector<int>& candidates,
        int target
    ) {
        std::sort(candidates.begin(), candidates.end());
        std::vector<std::vector<int> > ans;
        std::vector<int> cur;
        combSum2Helper(candidates, target, ans, cur, 0);
        return ans;
    }
private:
    void combSum2Helper(
        std::vector<int>& candidates,
        int target,
        std::vector<std::vector<int> >& ans,
        std::vector<int> cur,
        size_t idx
    ) {
        if (target == 0) {
            ans.push_back(cur);
            return;
        }
        if (target < 0) {
            return;
        }
        for (size_t i = idx; i < candidates.size(); ++i) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            cur.push_back(candidates[i]);
            combSum2Helper(candidates, target - candidates[i], ans, cur, i + 1);
            cur.pop_back();
        }
    }
};


int main(void) {
    return 0;
}