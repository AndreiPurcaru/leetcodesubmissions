from typing import Optional, List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def print_linked_list(linked_list: ListNode):
    while linked_list:
        print(linked_list.val)
        linked_list = linked_list.next


class Solution:
    @staticmethod
    def addTwoNumbers(l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        return Solution.__add_two_numbers_rec(l1, l2)
        # while l1:
        #     result.next = ListNode(l1.val)

    @staticmethod
    def cheaty_add_two_numbers(list1: Optional[ListNode], list2: Optional[ListNode]):
        """
        Sum each pair of elements and store their value in a list. Then use the create linked list method to
        generate the list of nodes.
        :param list1: First list node or None.
        :param list2: First list node or None.
        :return: a linked list containing the number in reverse order
        """
        sum_list = []
        carry = 0
        while list1 or list2:
            summed, carry = Solution.__sum_with_carry(list1, list2, carry)
            sum_list.append(summed)
            list1 = list1.next if list1 else None
            list2 = list2.next if list2 else None
        if carry == 1:
            sum_list.append(1)
        return Solution.create_linked_list_from_list(sum_list)

    @staticmethod
    def create_linked_list_from_list(array: List[int]) -> ListNode:
        """
        Reverse the array to make the creation of the list easier. Go through each element
        of the array and add it to the linked list

        :param array: The array that should be converted into a list of nodes
        :return: a list of nodes
        """
        array.reverse()
        next_item = None
        for num in array:
            if next_item:
                current = ListNode(num, next_item)
                next_item = current
            else:
                next_item = ListNode(num)
        return next_item

    @staticmethod
    def __add_two_numbers_rec(list1: Optional[ListNode], list2: Optional[ListNode], carry: int = 0) -> ListNode:
        """
        Recursively create the linked list of the sum of the provided lists
        :param list1: First list node or None
        :param list2: Second list node or None
        :param carry: carry: The carry after addition. It can be either 0 or 1
        :return: a list of nodes that correspond to the addition of the two initial lists
        """
        summed, carry = Solution.__sum_with_carry(list1, list2, carry)

        if list1 and list2:
            return ListNode(summed, Solution.__add_two_numbers_rec(list1.next, list2.next, carry))
        if list1:
            return ListNode(summed, Solution.__add_two_numbers_rec(list1.next, None, carry))
        if list2:
            return ListNode(summed, Solution.__add_two_numbers_rec(None, list2.next, carry))
        if summed == 1:
            return ListNode(1)

    @staticmethod
    def __sum_with_carry(list1: Optional[ListNode], list2: Optional[ListNode], carry: int):
        """
        Function that calculates the sum of the current elements of two lists. These
        elements are digits. If one of the lists is empty, return the element of the other
        plus the carry over.
        :param list1: First list node or None. Only its value is used.
        :param list2: Second list node or None. Only its value is used.
        :param carry: The carry after addition. It can be either 0 or 1
        :return (sum, carry): The calculated sum and the carry of the sum
        """
        list1 = ListNode() if not list1 else list1
        list2 = ListNode() if not list2 else list2
        summed = list1.val + list2.val + carry
        carry = 1 if summed > 9 else 0
        summed %= 10
        return summed, carry


