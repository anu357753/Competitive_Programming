import unittest


class Stack(object):

    def __init__(self):
        """Initialize an empty stack"""
        self.items = []

    def push(self, item):
        """Push new item to stack"""
        self.items.append(item)

    def pop(self):
        """Remove and return last item"""
        # If the stack is empty, return None
        # (it would also be reasonable to throw an exception)
        if not self.items:
            return None

        return self.items.pop()

    def peek(self):
        """See what the last item is"""
        if not self.items:
            return None
        return self.items[-1]

    def length(self):
        return len(self.items)

    def print_stack(self):
        print self.items


class MaxStack(object):

    # Implement the push, pop, and get_max methods
    

    def __init__(self):
        self.main_stack = Stack()
        self.aux_stack = Stack()

    def push(self, item):
        
        if self.main_stack.length() == 0:
            self.main_stack.push(item)
            self.aux_stack.push(item)

        else:
            if item > self.aux_stack.peek():
                self.aux_stack.push(item)
            else:
                self.aux_stack.push(self.aux_stack.peek())
            self.main_stack.push(item)

        self.main_stack.print_stack()
        self.aux_stack.print_stack()
    def pop(self):
        self.aux_stack.pop()
        return self.main_stack.pop()
        

    def get_max(self):
        
        return self.aux_stack.peek()


















# Tests

class Test(unittest.TestCase):

    def test_stack_usage(self):
        max_stack = MaxStack()

        max_stack.push(5)

        actual = max_stack.get_max()
        expected = 5
        self.assertEqual(actual, expected)

        max_stack.push(4)
        max_stack.push(7)
        max_stack.push(7)
        max_stack.push(8)

        actual = max_stack.get_max()
        expected = 8
        self.assertEqual(actual, expected)

        actual = max_stack.pop()
        expected = 8
        self.assertEqual(actual, expected)

        actual = max_stack.get_max()
        expected = 7
        self.assertEqual(actual, expected)

        actual = max_stack.pop()
        expected = 7
        self.assertEqual(actual, expected)

        actual = max_stack.get_max()
        expected = 7
        self.assertEqual(actual, expected)

        actual = max_stack.pop()
        expected = 7
        self.assertEqual(actual, expected)

        actual = max_stack.get_max()
        expected = 5
        self.assertEqual(actual, expected)

        actual = max_stack.pop()
        expected = 4
        self.assertEqual(actual, expected)

        actual = max_stack.get_max()
        expected = 5
        self.assertEqual(actual, expected)


unittest.main(verbosity=2)