require_relative '../../Testing/Ruby/TreeNode'


def recur(node, cur_path, list)
  new_path = cur_path + "->" + node.val.to_s
  if node.right.nil? && node.left.nil?
    list << new_path
  else
    recur(node.right, new_path, list) if !node.right.nil?
    recur(node.left, new_path, list) if !node.left.nil?
  end
end

def binary_tree_paths(root)
  list = []
  if !root.nil?
    recur(root.right, root.val.to_s, list) if !root.right.nil?
    recur(root.left, root.val.to_s, list) if !root.left.nil?
    list << root.val.to_s if list.empty?
  end
  list
end




if __FILE__ == $0
  test = BST::BinarySearchTree.new
  binary_tree_paths(test.root)
end
