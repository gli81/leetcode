

#include <vector>
// #include <unordered_set> // need gnu++11
#include <set>
#include <iostream>

class LongestConsecutiveSequence {
public:
    int longestConsecutive(std::vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        std::set<int> s;
        for (size_t i = 0; i < nums.size(); ++i) {
            s.insert(nums[i]);
        }

        int maxx = 0;
        int tryIt = nums[0];
        int count = 0;
        for (size_t i = 0; i < nums.size(); ++i) {
            // make sure new start
            if (s.find(nums[i] - 1) == s.end()) {
                tryIt = nums[i];
                count = 0;
                while (s.find(tryIt) != s.end()) {
                    ++count;
                    ++tryIt;
                }
                maxx = std::max(maxx, count);
            }
        }
        return maxx;
    }
};

int main() {
    LongestConsecutiveSequence test;
    std::vector<int> nums;
    nums.push_back(100);
    nums.push_back(4);
    nums.push_back(200);
    nums.push_back(1);
    nums.push_back(3);
    nums.push_back(2);
    std::cout << test.longestConsecutive(nums) << std::endl;
    nums.clear();
    std::cout << nums.size() << std::endl;
    std::cout << test.longestConsecutive(nums) << std::endl;
}
