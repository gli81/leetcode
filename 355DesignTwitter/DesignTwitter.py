# -*- coding: utf-8 -*-

from typing import List

class Twitter:
    def __init__(self):
        pass

    def postTweet(
        self,
        userId: "int",
        tweetId: "int"    
    ) -> "None":
        pass

    def getNewsFeed(
        self,
        userId: "int"
    ) -> "List[int]":
        pass

    def follow(
        self,
        followerId: "int",
        followeeId: "int"
    ) -> "None":
        pass

    def unfollow(
        self,
        followerId: "int",
        followeeId: "int"
    ) -> "None":
        pass


def main():
    test = Twitter()

if __name__ == "__main__":
    main()
