class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        answer = ""
        
        strs = sorted(strs)
        start = strs[0]
        end = strs[-1]
        for i in range(min(len(start),len(end))):
            if(start[i]!=end[i]):
                return answer
            answer+=start[i]
        
        return answer
        