#ifndef TREE_H
#define TREE_H

#include "Node.h"
#include <iostream>
using namespace std;

// arvore binária de busca (porém usando busca em largura)

class Tree {
    private: 
        Node *root;
        
    public:
        Tree(Tree *T);
        Tree(Node root);
        ~Tree();

        void addNode(Node* leaf);
        Node* widthSearch(int value);
        Node* getRoot();
};

#endif