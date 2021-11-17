from collections import Counter


class ValidAnagram:
    def isAnagram(self, s: str, t: str) -> bool:
        return self.is_anagram_counter(s, t)

    @staticmethod
    def is_anagram_dict(s: str, t: str) -> bool:
        """
        If the length of the strings is different return false. Use two dictionaries to
        count the number of occurrences of each letter in each of the strings. Then compare
        the dictionaries to see if the strings are anagrams of each other.
        """
        if len(s) != len(t):
            return False
        s_dict = {}
        t_dict = {}
        length = len(s)
        for i in range(length):
            s_dict.update({s[i]: s_dict.setdefault(s[i], 0) + 1})
            t_dict.update({t[i]: t_dict.setdefault(t[i], 0) + 1})
        return s_dict == t_dict


    @staticmethod
    def is_anagram_counter(s: str, t: str) -> bool:
        """
        If the length of the strings is different return false.Use the python counter
        to count the number of occurrences of each letter in each of the strings.
        Then compare the resulted dictionaries.
        """
        if len(s) != len(t):
            return False
        s_counter = Counter(s)
        t_counter = Counter(t)
        return s_counter == t_counter

hello = ValidAnagram()
print(hello.isAnagram("anagram", "nagraam"))
