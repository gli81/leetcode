

#include <queue>

class FindMedianfromDataStream {
public:
    std::priority_queue<int> smallHeap;
    std::priority_queue<int> largeHeap;
}