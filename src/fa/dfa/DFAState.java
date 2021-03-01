package fa.dfa;

import fa.State;

//Jeremy Hochstrasser
//Michael Ennis
public class DFAState extends State{
	
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
	
}
