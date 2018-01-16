package rtl;

public interface EndInstrVisitor<V> {

	public V visit(Goto g);
	public V visit(Branch br);
	public V visit(Return r);	
	
}
