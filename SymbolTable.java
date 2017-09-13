import java.util.ArrayList;
import java.util.Scanner;

public class SymbolTable {
	
	private ArrayList<TableEntry> entries;
	private SymbolTable parent;
	private ArrayList<SymbolTable> children;
	
	public SymbolTable() {
		entries=new ArrayList<>();
		children=new ArrayList<>();
	}
	
	
	public void setParent(SymbolTable parent) {
		this.parent = parent;
	}
	
	private void removeChild(SymbolTable st) {
		children.remove(st);
	}

	public boolean insert(String name,String kind,String type) {
		for(TableEntry entry:entries) {
			if(entry.getId().equals(name)) {
					return false;
			}
		}

		TableEntry newEntry=new TableEntry(name,kind,type);
		entries.add(newEntry);

		return true;
	}
	public TableEntry lookup(String name,SymbolTable st) {
		if(st==null)
			return null;
		for(TableEntry entry:st.entries) {
			if(entry.getId().equals(name)) {
				System.out.println("\nEntry Found");
				return entry;
			}
			System.out.println("\nNot found in current scope,searching in parent...");
			return lookup(name,st.parent);
				
			}
		return null;
			
	}
	public SymbolTable enter_scope(SymbolTable st) {
		SymbolTable newScope=new SymbolTable();
		st.children.add(newScope);
		newScope.setParent(st);
		return newScope;
		
	}
	public SymbolTable exit_scope(SymbolTable st) {
		
		return parent;
		
		
	}
	
	


	public  static void main(String[] args) {
		// TODO Auto-generated method stub
		SymbolTable st=new SymbolTable();
		System.out.println("\nEnter task:\n"
				+ 				"\t1.E for Enter Scope\n"
				+ 				"\t2.X for Exit Scope\n"
				+ 				"\t3.L for Lookup\n"
				+				"\t4.S for Input Symbol Table Entry\n"
				+ 				"\tAny other key to exit...");
		Scanner s=new Scanner(System.in);
		
		
		boolean flag=true;
		while(flag) {
			String input=s.next();
			switch(input) {
			case "E":System.out.println("\nEntering a new scope");
							st=st.enter_scope(st);
							break;
			case "X":System.out.println("\nExiting scope");
							st=st.exit_scope(st);
							break;
			case "L":System.out.println("\nWhat do you want to lookup?\n");
							String name=s.next();
							TableEntry t=st.lookup(name, st);
							if(t!=null)								
								System.out.println(t);
							else
								System.out.println("Not Found");
							break;				
			case "S":System.out.println("\nEnter \t<name> \n\t<kind> \n\t<type>\n");	
							String name1=s.next();
							String kind=s.next();
							String type=s.next();
							boolean b=st.insert(name1,kind,type);
							if(!b)
								System.out.println("\nAlready Present\n");
							else
								System.out.println("\nEntry Added Successfully\n");
							break;
			 default:
							System.out.println("\nExiting...\n");
							flag=false;
							return;
							
			}
						
	
		}
		s.close();
	}



}
