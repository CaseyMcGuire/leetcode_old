require "test/unit"
# @param {Integer[][]} matrix
# @return {Void} Do not return anything, modify the matrix in-place instead
def set_zeroes(matrix)
  m = matrix.length
  n = matrix[0].length

  #keep track of which columns and rows need to be zeroed out
  cols = []
  rows = []
  
  m.times do |i|
    rows << false
  end

  n.times do |i|
    cols << false
  end

  m.times do |i|
    n.times do |j|
      if matrix[i][j] == 0
        rows[i] = true
        cols[j] = true
      end
    end
  end

  #go through and check which rows need to be zeroed out
  rows.each_with_index do |item, i|

    if item != true
      next
    end
    
    n.times do |j|
      matrix[i][j] = 0
    end
  end

  #check which columns need to be zeroed out
  cols.each_with_index do |item, j|
    if item != true
      next
    end

    m.times do |i|
      matrix[i][j] = 0
    end
    
  end
  return
end

class TestSetMatrixZeroes < Test::Unit::TestCase
  def test_simple
    input = 
      [
       [0,0,0,5],
       [4,3,1,4],
       [0,1,1,4],
       [1,2,1,3],
       [0,0,1,1]
      ]
    expected_output = 
      [
       [0,0,0,0],
       [0,0,0,4],
       [0,0,0,0],
       [0,0,0,3],
       [0,0,0,0]
      ]
    set_zeroes(input)
    input.each do |i|
      p i
    end
    assert_equal(expected_output, input)
  end
end
