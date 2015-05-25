import unittest

class Solution:
#@param{Integer} numRows
#@return {integer[][]}
    def generate(self, numRows):
        rows = []
        if numRows == 0:
            return rows
        else:
            rows.append([1])
        for i in range(numRows - 1):
            rows.append(self._get_single_row(rows[-1]))
        return rows
        
    def _get_single_row(self, prev_row):
        new_row = []
        for i in range(len(prev_row) + 1):
            if i == 0 or i == len(prev_row):
                new_row.append(1)
            else:
                new_row.append(prev_row[i - 1] + prev_row[i])
        return new_row
    
class TestPascalsTriangle(unittest.TestCase):
    def setUp(self):
        self.rows = [
            [1],
            [1,1],
            [1,2,1],
            [1,3,3,1],
            [1,4,6,4,1],
            [1,5,10,10,5,1]
        ]

    def test(self):
        solution = Solution()

        for i in range(len(self.rows)):
            cur_triangle = []
            for j in range(i):
                cur_triangle.append(self.rows[j])
            cur_solution = solution.generate(i)
            self.assertTrue(len(cur_solution) == len(cur_triangle))
            #make sure triangle are the same, row by row
            for j in range(len(cur_solution)):
                self.assertTrue(len(cur_solution[j]) == len(cur_triangle[j]))
                for k in range(len(cur_solution[j])):
                    self.assertTrue(cur_solution[j][k] == cur_triangle[j][k])

if __name__ == '__main__':
    unittest.main()
