package rtl;

import java.util.List;

public class BuiltIn implements Instr {

	public final String operator; // "Alloc", "PrintInt", "Add", "Sub", "Mul", "And", "Lt"
	public final Ident target; // null if no target
	public final List<Operand> args;

	public BuiltIn(String operator, Ident target, List<Operand> args) {
		this.operator = operator;
		this	.target = target;
		this.args = args;
	}

	public String toString() {
		String res = "";
		if (target!=null) res = target.toString()+" = ";
		res = res+operator+"("+Call.stringOfList(args)+")";
		return res;
	}	

	public void accept(InstrVisitor v) {
		v.visit(this);
	}
}
