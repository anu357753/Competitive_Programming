import unittest


class Trie_node:

    def __init__(self):
        self.children = [None]*26
        self.isEnd = False

class Trie:

    # Implement a trie and use it to efficiently store strings

    def __init__(self):
        self.root = Trie_node()

    def charToIndex(self,ch):
        return ord(ch) - ord('a')

    def add_word(self, word):
        
        length = len(word)
        new_entry = self.root

        for i in range(length):
            index = self.charToIndex(word[i])

            if not new_entry.children[index]:
                new_entry.children[index] = Trie_node()
            new_entry = new_entry.children[index]


        if new_entry.isEnd:
            return False
        else:
            new_entry.isEnd = True
            
            return True



# Tests

class Test(unittest.TestCase):

    def test_trie_usage(self):
        trie = Trie()

        result = trie.add_word('catch')
        self.assertTrue(result, msg='new word 1')

        result = trie.add_word('cakes')
        self.assertTrue(result, msg='new word 2')

        result = trie.add_word('cake')
        self.assertTrue(result, msg='prefix of existing word')

        result = trie.add_word('cake')
        self.assertFalse(result, msg='word already present')

        result = trie.add_word('caked')
        self.assertTrue(result, msg='new word 3')

        result = trie.add_word('catch')
        self.assertFalse(result, msg='all words still present')

        result = trie.add_word('')
        self.assertTrue(result, msg='empty word')

        result = trie.add_word('')
        self.assertFalse(result, msg='empty word present')


unittest.main(verbosity=2)