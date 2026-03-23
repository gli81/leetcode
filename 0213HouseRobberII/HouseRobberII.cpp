

#include <vector>
#include <cstdlib>
#include <iostream>

class HouseRobberII {
public:
    int rob(std::vector<int>& nums) {
        return std::max(
            robHelper(nums, 0, nums.size() - 1),
            robHelper(nums, 1, nums.size())
        );
    }

private:
    int robHelper(
        std::vector<int>& nums, std::size_t start, std::size_t end
    ) {
        int len = end - start;
        if (len == -1) return 0;
        if (len == 0) return nums[0];
        if (len == 1) return nums[start];
        std::vector<int> dp(len, 0);
        dp[0] = nums[start];
        dp[1] = std::max(dp[0], nums[start + 1]);
        for (std::size_t i = 2; i < (std::size_t)len; ++i) {
            dp[i] = std::max(
                dp[i - 2] + nums[i + start], dp[i - 1]
            );
        }
        return dp[len - 1];
        // std::vector<int> dp;
        // dp.push_back(nums[start]);
        // dp.push_back(std::max(dp[0], nums[start + 1]));
        // for (std::size_t i = 2; i < (std::size_t)len; ++i) {
        //     dp.push_back(std::max(dp[i - 2] + nums[i + start], dp[i - 1]));
        // }
        // return dp[len - 1];
    }
};


int main(void) {
    HouseRobberII test;
    std::vector<int> test1;
    test1.push_back(1);
    test1.push_back(2);
    test1.push_back(1);
    test1.push_back(1);
    std::cout << test.rob(test1) << std::endl;
    // std::cout << "aaa" << std::endl;
    return EXIT_SUCCESS;
}
