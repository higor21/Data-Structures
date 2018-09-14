#ifndef NODE_H
#define NODE_H

#include <iostream>



class Node {
    private: 
        int value;
        Node *right;
        Node *left;
        
    public:
        Node(int v, Node *r = NULL, Node *l = NULL);
        Node(Node *N);
        ~Node();

        void setValue(int value);
        int getValue();
        Node* getR();
        Node* getL();
        void setR(Node *R);
        void setL(Node *L);
};

#endif