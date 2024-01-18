class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        if target in nums:
            return nums.index(target)
        else:
            start = 0 
            end = len(nums) - 1
            while start <= end:
                mid = int((start + end)/2)
                if nums[mid] == target:
                    return mid
                elif nums[mid] < target:
                    start = mid + 1
                else :
                    end = mid - 1
                    
            return start