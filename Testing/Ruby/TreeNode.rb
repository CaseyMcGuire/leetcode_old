module BST
  class BinarySearchTree
    def initialize
      @root = nil
    end
    
    def insert(elem)
      new_node = BST::TreeNode.new(elem)
      if @root.nil?
        @root = new_node
      else

        cur_node = @root
        while !cur_node.equal?(new_node)
          if new_node > cur_node
            cur_node.right = new_node if cur_node.right.nil?
            cur_node = cur_node.right
          else
            cur_node.left = new_node if cur_node.left.nil?
            cur_node = cur_node.left
          end
        end
      end
        
    end

    def ==(other_tree)
      #This is probably not wise but its fine for now
      self.to_s == other_tree.to_s
    end

    def to_s
      str = ""
      queue = [[@root]]

      while true
        next_level = []
        queue[-1].each do |node|
          if node.nil?
            2.times {|i| next_level << nil } 
          else
            next_level << node.left
            next_level << node.right
          end
        end
        break if next_level.none?
        queue << next_level
      end
      queue.reduce("") do |acc, level|
        acc + "\n" + level.reduce("") {|memo, node| memo + node.to_s }
      end
    end
  end

  class TreeNode
    include Comparable

    attr_accessor :val, :left, :right

    def initialize(val)
      @val = val
      @left, @right = nil, nil
    end

    def <=>(other_node)
      if self.val < other_node.val
        -1
      elsif self.val > other_node.val
        1
      else 
        0
      end
    end

    def to_s
      @val.to_s
    end
    
  end
end


if __FILE__ == $0
  my_tree = BST::BinarySearchTree.new
  my_tree.insert(1)
  my_tree.insert(2)
  my_tree.insert(0)
  puts my_tree.to_s
end
