# -*- coding: utf-8 -*-

from typing import List, Dict, Set, Tuple
import heapq

class Twitter:
    def __init__(self):
        self.rel: "Dict[int, Set[int]]" = {}
        self.tweets: "Dict[int, List[Tuple[int,int]]]" = {}
        self.count = 0


    def postTweet(
        self,
        userId: "int",
        tweetId: "int"    
    ) -> "None":
        if userId not in self.tweets:
            self.tweets[userId] = []
        self.tweets[userId].append((self.count, tweetId))
        self.count -= 1

    def getNewsFeed(
        self,
        userId: "int"
    ) -> "List[int]":
        ans = []
        minHeap = []
        ## append user's own tweets into minHeap, if any
        if userId in self.tweets:
            last = len(self.tweets[userId]) - 1
            ct, tweetId = self.tweets[userId][last]
            minHeap.append((ct, tweetId, userId, last - 1))
        for followee in self.rel.get(userId, set()):
            if followee in self.tweets:
                ## push each followee's last tweet into minHeap
                last = len(self.tweets[followee]) - 1
                ct, tweetId = self.tweets[followee][last]
                minHeap.append((ct, tweetId, followee, last - 1))
        heapq.heapify(minHeap)
        while minHeap and len(ans) < 10:
            ct, tweetId, followee, next_ = heapq.heappop(minHeap)
            ans.append(tweetId)
            if next_ >= 0: ## this followee has more tweets
                heapq.heappush(
                    minHeap,
                    (
                        self.tweets[followee][next_][0],
                        self.tweets[followee][next_][1],
                        followee,
                        next_ - 1
                    )
                )
        return ans

    def follow(
        self,
        followerId: "int",
        followeeId: "int"
    ) -> "None":
        if followerId not in self.rel:
            self.rel[followerId] = set()
        self.rel[followerId].add(followeeId)

    def unfollow(
        self,
        followerId: "int",
        followeeId: "int"
    ) -> "None":
        if followerId not in self.rel:
            return
        if followeeId in self.rel[followerId]:
            self.rel[followerId].remove(followeeId)


def main():
    test = Twitter()

if __name__ == "__main__":
    main()
