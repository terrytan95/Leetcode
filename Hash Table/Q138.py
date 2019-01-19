class RandomListNode(object):
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        nodeDict = dict()
        dummy = RandomListNode(0)
        pointer, newHead = head, dummy
        while pointer:
            newNode = RandomListNode(pointer.label)
            nodeDict[pointer] = newNode
            newHead.next = newNode
            pointer, newHead = pointer.next, newHead.next
        pointer, newHead = head, dummy.next
        while pointer:
            if pointer.random:
                newHead.random = nodeDict[pointer.random]
            pointer, newHead = pointer.next, newHead.next
        return dummy.next