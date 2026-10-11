class Solution:
    def missingNumber(self, nums: list[int]) -> int:
        array_sum = 0

        for num in nums:
            array_sum += num

        n = len(nums)
        # One of (n, n + 1) will be even, so dividing by 2
        # always returns an integer
        target_sum = n * (n + 1) // 2
        return target_sum - array_sum

if __name__ == "__main__":
    sol = Solution()
    print(sol.missingNumber([3,0,1]))
    print(sol.missingNumber([9,6,4,2,3,5,7,0,1]))
    print(sol.missingNumber([0,1]))