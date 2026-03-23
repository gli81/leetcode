.PHONY=clean
CFLAGS=-Wall -Werror -std=gnu99 -pedantic
TARGET=reorderc

$(TARGET) : ReorderLinkedList.c ../node_structures/ListNode.h
	gcc -o reorderc $(CFLAGS) $<

clean :
	rm -f $(TARGET) *.o