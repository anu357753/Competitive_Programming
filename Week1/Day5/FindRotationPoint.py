import unittest


def find_rotation_point(words):

    # Find the rotation point in the list
    low = 0
    high = len(words) - 1 
    
    if high < low:
        return 0
        
    if high == low:
        return low
        
    mid = low + (high - low) / 2 
    
    
    while True:
        if mid > low and words[mid - 1] > words[mid]:
            return mid
        
        if mid < high and words[mid + 1] < words[mid]:
            return mid+1
        
        if words[mid] > words[high]:
            low = mid +1
            mid = low + (high - low) / 2
        else:
            high = mid - 1
            mid = low + (high - low) / 2

 


















# Tests

class Test(unittest.TestCase):

    def test_small_list(self):
        actual = find_rotation_point(['cape', 'cake'])
        expected = 1
        self.assertEqual(actual, expected)

    def test_medium_list(self):
        actual = find_rotation_point(['grape', 'orange', 'plum',
                                      'radish', 'apple'])
        expected = 4
        self.assertEqual(actual, expected)

    def test_large_list(self):
        actual = find_rotation_point(['ptolemaic', 'retrograde', 'supplant',
                                      'undulate', 'xenoepist', 'asymptote',
                                      'babka', 'banoffee', 'engender',
                                      'karpatka', 'othellolagkage'])
        expected = 5
        self.assertEqual(actual, expected)

    # Are we missing any edge cases?


unittest.main(verbosity=2)