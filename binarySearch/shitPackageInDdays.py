    def shipWithinDays(self, weights: List[int], D: int) -> int:
        left, right = max(weights), sum(weights)
        while left + 1< right:
            
            mid = left + (right - left) //2
            if self.helper(weights, mid, D):
                left = mid
            
            else: 
                right = mid
                
        #return left
        if self.helper(weights, left, D):
            return right
        return left
    

    # retrun true if need more days with current weight for each time 
    # return true if more weight 
    def helper(self, weights, weight, D):
        count = 1
        cur_sum = 0
        
        for each in weights:
            if cur_sum + each > weight:     
                count+=1
                cur_sum = 0
            cur_sum += each
        return count > D
        