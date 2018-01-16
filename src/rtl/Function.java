package rtl;

import java.util.ArrayList;
import java.util.List;

public class Function {

	public final Ident name;
	public final List<Ident> params;
	public final List<Block> blocks;
	private Block entry;

	public Function(Ident name) {
		this.name = name;
		this.params = new ArrayList<Ident>();
		this.blocks = new ArrayList<Block>();
	}

	public void addBlock(Block b) {
		blocks.add(b);
	}
	
	public void addParam(Ident id) {
		params.add(id);
	}

	public Block getEntry() {
		return entry;
	}

	public void setEntry(Block entry) {
		this.entry = entry;
	}
	
	public void print() {
		System.out.println("func "+this.name.toString()+"("+stringOfList(this.params)+")");
		for (Block b : blocks)
			b.print();
	}

	static String stringOfList(List<Ident> l) {
		String res = "";
		if (l.size()==0) return res;
		if (l.size()==1) return l.get(0).toString();
		res = l.get(0).toString();
		for (int i=1;i<l.size();i++)
			res = res + " " + l.get(i).toString();
		return res;
	}

}
