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
	Map<String,DFAState> transFunct=new HashMap<String,DFAState>();
	//alphabet
	Set<String> alpha = new HashSet<String>();
	//set of states
	Set<DFAState> Q = new HashSet<DFAState>();
	

	

	public void addFinalState(String nextToken) {
		//initialise state F
		f = new DFAState();
		f.setName(nextToken);
		f.setType("finalState");
		//add final state to our set of states
		Q.add(f);
		
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

	public void addTransition(String valueOf, char c, String valueOf2) {
		// TODO Auto-generated method stub
		String c1 = String.valueOf(c);
		DFAState end = null;
		for(DFAState st : Q) {
			if(valueOf2 == st.getName()) {
				end = st;
			}
		}
		//store the char c as the key and the dfaState valueOf2 as value
		transFunct.put(c1, end);
		
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
