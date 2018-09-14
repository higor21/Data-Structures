#include "Tree.h"
#include <queue>

using namespace std;

Tree::Tree(Tree *T){
    if(T != NULL)
        this->root = new Node(T->getRoot());
}

Tree::Tree(Node root){
    this->root = new Node(root);
}

Tree::~Tree(){}

Node* Tree::getRoot(){
    return this->root;
}

void Tree::addNode(Node* leaf){
    if(this->root != NULL && leaf != NULL){
        bool dec;
        Node *aux = root;
        Node *ant;
        do{
            ant = aux;
            if(leaf->getValue() > aux->getValue()){
                aux = aux->getR();
                dec = true;
            }else{
                aux = aux->getL();    
                dec = false;
            }
        }while(aux != NULL);
        (dec) ? ant->setR(leaf) : ant->setL(leaf);
        return;
    }
    this->root = leaf;
}

Node* Tree::widthSearch(int value){
    int i = 0;
    queue<Node*> nodes;
    nodes.push(this->root);
    while(!nodes.empty() && i++ < 20){
        Node *aux = nodes.front();
        nodes.pop();
        if(aux->getValue() == value) return aux;
        if(aux->getL() != NULL) nodes.push(aux->getL());
        if(aux->getR() != NULL) nodes.push(aux->getR());
    }
    return NULL;
}
