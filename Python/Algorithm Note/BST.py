class Node:
    def __init__(self, key):
        self.root = key
        self.left = None
        self.right = None

def insert(node, key):
    if node is None:
        return Node(key)
    else:
        if key < node.root:
            node.left = insert(node.left, key)
        else:
            node.right = insert(node.right, key)
    return node

def maketree(nodeinfo):
    root = None
    for key in nodeinfo:
        root = insert(root, key)
    return root
    
def preorder(root):
    res = []
    def _preorder(node):
        if node:
            res.append(node.root)
            _preorder(node.left)
            _preorder(node.right)
    _preorder(root)
    return res

def inorder(root):
    res = []
    def _inorder(node):
        if node:
            _inorder(node.left)
            res.append(node.root)
            _inorder(node.right)
    _inorder(root)
    return res

def postorder(root):
    res = []
    def _postorder(node):
        if node:
            _postorder(node.left)
            _postorder(node.right)
            res.append(node.root)
    _postorder(root)
    return res

nodeinfo = [50, 30, 20, 40, 70, 60, 80]
root = maketree(nodeinfo)

print("전위 순회 : " + str(preorder(root)))
print("중위 순회 : " + str(inorder(root)))
print("후위 순회 : " + str(postorder(root)))
