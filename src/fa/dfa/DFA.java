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
	
	String startName;




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
		Q.add(f1);

	}

	public void addStartState(String startStateName) {
		q0 = new DFAState();
		q0.setName(startStateName);
		q0.setType("initalState");
		Q.add(q0);	
		startName = startStateName;
		
		//hardcoded alphabet for right now
		alpha.add('0');
		//hardcoded alphabet for right now
		alpha.add('1');
	}

	public void addState(String nextToken) {
		DFAState temp = new DFAState();
		temp.setName(nextToken);
		temp.setType("NONE");
		Q.add(temp);		
	}

	public void addTransition(String fromState, char c, String toState) {
		
		for(DFAState temp : Q) {
			if(temp.getName() == fromState) {
				for(DFAState findConnecter : Q) {
					if(findConnecter.getName() == toState) {
						temp.AddTransition(c, findConnecter);
					}
				}
			}
		}

	}

	public boolean accepts(String nextLine) {

		if(Q.isEmpty()) {
			return false;
		}
		else if (!Q.isEmpty()) {
			String[] inputArray = nextLine.split(" ");
			DFAState position = new DFAState();
			position = q0;
			for(String tran : inputArray) {
				if(position != null) {
					position = position.findTransition(tran.charAt(0));
				}
			}
			if(position != null&&position.getType() == "finalState") {
				return true;
			} else {return false;}
		}
		else {
			return false;
		}
		
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
