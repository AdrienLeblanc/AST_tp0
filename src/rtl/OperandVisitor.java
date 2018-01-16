package rtl;

public interface OperandVisitor<V> {

	public V visit(Ident id);
	public V visit(LitInt li);
	
}
