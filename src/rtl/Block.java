package rtl;

import java.util.ArrayList;
import java.util.List;

public class Block {

	public final Ident label;
	public final List<Instr> instrs;
	private EndInstr end;

	public Block(Ident label, EndInstr end) {
		this.label = label;
		this.instrs = new ArrayList<Instr>();
		this.end = end;
	}

	public EndInstr getEnd() {
		return end;
	}

	public void setEnd(EndInstr end) {
		this.end = end;
	}
	
	public void addInstr(Instr i) {
		instrs.add(i);
	}

	public void print() {
		System.out.println("  "+this.label.toString()+":");
		for (Instr instr : this.instrs)
			System.out.println("    "+instr);
		System.out.println("    "+this.end);		
	}
}
