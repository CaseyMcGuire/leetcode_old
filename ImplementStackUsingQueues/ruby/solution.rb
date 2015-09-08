#pop is O(n) time. All others are O(1) time
class Stack 

  #Initialize data structure here
  def initialize
    @cur_queue = []
    @other_queue = []
  end

  # @param {Integer} x
  # @return (void)
  def push(x)
    @cur_queue.push(x)
  end
  
  # @return {void}
  def pop
    return if @cur_queue.empty?
    while @cur_queue.length != 1
      @other_queue.push(@cur_queue.shift)
    end
    result = @cur_queue.shift
    @cur_queue = @other_queue
    @other_queue = []
    result
  end

  def top
    @cur_queue[-1]
  end

  # @return {Integer}
  def empty
    @cur_queue.empty?
  end

end
