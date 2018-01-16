package rtl;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public final List<Function> functions;
	private Function main; 
	
	public Program() {
		functions = new ArrayList<Function>();
	}

	public void addFunction(Function f) {
		functions.add(f);
	}

	public Function getMain() {
		return main;
	}

	public void setMain(Function main) {
		this.main = main;
	}

	public void print() {
		for (Function f : functions) {
			f.print();
			System.out.println();
		}
	}

}
