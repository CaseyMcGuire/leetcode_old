module BST
  class BinarySearchTree

    #Generally, not a good idea to allow access to root but needed for testing purposes
    attr_accessor :root

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
      cur_level = [self.root]
      other_level = [other_tree.root]

      while true
        break if cur_level.all? {|node| node.nil? } && other_level.all? {|node| node.nil? }

        next_cur_level = []
        next_other_level = []

        cur_level.zip(other_level).each do |cur_node, other_node|
          if cur_node.nil? && !other_node.nil? ||
              !cur_node.nil? and other_node.nil? ||
              !cur_node.nil? && !other_node.nil? && cur_node.val != cur_node.val
            return false
          end

          if cur_node.nil? && other_node.nil?
            next_cur_level << cur_node.left
            next_cur_level << cur_node.right
            next_other_level << other_node.left
            next_other_level << other_node.right
          else
            2.times {|i| next_cur_level << nil }
            2.times {|i| next_other_level << nil }
          end
        end
      true
    end

    def to_s
      str = ""
      queue = [[@root]]
      
      #First, a level order representation of our tree
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

      #Now, convert it to a string with a line break between each level
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


  def build_bst(array)
    new_tree = BST::BinarySearchTree.new
    
  end
end


if __FILE__ == $0
  my_tree = BST::BinarySearchTree.new
  my_tree.insert(1)
  my_tree.insert(2)
  my_tree.insert(0)
  puts my_tree.to_s
end
