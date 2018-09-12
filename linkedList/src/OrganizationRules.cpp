#include <iostream>
#include <vector>

#include "OrganizationRules.h"

using namespace std;

OrganizationRules(const vector<Rule> &a_rules, const vector<Variable> &vars){
    this.all_rules = a_rules;
    this.variebles = vars;
}

void OrganizationRules::generator_rules(int q, int n, int cont, int n_p, vector<Rule>& rules, vector<Variable>& auxVars,const vector<Variable>& vars){
	if(q == pow(n_p,n)) return;
	if(cont < 1){
		cont = n;
		q++;
		rules.push_back(new Rule(auxVars));
        auxVars.clear();
	}

	int pos = (q % (int)pow(n_p,cont)) / (int)pow(n_p,cont-1);
    vars[cont].current_function = vars[cont].functions[pos];
    auxVars.push_back(new Variable(vars[cont]));

	generator_rules(q,n,--cont, n_p, rules, auxVars, vars);
}

vector<Rule> OrganizationRules::generator_rules(const vector<Variable>& vars, int n_possibs){
    vector<Rule> rules;
    vector<Variable> aux;
	generator_rules(0, vars.size(), vars.size(), n_possibs, rules, aux,  vars);
    return rules;
}

vector<Rule> OrganizationRules::generator_rules(const vector<Rule>& r1, const vector<Rule>& r2){
    vector<Rule> result;
    for(vector<Rule> i: r1){
        for(vector<Rule> j: r2){
            result.push_back(new Rule(r1,r2));
        }
    }
    return result;
}
        
void OrganizationRules::generator_rules(){
    vector<vector<Variable>> mat_vars; 
    vector<vector<<Rule>> mat_rules;

    for(vector<Variable> i : this.variebles)
        mat_vars[i.functions.size()].push_back(i);
    for(int i = 0; i < mat_vars.size(); i++)
        if(mat_vars[i].size() > 1)
            mat_rules.push_back(this.generator_rules(mat_vars[i],i));
    
    for(vector<vector<Rule>> i : mat_rules)
        this.all_rules = generator_rules(this.all_rules, i); 
}

void OrganizationRules::addVariable(const Variable &var){
    this.variebles.push_back(var);
}

void OrganizationRules::addRule(const Rule &rule){
    for(int i = 0; i < this.all_rules.size();){
        if(this.all_rules[i].equal(rule)){
            this.all_rules.erase(this.all_rules.begin() + i);
            continue;
        }
        i++;
    }
    this.variebles.push_back(rule);
}

void OrganizationRules::showCurrentRules(){
    cout<<"Regras: "<<this.getNumberOfAllRules()<<endl;
    for(vector<Rule> i : this.all_rules){
        i.showRule();
        cout<<endl;
    }
}

int OrganizationRules::getNumberOfAllRules(){
    return this.all_rules.size();
}
