package rtl;

public interface EndInstr {

	public <V> V accept(EndInstrVisitor<V> v);
	
}

