package rtl;

import java.util.List;

public class Call implements Instr {

	public final Ident target;
	private Function callee;
	public final List<Operand> args;
	
	public Call(Ident target, Function callee, List<Operand> args) {
		this.target = target;
		this.callee = callee;
		this.args = args;
	}
	
	public Function getCallee() {
		return callee;
	}

	public void setCallee(Function callee) {
		this.callee = callee;
	}

	public String toString() {
		String res = "";
		if (target!=null) res = target.toString()+" = ";
		res = res+"call "+callee.name.toString()+"("+stringOfList(args)+")";
		return res;
	}
	
	public static String stringOfList(List<Operand> l) {
		String res = "";
		if (l.size()==0) return res;
		if (l.size()==1) return l.get(0).toString();
		res = l.get(0).toString();
		for (int i=1;i<l.size();i++)
			res = res + " " + l.get(i).toString();
		return res;
	}

	public void accept(InstrVisitor v) {
		v.visit(this);
	}
}
