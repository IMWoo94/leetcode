class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        s = "".join([ str(n) for n in digits ])
        result = str(int(s) + 1)
        answer = map(int, [ n for n in result ])
        
        return answer