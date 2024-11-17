

#include <queue>
#include <vector>
#include <cstdlib>

class FindMedianfromDataStream {
private:
    std::priority_queue<int> smallHeap;
    // min heap
    std::priority_queue<int, std::vector<int>, std::greater<int> > largeHeap;
public:
    FindMedianfromDataStream() {}


    void addNum(int num) {
        if (!smallHeap.empty() && num > smallHeap.top()) {
            largeHeap.push(num);
        } else {
            smallHeap.push(num);
        }
        while (smallHeap.size() > largeHeap.size() + 1) {
            largeHeap.push(smallHeap.top());
            smallHeap.pop(); // pop returns void
        }
        while (largeHeap.size() > smallHeap.size()) {
            smallHeap.push(largeHeap.top());
            largeHeap.pop();
        }
    }

    double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (smallHeap.top() + largeHeap.top()) / 2.0;
        } else {
            return smallHeap.top();
        }
    }
};


int main() {
    return EXIT_SUCCESS;
}