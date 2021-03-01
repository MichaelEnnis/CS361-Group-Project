package fa.dfa;


import java.util.ArrayList;
import java.util.List;

//Jeremy Hochstrasser
//Michael Ennis

public abstract class DFA implements DFAInterface{
	//initial state
	String q0;
	//final state
	String f;
	//transition function
	String trans;
	//alphabet
	List<String> alpha =new ArrayList<String>();
	//set of states
	List<String> Q =new ArrayList<String>();

	

	

	public void addFinalState(String nextToken) {
		f = nextToken;
		
	}

	public void addStartState(String startStateName) {
		q0 = startStateName;
		
	}

	public void addState(String nextToken) {
		Q.add(nextToken);
		
	}

	public void addTransition(String valueOf, char c, String valueOf2) {
		// TODO Auto-generated method stub
		
	}

	public boolean accepts(String nextLine) {
		// TODO Auto-generated method stub
		return false;
	}

}
