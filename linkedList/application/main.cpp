#include <iostream>
#include "Tree.h"

using namespace std;

int main() {
    Tree T(new Node(6));
    Node *n1 = new Node(5);
    Node *n2 = new Node(6);
    Node *n3 = new Node(2);
    Node *n4 = new Node(7);
    Node *n5 = new Node(8);
    Node *n6 = new Node(9);
    T.addNode(n1);
    T.addNode(n2);
    T.addNode(n3);
    T.addNode(n4);
    T.addNode(n5);
    T.addNode(n6);
    Node N = T.widthSearch(8);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
    //cout<<N.getL()->getValue()<<endl;
    //cout<<N.getR()->getValue();
    return 0;                                                                                                                                                                                                                                                                                                                                                               
}