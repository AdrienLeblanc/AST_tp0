package tp0;

import rtl.graph.Graph;
import rtl.graph.Graph.Node;
import rtl.graph.FlowGraph;
import rtl.*;
import rtl.interpreter.Eval;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RtlFlowGraph extends FlowGraph {

	Map <Node, Object> instrMap;
	Map <Node, Set<Ident>> useMap;
	Map <Node, Set<Ident>> defMap;
	Map <Node, Object> isMoveMap;

	public RtlFlowGraph(Function f) {
		super();
		this.instrMap 	= new Hashtable <Node, Object>();
		this.useMap 	= new Hashtable <Node, Set<Ident>>();
		this.defMap 	= new Hashtable <Node, Set<Ident>>();
		this.isMoveMap 	= new Hashtable <Node, Object>();
		
		for (Block b : f.blocks) {
			Node previous = null;
			Node first = null;
			for (Instr i : b.instrs) {
				Node n = buildNode(i);
				if (previous == null) first = n;
				else {
					this.addEdge(previous, n);
					previous = n;
				}
			}
			Node last = buildNode((Instr) b.getEnd());
			if (previous == null) first = last;
			else this.addEdge(previous, last);
		}
	}
	
	public Node buildNode (Instr i) {
		Node n = this.new Node();
		instrMap.put(n, i);
		UseDefInstr v = new UseDefInstr();
		i.accept(v);
		useMap.put(n, v.use);
		defMap.put(n, v.def);
		return n;
	}

	public Object instr(Node n) {
		return null;
	}

	public Set<Ident> def(Node node) {
		return null; //TODO
	}

	public Set<Ident> use(Node node) {
		return null; //TODO
	}

	public boolean isMove(Node node) {
		return false; //TODO
	}

	class UseDefInstr implements InstrVisitor{

		Set<Ident> use = new HashSet<Ident>();
		Set<Ident> def = new HashSet<Ident>();

		public UseDefInstr(){};

		@Override
		public void visit(Assign a) {
			def.add(a.ident);
			if (a.operand instanceof Ident)
				use.add((Ident) a.operand);
		}

		@Override
		public void visit(BuiltIn bi) {
			if (bi.operator != "PrintInt") {
				def.add(bi.target);
			}
			if (bi.operator == "printInt" || bi.operator == "Alloc") {
				use.add((Ident) bi.args.get(0));
			} else {
				use.add((Ident) bi.args.get(0));
				use.add((Ident) bi.args.get(1));
			}
		}

		@Override
		public void visit(Call c) {
			def.add(c.target);
			Iterator<Operand> it = c.args.iterator();
			int cpt = 0;
			while (it.hasNext()) {
				use.add((Ident) c.args.get(cpt));
				cpt++;
				it.next();
			}
		}

		@Override
		public void visit(MemRead mr) {

		}

		@Override
		public void visit(MemWrite mw) {

		}

	}

	public static void main(String[] args) {
		try {
			String mypath = "/private/student/7/17/15006817/workspace/TP0/src"; //mettre votre chemin absolu
			Program prog = rtl.Parser.run(new FileInputStream(mypath+"/rtl/examples/Factorial.rtl")); 
			for (Function f: prog.functions) {
				System.out.println("func "+f.name.toString());
				new RtlFlowGraph(f).show(System.out);
			}
		} catch (Throwable e) {
			System.out.println("RTL flow graph generator failed: " + e.getMessage());
		}

	}

}
