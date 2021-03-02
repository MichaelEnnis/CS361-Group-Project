package fa.dfa;


import java.util.*;

import fa.State;

/**
 * Class to represent a deterministic finite automata
 * 
 * @author Jeremy Hochstrasser
 * @author Michael Ennis
 *
 */
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


/**
 * Adds a final state to the DFA
 * 
 * @param The name of the state you are adding
 * 
 */

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

	/**
	 * Adds a start state to the DFA
	 * 
	 * @param The name of the state you are adding
	 */
	public void addStartState(String startStateName) {
		q0 = new DFAState();
		q0.setName(startStateName);
		q0.setType("initalState");
		Q.add(q0);	
		startName = startStateName;
	}

	/**
	 * Adds a state (not final or initial) to the DFA
	 * 
	 * @param The name of the state you are adding
	 */
	public void addState(String nextToken) {
		if(!checkDupeStates(nextToken)) {
		DFAState temp = new DFAState();
		temp.setName(nextToken);
		temp.setType("NONE");
		Q.add(temp);		
		}
	}
	
	/**
	 * Adds a transition from one state to another in the DFA
	 * 
	 * @param The state you are transitioning from
	 * @param The symbol you transition with
	 * @param The state you are transitioning to
	 */
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

	/**
	 * Method to check whether the DFA accepts a given string
	 * 
	 * @param The string you are checking
	 * 
	 * @return returns true if the string is in the DFA, false if it is not
	 */
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

	/**
	 * Getter method for all of the states in the DFA
	 * 
	 * @return A set of all the states in the DFA
	 */
	@Override
	public Set<? extends State> getStates() {
		return Q;
	}

	/**
	 * Getter method for all of the final states in the DFA
	 * 
	 * @return A set of all the final states in the DFA
	 */
	@Override
	public Set<? extends State> getFinalStates() {
		return f;
	}

	/**
	 * Getter method for the start state in the DFA
	 * 
	 * @return The start state for the DFA
	 */
	@Override
	public State getStartState() {
		return q0;
	}

	/**
	 * Getter method for the alphabet of the DFA
	 * 
	 * @return A set for the alphabet of the DFA
	 */
	@Override
	public Set<Character> getABC() {
		//Iterator i = Q.iterator();
		//DFAState s = (DFAState) i.next();
		return q0.getAlphabet();
	}

	/**
	 * Method used to get to a state using a from state
	 * @param The state you are transitioning from
	 * @param The symbol you are transitioning on
	 * @return The state you are transitioning to
	 */
	@Override
	public State getToState(DFAState from, char onSymb) {
		return from.search(onSymb);
	}
	/**
	 * Getter method for the delta table of the DFA
	 * 
	 * @return The delta table of the DFA as a string
	 */
	public String getDelta() {
		
		return null;
	}
	/**
	 * Replaces the brackets in a string with curly braces
	 * 
	 * @param The string you want to "fix"
	 * @return The "fixed" string
	 */
	public String fixBrackets(String s) {
		return s.replace("[", "{").replace("]", "}").replace(",", "");
		
	}
	/**
	 * Check for duplicate states in the DFA
	 * @param The DFA name you want to check
	 * @return returns true if a state of that name is in the DFA, false otherwise
	 */
	public boolean checkDupeStates(String s) {
		for(DFAState state: Q) {
			if(state.getName().equals(s))
				return true;
		}
		return false;
		
	}
	/**
	 * Method to compile the delta table for the DFA
	 * 
	 * @return The delta table for the DFA
	 */
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
	
	
	/**
	 * Returns the 5-tuple representation of the DFA
	 * 
	 * @return  the 5-tuple representation of the DFA
	 */
	public String toString() {
		String s = "Q = "+ fixBrackets(getStates().toString()) + "\nSigma = "+ fixBrackets(getABC().toString())
				+ "\ndelta = "+getTable()+ "\nq0 = "
				+getStartState()+"\nF = "+ fixBrackets(getFinalStates().toString());
		return s +"\n";

	}

}
