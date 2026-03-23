#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define max(a, b) (((a) > (b)) ? (a) : (b))
#define min(a, b) (((b) > (a)) ? (a) : (b))

int minDistance(char* word1, char* word2) {
    int m = strlen(word1);
    int n = strlen(word2);
    // printf("str1 length: %d, str2 length: %d.\n", m, n);
    int dp[m + 1][n + 1];
    // initialize dp
    for (size_t i = 0; i < m + 1; ++i) {
        dp[i][0] = i;
    }
    for (size_t i = 0; i < n + 1; ++i) {
        dp[0][i] = i;
    }
    for (size_t i = 1; i < m + 1; ++i) {
        for (size_t j = 1; j < n + 1; ++j) {
            dp[i][j] = min(
                min(
                    dp[i - 1][j - 1] + (word1[i-1] != word2[j-1] ? 1 : 0),
                    dp[i - 1][j] + 1
                ),
                dp[i][j - 1] + 1
            );
        }
    }
    // for (size_t i = 0; i < (m+1)*(n+1); i++) {
    //     printf("%d", dp[i / (n+1)][i % (n+1)]);
    //     if (i % (n+1) == n) printf("\n");
    //     else printf("\t\t");
    // }
    return dp[m][n];
}


int main() {
	printf("%d\n", minDistance("horse", "ros"));
}