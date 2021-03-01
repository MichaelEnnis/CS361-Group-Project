package fa.dfa;


import java.util.*;

import fa.State;

//Jeremy Hochstrasser
//Michael Ennis

public class DFA implements DFAInterface{
	//initial state
	DFAState q0;
	//final state
	DFAState f;
	//transition function
	HashMap<DFAState,String> transFunct=new HashMap<DFAState,String>();
	//alphabet
	Set<String> alpha = new HashSet<String>();
	//set of states
	Set<DFAState> Q = new HashSet<DFAState>();
	

	

	public void addFinalState(String nextToken) {
		f = new DFAState();
		f.setName(nextToken);
		f.setType("finalState");
		
	}

	public void addStartState(String startStateName) {
		q0 = new DFAState();
		q0.setName(startStateName);
		q0.setType("initalState");
	
		
	}

	public void addState(String nextToken) {
		DFAState temp = new DFAState();
		temp.setName(nextToken);
		temp.setType("NONE");
		
	}

	public void addTransition(String valueOf, char c, String valueOf2) {
		// TODO Auto-generated method stub
		
	}

	public boolean accepts(String nextLine) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Set<? extends State> getStates() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Set<? extends State> getFinalStates() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public State getStartState() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Set<Character> getABC() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public State getToState(DFAState from, char onSymb) {
		// TODO Auto-generated method stub
		return null;
	}

}
