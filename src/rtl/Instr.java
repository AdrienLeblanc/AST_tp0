package rtl;

public interface Instr {

	public void accept(InstrVisitor v);
	
}

