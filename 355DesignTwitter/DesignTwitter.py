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
        self.tweets[userId].append((self.count, tweetId))
        self.count -= 1

    def getNewsFeed(
        self,
        userId: "int"
    ) -> "List[int]":
        """
        Merge K Sorted Lists
        """
        pass

    def follow(
        self,
        followerId: "int",
        followeeId: "int"
    ) -> "None":
        self.rel[followerId].add(followeeId)

    def unfollow(
        self,
        followerId: "int",
        followeeId: "int"
    ) -> "None":
        self.rel[followerId].remove(followeeId)


def main():
    test = Twitter()

if __name__ == "__main__":
    main()
