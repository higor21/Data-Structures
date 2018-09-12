#ifndef NODE_H
#define NODE_H

#include "Node.h"

class Node {
    private: 
        int value;
        Node *right;
        Node *left;
        
    public:
        Node(int v, Node r = Null, Node l = Null);
        Node(const Node &N);
        ~Node();

        void setValue(int value);
        int getValue();
        Node getR();
        Node getL();
};

#endif