

#include <cstdlib>
#include <vector>
#include <map>
#include <queue>
using std::vector;
using std::map;
using std::queue;

class Node {
public:
    int val;
    vector<Node*> neighbors;


    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }

    Node (int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }

    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};


class CloneGraph {
public:
    Node* cloneGraph1(Node* node) {
        // bfs
        if (NULL == node) return NULL;
        map<int, Node*> visited;
        visited[node->val] = new Node(node->val);
        queue<Node*> q;
        q.push(node);
        while (!q.empty()) {
            Node* cur = q.front(); q.pop();
            for (size_t i = 0; i < cur->neighbors.size(); ++i) {
                int k = cur->neighbors[i]->val;
                if (visited.find(k) == visited.end()) { // can't find
                    visited[k] = new Node(k);
                    q.push(cur->neighbors[i]);
                }
                visited[cur->val]->neighbors.push_back(visited[k]);
            }
        }
        return visited[node->val];
    }

    Node* cloneGraph2(Node* node) {
        // implement rule of three
        return node;
    }
};
