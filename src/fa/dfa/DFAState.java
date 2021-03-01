package fa.dfa;

import java.util.*;

import fa.State;

//Jeremy Hochstrasser
//Michael Ennis
public class DFAState extends State{
	
	//transition function
	Map<Character,DFAState> transFunct=new HashMap<Character,DFAState>();
	
	//ArrayList<DFAState[]> outerArr = new ArrayList<DFAState[]>();
	private String type;
	
	public void AddTransition(Character c, DFAState toState) {
		transFunct.put(c, toState);
	}
	
	public DFAState search(char onSymb) {
		return transFunct.get(onSymb);
		
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return this.type;
	}
	
}
