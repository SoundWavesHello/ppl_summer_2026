/* 
    
    Let's consider the example of a binary tree:
        - A binary tree consists of a bunch of nodes, each of which has 3 attributes
            - A value at the node
            - A left child (which is a binary tree)
            - A right child (which is a binary tree)
        - We can also have what's known as a leaf (i.e. a completely empty binary tree)
    
    
    What might our BNF Grammar look like for a binary tree?

    BT => Leaf
        | Node(BT, BT, n)
    
    where n is an integer

 */


