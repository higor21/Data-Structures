
#include "Node.h"

Node::Node(int v, Node *r, Node *l){
    this->value = v;
    this->right = r;
    this->left = l;
}

Node::Node(Node *N){
    this->value = N->getValue();
    this->right = N->getR();
    this->left = N->getL();
}

Node::~Node(){}

void Node::setValue(int value){
    this->value = value;
}

int Node::getValue(){
    return this->value;
}

Node* Node::getR(){
    return this->right;
}

Node* Node::getL(){
    return this->left;
}

void Node::setR(Node *R){
    this->right = R;
}

void Node::setL(Node *L){
    this->left = L;
}
