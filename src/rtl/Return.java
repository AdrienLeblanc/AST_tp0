package rtl;

public class Return implements EndInstr {
	public final Operand operand;

	public Return(Operand operand) {
		this.operand = operand;
	}

	public String toString() {
		return "ret "+((operand==null)?"":operand.toString());
	}    
	
	public <V> V accept(EndInstrVisitor<V> v) {
		return v.visit(this);
	}
}

