package fa.dfa;

import java.util.ArrayList;
import java.util.List;

import fa.State;

//Jeremy Hochstrasser
//Michael Ennis
public class DFAState extends State{
	
	ArrayList<DFAState[]> outerArr = new ArrayList<DFAState[]>();
	private String type;
	
	public void setType(String type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return this.type;
	}
	
	public void createLINK(DFAState StateB, char symbol) {
		
		
	}
}
