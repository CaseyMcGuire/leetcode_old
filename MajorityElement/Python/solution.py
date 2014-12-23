#There are several solutions to this problem

import sys
sys.path.insert(0, '/home/casey/Desktop/CodingProblems/leetcode/Testing/Python')#linux
sys.path.insert(0, '/Users/CaseyMcGuire/Desktop/leetcode/Testing/Python')#mac
import unittest


#O(nlgn) time and O(1) space
def majority_element1(num):
    '''
    Returns the element that appears a majority of the time (we may assume that one element appears a majority of the time)
    @return {Integer} The majority element
    '''
    return sorted(num)[len(num)/2]


class TestMajorityElement(unittest.TestCase):
    
    def setUp(self):
        
        #map each list to its majority element
        self.list_to_majority_element = {
            1 : [1],
            1 : [1,1,2],
            2 : [1,2,2],
            2 : [1,1,2,2,2],
            2 : [2,2,2,2,3,4,23]
        }
        
    def test_pass(self):
        for i in self.list_to_majority_element.items():
            self.assertTrue(majority_element1(i[1]) == i[0])

if __name__ == '__main__':
    unittest.main()
