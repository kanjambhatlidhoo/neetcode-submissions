class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []

        self.go(n, res, "", 0, 0)

        return res
    
    def go(self, n, res, curr, open_, close):
        if open_ > n:
            return
        
        if close > open_ or close > n:
            return
        
        if open_ == close and open_ == n and close == n:
            res.append(curr[:])
            return
        
        # two conditions: left or right
        self.go(n, res, curr + '(', open_ + 1, close)
        self.go(n, res, curr + ')', open_, close + 1)


        