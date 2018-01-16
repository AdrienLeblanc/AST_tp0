package rtl;

public class MemWrite implements Instr {
	public final MemRef memRef;
	public final Operand operand;

	public MemWrite(MemRef mr, Operand o) {
		memRef = mr;
		operand = o;
	}

	public String toString() {
		return memRef.toString()+" = "+operand.toString();
	}

	public void accept(InstrVisitor v) {
		v.visit(this);
	}
}

