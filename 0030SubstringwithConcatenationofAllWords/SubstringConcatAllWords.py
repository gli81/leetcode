# -*- coding: utf-8 -*-

from typing import List

class SubstringwithConcatenationofAllWords:
    def findSubstring2(self, s: "str", words: "List[str]") -> "List[int]":
        '''
        由于Python的for循环range对象的机制, 不能在方法体里修改迭代变量
        '''
        if len(words) == 0: return []
        ans: list[int] = []
        wordLen = len(words[0])
        allWords: dict[str] = {}
        ## put every word in words into dictionary, with their occurances
        for word in words:
            allWords[word] = allWords.get(word, 0) + 1

        ## debug print
        print(allWords)
        print("=" * 30)

        ## 从第一个单词的每一个字母都开始一次遍历, 每次跳字母长度
        ## 比如三个字母的词
        ##      从[0, 3, 6, 9, ...]开始子串
        ##      从[1, 4, 7, 10, ...]开始子串,
        ##      从[2, 5, 8, 11, ...]开始字串
        ## for the first wordLen letters, starting traverse at each letter
        for i in range(wordLen):
            hasWords: dict[str] = {}
            wordCt: int = 0 ## how many words in hasWords

            ## traverse, step by wordLen
            ## last to start a substring
            j = i
            while j < len(s) - len(words) * wordLen + 1:
            # for j in range(i, len(s) - len(words) * wordLen + 1, wordLen):
                ## debug print
                print(j)
                # hasRemoved = False
                while wordCt < len(words):
                    currentWord = s[
                        j + wordCt * wordLen :
                        j + (wordCt + 1) * wordLen
                    ]
                    ## debug print
                    # print(currentWord)
                    if currentWord not in allWords:
                        ## go to the word after the not in allWords word
                        ## before actually, the for loop will move wordLen again
                        j = j + wordCt * wordLen
                        ## clear the dict
                        hasWords.clear()
                        wordCt = 0
                        break
                    else:
                        hasWords[currentWord] = hasWords.get(currentWord, 0) + 1
                        # wordCt += 1
                        if hasWords[currentWord] > allWords[currentWord]:
                            # hasRemoved = True
                            ## remove words until
                            ## only correct number of that word in the string
                            removed: int = 0
                            while hasWords[currentWord] > allWords[currentWord]:
                                headWord = s[
                                    j + removed * wordLen :
                                    j + (removed + 1) * wordLen
                                ]
                                hasWords[headWord] -= 1
                                removed += 1
                            wordCt = wordCt - removed + 1
                            ## move j to
                            ## the starting letter of last removed word
                            ## for loop will move j to the next word
                            j = j + (removed - 1) * wordLen
                            break
                    wordCt += 1
        #             print(hasWords)
        #             print("-" * 30)

                # wordCt = 0
                ## if not reset wordCt here, reset in separate cases

                ## debug print
                # print("-" * 30)
                if wordCt == len(words):
                    if j not in ans:
                        ans.append(j)
                # if wordCt > 0 and not hasRemoved:
                    firstWord: str = s[j: j + wordLen]
                    hasWords[firstWord] -= 1
                    wordCt -= 1
                j += wordLen
        return ans

    def findSubstring1(self, s: str, words: list[str]) -> list[int]:
        if len(words) == 0: return []
        ans: list[int] = []
        wordLen = len(words[0])
        allWords: dict[str] = {}
        ## put every word in words into dictionary, with their occurances
        for word in words:
            allWords[word] = allWords.get(word, 0) + 1

        ## debug print
        # print(allWords)
        # print("=" * 30)

        for i in range(len(s) - len(words) * wordLen + 1):
            hasWords: dict[str] = {}
            wordCt = 0
            while wordCt < len(words):
                currentWord = s[
                    i + wordCt * wordLen :
                    i + (wordCt + 1) * wordLen
                ]
                if currentWord in allWords:
                    hasWords[currentWord] = hasWords.get(currentWord, 0) + 1
                    if (hasWords[currentWord] > allWords[currentWord]):
                        break
                else:
                    break
                wordCt += 1
            if wordCt == len(words):
                ans.append(i)
        return ans


def main():
    test = SubstringwithConcatenationofAllWords()
    print(test.findSubstring2(
        "barfoothefoobarman", ["foo", "bar", "foo", "the"]
    ))
    print(test.findSubstring2(
        "barfoofoobarthefoobarman", ["bar", "foo", "the"]
    ))
    print(test.findSubstring1(
        "bcabbcaabbccacacbabccacaababcbb",["c","b","a","c","a","a","a","b","c"]
    ))
    print(test.findSubstring1(
        "wordgoodgoodgoodbestword",["word","good","best","good"]
    ))


if __name__ == "__main__":
    main()
