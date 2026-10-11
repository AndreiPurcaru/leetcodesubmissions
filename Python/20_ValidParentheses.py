class Solution:
    matches: dict[str, str] = {
        ')': '(',
        ']': '[',
        '}': '{'
    }
    LEFT_PARENTHESES: set[str] = set(matches.values())
    RIGHT_PARENTHESES: set[str] = set(matches.keys())

    def isValid(self, s: str) -> bool:
        stack = []

        for char in s:
            if char in self.LEFT_PARENTHESES:
                stack.append(char)
            elif char in self.RIGHT_PARENTHESES:
                if stack and stack[-1] == self.matches[char]:
                    stack.pop()
                else:
                    return False
            else:
                return False
        return not stack


if __name__ == "__main__":
    sol = Solution()
    print(sol.isValid("()[]{}"))


