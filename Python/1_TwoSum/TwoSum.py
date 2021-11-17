from typing import List


def two_sum_brute_force(nums: List[int], target: int) -> List[int]:
    """
    O(n^2) brute force algo
    """
    for i in range(0, len(nums) - 1):
        for j in range(i + 1, len(nums)):
            if nums[i] + nums[j] == target:
                return [i, j]


def two_sum_sorting(nums: List[int], target: int) -> List[int]:
    """
    Attempt to use sorting to find the required numbers. It had problem with
    identical numbers (6 = 3 + 3). It could probably be fixed but I abandoned it
    because it would have a time complexity of O(n log n)
    """
    sorted_nums = nums.copy()
    sorted_nums.sort()

    left = 0
    right = len(sorted_nums) - 1
    while left < right:
        if sorted_nums[left] + sorted_nums[right] < target:
            left += 1
        elif sorted_nums[left] + sorted_nums[right] > target:
            right -= 1
        else:
            index_left = nums.index(sorted_nums[left])
            nums.remove(sorted_nums[left])
            index_right = nums.index(sorted_nums[right])
            return [index_left, index_right]


def two_sum_set(nums: List[int], target: int) -> List[int]:
    """
    O(n) solution. It uses the fact that sets have a get of O(1) to check if we
    have encountered the pair of the current number. If we had, we go once through
    the list and find its first occurrence.
    """
    nums_set = set()
    for index_right, number in enumerate(nums):
        if (target - number) in nums_set:
            for index_left, pair in enumerate(nums):
                if pair == target - number:
                    return [index_left, index_right]
        nums_set.add(number)


print(two_sum_set([3, 5, 4, 3, 7], 6))
