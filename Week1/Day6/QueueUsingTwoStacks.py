import unittest


class QueueTwoStacks(object):

    # Implement the enqueue and dequeue methods

    stack1 = []
    stack2 = []

    def enqueue(self, item):
        global stack1
        self.stack1.insert(0,item)

    def dequeue(self):
        
        global stack1 
        global stack2

        

        if len(self.stack2) == 0:
            i = 0
            
            while i < len(self.stack1):
                
                self.stack2.insert(0,self.stack1[i])
                i += 1
            self.stack1 = []
        return self.stack2.pop(0)



















# Tests

class Test(unittest.TestCase):

    def test_queue_usage(self):
        queue = QueueTwoStacks()

        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)

        actual = queue.dequeue()
        expected = 1
        self.assertEqual(actual, expected)

        actual = queue.dequeue()
        expected = 2
        self.assertEqual(actual, expected)

        queue.enqueue(4)

        actual = queue.dequeue()
        expected = 3
        self.assertEqual(actual, expected)

        actual = queue.dequeue()
        expected = 4
        self.assertEqual(actual, expected)

        with self.assertRaises(Exception):
            queue.dequeue()


unittest.main(verbosity=2)