

#include <vector>
using std::vector;
#include <map>
using std::map;
#include <queue>
using std::queue;
using std::size_t;
#include <iostream>

class CouseSchedule {
public:
    vector<int> findOrder1(int numCourses, vector<vector<int> >& prerequisites) {
        // topological sort
        vector<size_t> indeg(numCourses, 0);
        map<size_t, vector<size_t> > edges;
        for (size_t i = 0; i < prerequisites.size(); ++i) {
            size_t course = (size_t)prerequisites[i][0];
            size_t prereq = (size_t)prerequisites[i][1];
            indeg[course]++;
            // C++03 map operator[] will create default for the key
            // if key not found
            edges[prereq].push_back(course);
        }
        queue<size_t> q;
        for (size_t i = 0; i < (size_t)numCourses; ++i) {
            if (indeg[i] == 0) {
                q.push(i);
            }
        }
        size_t visited = 0;
        vector<int> ans(numCourses);
        while (!q.empty()) {
            size_t cur = q.front(); q.pop();
            ans[visited++] = (int)cur;
            // ++visited;
            for (size_t i = 0; i < edges[cur].size(); ++i) {
                if (--indeg[edges[cur][i]] == 0) {
                    q.push(edges[cur][i]);
                }
            }
        }
        return visited == (size_t)numCourses ? ans : vector<int>();
    }
};


int main() {
    std::cout << "Compile successfully" << std::endl;
    return 0;
}
