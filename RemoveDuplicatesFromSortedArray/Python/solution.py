import sys
sys.path.insert(0, '/home/casey/Desktop/CodingProblems/leetcode/Testing/Python')#linux
sys.path.insert(0, '/Users/CaseyMcGuire/Desktop/leetcode/Testing/Python')#mac

import unittest

def removeDuplicates(A):
    if A is None or not A:
        return 0

    index = 1
    for i in range(index, len(A)):
        if A[i] != A[index - 1]:
            A[index] = A[i]
            index += 1
    return index


class TestRemoveDuplicates(unittest.TestCase):
    
    def setUp(self):
        
        #[old_list, new_length, new_list]
        self.lists = [
            [[],0,[]],
            [[1],1,[1]],
            [[1,1],1,[1]],
            [[1,1,1],1,[1]],
            [[1,2],2,[1,2]],
            [[1,1,2],2,[1,2]],
            [[1,2,2],2,[1,2]],
            [[1,1,2,2],2,[1,2]],
            [[1,1,1,2,2],2,[1,2]],
            [[1,1,1,2,2,2],2,[1,2]],
            [[1,2,3,3],3,[1,2,3]],
            [[1,2,2,3,3],3,[1,2,3]],
            [[1,1,2,2,3,3],3,[1,2,3]],
            [[1,2,3,3,3,3,3],3,[1,2,3]],
        ]


    def test_lists(self):
        for i in self.lists:
            #Make sure the length is right
            self.assertTrue(i[1] == removeDuplicates(i[0]))

            #Make the array is correct
            for j in range(len(i[2])):
                self.assertTrue(i[0][j] == i[2][j])

if __name__ == '__main__':
    unittest.main()
