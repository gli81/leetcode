# -*- coding: utf-8 -*-

from typing import List

class CarFleet:
    def carFleet(
        self, target: "int", position: "List[int]",
        speed: "List[int]"
    ) -> "int":
        ## sort position and speed
        ## in reverse order of position
        cars = [(k, v) for k, v in zip(position, speed)]
        cars.sort(key=lambda x:x[0], reverse=True)
        # cur = 0
        cur_arrive = 0
        ans = 0
        for i in range(0, len(cars)):
            # print(cars[i])
            arrive = (target - cars[i][0]) / cars[i][1]
            if arrive > cur_arrive:
                cur_arrive = arrive
                # cur = i
                ans += 1
            # print(cur_arrive, cur, ans)
        return ans


def main():
    test = CarFleet()
    print(test.carFleet(
        10, [1, 4], [3, 2]
    ))
    print(test.carFleet(
        10, [4, 1, 0, 7], [2, 2, 1, 1]
    ))

if __name__ == "__main__":
    main()
