# @param {Integer[]} nums
# @return {Integer[][]} 
require 'set'
def permute_unique(nums)
  permutations = Set.new
  nums.permutation { |p| permutations.add(p) }
  permutations.to_a
end

