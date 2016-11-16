class MinStack(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack, self.minstack = [], []
        self.min = 0

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        if not self.stack or x <= self.min:
            self.stack.append(x)
            self.minstack.append(x)
            self.min = x
        else:
            self.stack.append(x)

    def pop(self):
        """
        :rtype: void
        """
        if self.stack[-1] == self.minstack[-1]:
            del self.minstack[-1]
            if self.minstack:
                self.min = self.minstack[-1]
        del self.stack[-1]

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.minstack[-1]


        # Your MinStack object will be instantiated and called as such:
        # obj = MinStack()
        # obj.push(x)
        # obj.pop()
        # param_3 = obj.top()
        # param_4 = obj.getMin()
