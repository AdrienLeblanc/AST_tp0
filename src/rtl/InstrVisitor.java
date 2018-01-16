package rtl;

public interface InstrVisitor {
	
	public void visit(Assign a);
	public void visit(BuiltIn bi);
	public void visit(Call c);
	public void visit(MemRead mr);
	public void visit(MemWrite mw);

}
