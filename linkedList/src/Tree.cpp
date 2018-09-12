#ifndef TREE_H
#define TREE_H

#include "Node.h"

class Tree {
    private: 
        Node root;
        
    public:
        Tree(const Tree &T);
        Tree(Node root)

        void addNode(Node leaf);
        Node widthSearch(int value);
};

#endif