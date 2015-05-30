import unittest

class Solution:
    #@param {integer[]} nums1
    #@param {integer[]} nums2
    def findMedianSortedArrays(self, nums1, nums2):
        if not nums1 and not nums2:
            return None
        new = nums1 + nums2
        new.sort()
        return self._find_median(new)
        
        
    def _find_median(self, arr):
        length = len(arr)
        if length % 2 == 0:
            return float((arr[length/2] + arr[length/2 - 1]))/2.0
        else:
            return arr[length/2]
    

class TestFindMedianSortedArrays(unittest.TestCase):
    
    def setUp(self):
        self.single_lists = [
            ([1], 1),
            ([1,2], 1.5),
            ([1,1], 1.0),
            ([1,1,1], 1)
        ]



        self.one_empty_list = [
            ([],[1],1),
            ([], [1], 1),
            ([], [1,2], 1.0),
            ([], [1,1,1], 1),
            ([1], [], 1),
            ([1,1], [], 1.0)
        ]

        self.disjoint_lists = [
            ([1],[1],1.0),
            ([1],[2,3],2),
            ([1,2],[3],2)
        ]

    def test_single_list(self):
        solution = Solution()
        for i in self.single_lists:
            self.assertTrue(solution._find_median(i[0]) == i[1])
            
    def test_one_empty_list(self):
        solution = Solution()
        #for i in self.one_empty_list:
            #self.assertTrue(solution.findMedianSortedArrays(i[0],i[1]) == i[2])
            

    def test_disjoin_lists(self):
        solution = Solution()
        #for i in self.disjoint_lists:
            #self.assertTrue(solution.findMedianSortedArrays(i[0],i[1]) == i[2])

if __name__ == '__main__':
    unittest.main()
