
#include "Node.h"

Node::Node(int v, Node *r = Null, Node *l = Null){
    this.value = v;
    this.right = r;
    this.left = l;
}

Node::Node(const Node &N){
    this.value = N->getValue();
    this.right = N->getR();
    this.left = N->getL();
}

Node::~Node(){}

void Node::setValue(int value){
    this.value = value;
}

Node Node::getR(){
    return this.right;
}

Node Node::getL(){
    return this.left;
}
