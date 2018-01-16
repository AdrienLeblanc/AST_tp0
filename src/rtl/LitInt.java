package rtl;

public class LitInt implements Operand {
	private final int val;

	public LitInt(int val) {
		this.val = val;
	}

	public int getVal() { return val; }
	
	public String toString() {
		return Integer.toString(val);
	}

	public <V> V accept(OperandVisitor<V> v) {
		return v.visit(this);
	}
}

