package rtl;

public class Goto implements EndInstr{
	public final Block target;
	
	public Goto(Block target) {
		this.target = target;
	}

	public String toString() {
		return "goto "+target.label.toString();
	}
	
	public <V> V accept(EndInstrVisitor<V> v) {
		return v.visit(this);
	}

}
