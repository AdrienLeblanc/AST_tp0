package rtl;

public class Branch implements EndInstr {

	public final Operand condition;
	public final Block thenTarget;
	public final Block elseTarget;
	
	public Branch(Operand condition, Block thenTarget, Block elseTarget) {
		this.condition = condition;
		this.thenTarget = thenTarget;
		this.elseTarget = elseTarget;
	}

	public String toString() {
		return "if "+condition.toString()+
				" goto "+thenTarget.label.toString()+
				" else "+elseTarget.label.toString();
	}
	
	public <V> V accept(EndInstrVisitor<V> v) {
		return v.visit(this);
	}
	
}
