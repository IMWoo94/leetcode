class Solution:
    def mySqrt(self, x: int) -> int:
#         for num in range(x+1):
#             if num*num > x:
#                 return num-1;
            
#         return x

        start = 0
        end = x
        while start <= x:
            mid = int((start + end) / 2)
            if mid * mid <= x and x < (mid + 1) * (mid + 1):
                return mid
            elif mid * mid < x:
                start = mid + 1
            else:
                end = mid - 1
        return start