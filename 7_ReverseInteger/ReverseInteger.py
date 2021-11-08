class Solution:
    def reverse(self, x: int) -> int:
        return Solution.__reverse_multiplication(x)

    @staticmethod
    def __reverse_multiplication(x: int) -> int:
        """
        Reverse an integer by constantly taking its last digit and adding it to
        the previous step * 10 (adding it as the last digit)
        :param x: The integer to be reverted
        :return: The reverted integer or 0 if it does not fit in 32 bits
        """
        negative = True if x < 0 else False
        number = x * (-1) if negative else x

        reverse = 0
        int_limit = 2 ** 31 - 1
        while number:
            last_digit = number % 10
            reverse = reverse * 10 + last_digit
            if reverse > int_limit:
                return 0
            number //= 10

        return reverse * (-1) if negative else reverse

sol = Solution()
print(sol.reverse(-1234))