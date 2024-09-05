#include <stdio.h>
#include "../node_structure/ListNode.h"
#include <stdlib.h>

void reorderList(struct ListNode* head) {
    if (head == NULL || head->next == NULL) return;
}


int main() {
    struct ListNode a = {.val = 3, .next = NULL};
    printf("a.val = %d", a.val);
    return EXIT_SUCCESS;
}
