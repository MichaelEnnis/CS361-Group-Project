package fa.dfa;


import java.util.*;

import fa.State;

//Jeremy Hochstrasser
//Michael Ennis

public class DFA implements DFAInterface{
	//initial state
	DFAState q0;
	//final state(s)
	Set<DFAState> f = new HashSet<DFAState>();
	//transition function
	Set<Character> alpha = new HashSet<Character>();
	//set of states
	Set<DFAState> Q = new HashSet<DFAState>();




	public void addFinalState(String nextToken) {
		//initialise state F
		DFAState f1 = new DFAState();
		f1.setName(nextToken);
		f1.setType("finalState");
		//		f = new DFAState();
		//		f.setName(nextToken);
		//		f.setType("finalState");
		//add final state to our set of states
		f.add(f1);

	}

	public void addStartState(String startStateName) {
		q0 = new DFAState();
		q0.setName(startStateName);
		q0.setType("initalState");
		Q.add(q0);	

	}

	public void addState(String nextToken) {
		DFAState temp = new DFAState();
		temp.setName(nextToken);
		temp.setType("NONE");
		Q.add(temp);		
	}

	public void addTransition(String fromState, char c, String toState) {
		for(DFAState s : Q) {
			if(s.getName()==fromState) {
				for(DFAState t : Q)
					if(t.getName()==toState) {
						s.AddTransition(c, t);
					}
			}
		}

	}

	public boolean accepts(String nextLine) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Set<? extends State> getStates() {
		return Q;
	}


	@Override
	public Set<? extends State> getFinalStates() {
		return f;
	}


	@Override
	public State getStartState() {
		return q0;
	}


	@Override
	public Set<Character> getABC() {
		return alpha;
	}


	@Override
	public State getToState(DFAState from, char onSymb) {
		return from.search(onSymb);
	}

	public String toString() {
		String s = "Q = "+ getStates() + "\n Sigma = "+ getABC() + "\n delta = "+
				" DELTA TABLE FROM HASH MAP"+ "\n q0 = "+getStartState()+"\n F = "+ getFinalStates() + "\n";
		return s;

	}

}
