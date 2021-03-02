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

	String table = "";



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
		
	}

	public void addState(String nextToken) {
		DFAState temp = new DFAState();
		temp.setName(nextToken);
		temp.setType("NONE");
		Q.add(temp);		
	}

	public void addTransition(String fromState, char c, String toState) {
		if(!alpha.contains(c)) {
			alpha.add(c);
		}
		
		for(DFAState temp : Q) {
			if(temp.getName().equals(fromState)) {
				for(DFAState findConnecter : Q) {
					if(findConnecter.getName().equals(toState)) {
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
			char[] inputArray = nextLine.toCharArray();
			DFAState position = new DFAState();
			position = q0;
			for(char tran : inputArray) {
				if(position != null) {
					position = position.findTransition(tran);
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
	
	public String getTable() {

//		table.add("___________\n");
		String title = "\n   ";
		for(char c : alpha) {
			if(!(c == ' ')) {
				title += c + "  ";
			}
			
		}
		table += (title + "\n");
		table += ("___________\n");
		
		for(DFAState row : Q) {
			String temp = "";
			temp += row.getName();
			for(char col : alpha) {
				temp += "  "+row.findTransition(col).getName();
			}
			temp += "\n";
			table += (temp);
		}
		



		
		return table.toString();
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
		String s = "Q = "+ getStates() + "\n Sigma = "+ getABC() + "\n delta = \n"+
				getTable()+ "\n q0 = "+getStartState()+"\n F = "+ getFinalStates() + "\n";
		return s;

	}

}
