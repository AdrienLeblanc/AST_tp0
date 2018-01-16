package rtl;

public class MemRef {
	public final Ident ident;
	public final int offset;

	public MemRef(Ident ident, int offset) {
		this.ident = ident;
		this.offset = offset;
	}

	public String toString() {
		String offsetString;
		if (offset==0) offsetString = "";
		else if (offset>0) offsetString = "+"+offset;
		else offsetString = ""+offset;
		return "["+ident.toString()+offsetString+"]";
	}
}

