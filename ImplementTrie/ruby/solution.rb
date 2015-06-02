require "test/unit"
require "set"
class TrieNode
  attr_accessor :char_pointers, :character, :is_prefix
    
  def initialize
    @character = nil
    @node_pointers = {}
  end

  #Inserts a character into this node's array of pointers if its not already present
  def insert_letter(letter)
    @node_pointers[letter.to_sym] = TrieNode.new if @node_pointers[letter.to_sym].nil?
  end

  #gets the node of the corresponding letter
  def get_node(letter)
    @node_pointers[letter.to_sym]
  end

  def is_word!
    @is_word = true
  end

  def is_word?
    @is_word
  end
  
end

class Trie
  def initialize
    @root = TrieNode.new
    @words = Set.new
  end

  # @ param {string} word
  # @return {void}
  # Inserts a word into the trie
  def insert(word)
    word.downcase!
    @words.add(word.to_sym)
    cur_node = @root
    word.split("").each do |letter|
      cur_node.insert_letter(letter)
      cur_node = cur_node.get_node(letter)
      cur_node.is_prefix = true
    end
    cur_node.is_prefix = false unless cur_node.is_prefix
    cur_node.is_word!
  end

  # @param {string} word
  # @return {boolean}
  # Returns if the word is in the trie
  def search(word)
    word.downcase!
    @words.include?(word.to_sym)
  end

  # @param {string} word
  # @return {boolean}
  # Returns if there is any word in the trie that starts with the given prefix
  def starts_with(prefix)
    prefix.downcase!
    cur_node = @root
    prefix.split("").each do |letter|
      cur_node = cur_node.get_node(letter)
      return false if cur_node.nil?
    end    
    cur_node.is_prefix
  end
end

class TestImplementTrie < Test::Unit::TestCase
  def helper_test(words)
    trie = Trie.new
    words.each do |word|
      trie.insert(word)
      assert_true(trie.search(word))
      
      word.length.times do |i|

        assert_true(trie.starts_with(word[0..i]))
        assert_false(trie.search(word[0..i])) unless i == word.length - 1 || i == 0
      end
    end
  end

  def test_simple
    helper_test(["hello", "world"])
  end 

  def test_medium
    helper_test(["app",  "beer", "add", "jam", "rental"])
  end
  

  def test_hard
    trie = Trie.new
    words = ["app", "apple", "beer", "add", "jam", "rental"]
    words.each do |word|
      trie.insert(word)
    end
    
    #assert_false(trie.search("apps"))
    #    assert_true(trie.search("app"))
  end
end

