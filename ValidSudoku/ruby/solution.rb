# @param {Character[][]} board
# @return {Boolean}
require 'set'
def is_valid_sudoku(board)
  
  rows = []
  cols = []
  squares = []
  
  9.times do |i|
    rows << Set.new
    cols << Set.new
    squares << Set.new
  end

  9.times do |i|
    9.times do |j|

      if board[i][j] == "."
        next
      end

      if rows[i].add?(board[i][j]) == nil
        return false
      end

      if cols[j].add?(board[i][j]) == nil
        return false
      end

      index = get_square_index(i,j)

      if squares[index].add?(board[i][j]) == nil
        return false
      end
    end
  end
  true
end

def get_square_index(i,j)
  row = nil
  col = nil
  if i >= 0 && i <= 2
    row = 0
  elsif i >= 3 && i <= 5
    row = 3
  else
    row = 6
  end

  if j >= 0 && j <= 2
    col = 0
  elsif j >= 3 && j <= 5
    col = 1
  else
    col = 2
  end
  col + row
end


