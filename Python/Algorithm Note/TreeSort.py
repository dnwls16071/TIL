"""
노드 클래스 생성
노드가 가지고 있을 값과 왼쪽 자식 노드 값, 오른쪽 자식 노드의 값
"""
class Node:
    def __init__(self, item=0):
        self.key = item
        self.left, self.right = None, None

root = Node()

def insert(root, key):
    """
    루트 노드가 없다면 루트 노드로 지정
    """
    if root == None:
        root = Node(key)
        return root

    """
    현재 노드의 키 값이 루트 노드의 키 값보다 크면?
    -> 오른쪽 자식 노드에 값 지정

    현재 노드의 키 값이 루트 노드의 키 값보다 작으면?
    -> 왼쪽 자식 노드에 값 지정
    """    
    if key > root.key:
        root.right = insert(root.right, key)
    else:
        root.left = insert(root.left, key)
    return root

"""
이진 트리에 정보를 입력
"""
def treeinsert(data, root):
    for key in data:
        root = insert(root, key)

def inorder(root, answer):
    if root != None:
        inorder(root.left, answer)
        answer.append(root.key)
        inorder(root.right, answer)

sample = [3, 0, 1, 8, 7, 2, 5, 4, 6, 9]
answer = []

treeinsert(sample, root)
inorder(root, answer)
print(answer[1:])
