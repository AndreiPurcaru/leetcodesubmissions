class Palindrome:
    def isPalindrome(self, x: int) -> bool:
        return Palindrome.__is_palindrome_list(x)

    @staticmethod
    def __is_palindrome_string(x: int) -> bool:
        """
        Converts the integer to a string. Goes one by one from both ends of the string
        comparing the elements. If at any point the elements differ, the number is not
        a palindrome
        :param x: The number to be tested
        :return: True if x is palindrome, false otherwise
        """
        string = str(x)
        length = len(string)
        for i in range(length):
            if string[i] != string[length - i - 1]:
                return False
        return True

    @staticmethod
    def __is_palindrome_list(x: int) -> bool:
        """
        Converts the integer to a list. Goes one by one from both ends of the array
        comparing the elements. If at any point the elements differ, the number is not
        a palindrome
        :param x: The number to be tested
        :return: True if x is palindrome, false otherwise
        """
        if x < 0:
            return False

        number_array = []
        length = 0
        while x:
            number_array.append(x % 10)
            length += 1
            x //= 10
        for i in range(length):
            if number_array[i] != number_array[length - i - 1]:
                return False
        return True


pal = Palindrome()
print(pal.isPalindrome(-121))