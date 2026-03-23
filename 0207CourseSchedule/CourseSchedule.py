# -*- coding: utf-8 -*-

from typing import List

class CourseSchedule:
    def canFinish(
        self,
        numCourses: "int",
        prerequisites: "List[List[int]]"
    ) -> "bool":
        edges = {} ## 记录出边
        ## 后续添加一节课到拓扑排序中时，把它lead to的后续课程的prereq数量都减1
        indeg = [0] * numCourses
        for info in prerequisites:
            ## to take prereq[i][0] you need to finish prereq[i][1]
            indeg[info[0]] += 1 ## info[0]'s prerequisite += 1
            tmp = edges.get(info[1], [])
            tmp.append(info[0])
            edges[info[1]] = tmp
        # print(indeg)
        # print(edges)
        # q = []
        # for _ in range(len(indeg)):
        #     if not indeg[_]:
        #         q.append(_)
        q = [_ for _ in range(len(indeg)) if not indeg[_]]
        visited = 0
        # print(q)
        while q:
            cur = q.pop(0)
            visited += 1
            for course in edges.get(cur, []):
                indeg[course] -= 1
                if not indeg[course]:
                    q.append(course)
        return visited == numCourses


def main():
    test = CourseSchedule()
    print(test.canFinish(
        2, [[1, 0]]
    ))
    print(test.canFinish(
        2, [[1, 0], [0, 1]]
    ))

if __name__ == "__main__":
    main()
