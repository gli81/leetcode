

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DesignTwitterJava {
    public Map<Integer, Set<Integer>> rel;
    public Map<Integer, List<int[]>> tweets;
    public int count;


    public DesignTwitterJava() {
        this.rel = new HashMap<>();
        this.tweets = new HashMap<>();
        this.count = 0;
    }


    public void postTweet(int userId, int tweetId) {
        if (!this.tweets.containsKey(userId)) {
            this.tweets.put(userId, new ArrayList<>());
        }
        this.tweets.get(userId).add(new int[] {this.count++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.valueOf(b[0]).compareTo(Integer.valueOf(a[0]))
        ); // max heap
        int last;
        if (this.tweets.containsKey(userId)) {
            last = this.tweets.get(userId).size() - 1;
            pq.add(
                new int[]{
                    this.tweets.get(userId).get(last)[0], // ct
                    this.tweets.get(userId).get(last)[1], // tweetId
                    userId,
                    last - 1 // index
                }
            );
        }
        // for each followee
        for (Integer followee : this.rel.getOrDefault(userId, new HashSet<>())) {
            if (this.tweets.containsKey(followee)) { // followee has tweets
                last = this.tweets.get(followee).size() - 1;
                pq.add(
                    new int[] {
                        this.tweets.get(followee).get(last)[0],
                        this.tweets.get(followee).get(last)[1],
                        followee,
                        last - 1
                    }
                );
            }
        }
        // build on ans
        while (!pq.isEmpty() && ans.size() < 10) {
            int[] next_ = pq.poll();
            ans.add(next_[1]);
            if (next_[3] >= 0) {
                pq.add(
                    new int[] {
                        this.tweets.get(next_[2]).get(next_[3])[0],
                        this.tweets.get(next_[2]).get(next_[3])[1],
                        next_[2], // followeeId
                        next_[3] - 1
                    }
                );
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!this.rel.containsKey(followerId)) {
            this.rel.put(followerId, new HashSet<>());
        }
        this.rel.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (this.rel.containsKey(followerId)) {
            if (this.rel.get(followerId).contains(followeeId)) {
                this.rel.get(followerId).remove(followeeId);
            }
        }
    }
}