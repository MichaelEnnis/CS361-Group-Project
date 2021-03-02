package fa.dfa;

import java.util.*;

import fa.State;

/**
 * Class that represents a singular DFA state
 * @author Jeremy Hochstrasser
 * @author Michael Ennis
 */
public class DFAState extends State{
	
	//transition function
	Map<Character,DFAState> transFunct=new HashMap<Character,DFAState>();
	
	//ArrayList<DFAState[]> outerArr = new ArrayList<DFAState[]>();
	private String type;
	/**
	 * Getter method for the alphabet
	 * @return A set containing the alphabet
	 */
	public Set<Character> getAlphabet() {
		return transFunct.keySet();
	}
	/**
	 * method to find a transition from a certain symbol
	 * @param c - the symbol to transition from
	 * @return The corresponding state from the transition symbol
	 */
	public DFAState findTransition(Character c) {

		return transFunct.get(c);

	}
	/**
	 * Method to add a transition to a DFA state
	 * @param c - The transition symbol
	 * @param toState - The state you are transitioning to
	 */
	public void AddTransition(Character c, DFAState toState) {
		transFunct.put(c, toState);
	}
	/**
	 * Method to find a DFA state from a transition symbol
	 * @param onSymb - the transition symbol
	 * @return The DFA state you found
	 */
	public DFAState search(Character onSymb) {
		return transFunct.get(onSymb);
		
	}
	/**
	 * Setter method for the DFA state type
	 * @param type - the type you are setting
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Setter method for the DFA state name
	 * @param name - the name you are setting
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter method for the DFA state type
	 * @return the type of the state
	 */
	public String getType() {
		return this.type;
	}
	
}
