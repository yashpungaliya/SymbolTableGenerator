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
	

	public TableEntry insert(String name,String kind,String type) {
		System.out.println(kind+" : "+type+" "+name);
		for(TableEntry entry:entries) {
			if(entry.getId().equals(name)) {
				System.out.println("Already Exists");
					return null;
			}
		}

		TableEntry newEntry=new TableEntry(name,kind,type);
		System.out.println("Entering...");
		

		return newEntry;
	}
	public TableEntry lookup(String name,SymbolTable st) {
			for(TableEntry entry:st.entries) {
			if(entry.getId().equals(name)) {
				System.out.println("Entry Found");
				return entry;
			}
			System.out.println("Not found in current scope,searching in parent...");

			}
			if(st.parent!=null)
				return lookup(name,st.parent);
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
		System.out.println("Enter task:\n"
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
			case "E":System.out.println("Entering a new scope");
				try {
					st = st.enter_scope(st);
				} catch (Exception e) {
					System.out.print("Error, you have exited the table structure...");
				}
				break;
			case "X":System.out.println("Exiting scope");
							
				try {
					st = st.exit_scope(st);
				} catch (Exception e) {
					System.out.print("Error, you have exited the table structure...");
				}
				break;
			case "L":System.out.println("What do you want to lookup? ");
							String name=s.next();
				try {
					TableEntry t = st.lookup(name, st);
					if (t != null)
						System.out.println(t);
					else
						System.out.println("Not Found");
				} catch (Exception e) {
					System.out.println("Error...");
				}
				break;				
			case "S":System.out.println("Enter \t<name> \n\t<kind> \n\t<type>");	
							System.out.println("Kind = 'var / 'fun' \nType='void' / 'int' / 'bool' / 'double'");
							String name1=s.next();
							String kind=s.next();
							String type=s.next();
				try {
					st.entries.add(st.insert(name1, kind, type));
					//System.out.println("Entry Added");
					if (kind.equalsIgnoreCase("fun")) {
						System.out.println("Enter number of parameters : (0/1/2) ");
						int num_par;
						num_par = s.nextInt();
						if (num_par == 1) {
							System.out.println("Enter parameter 1: \n\t<name>\n\t<type>");
							String name2 = s.next();
							String type2 = s.next();
							String par = "par";
							st.entries.add(st.insert(name2, par, type2));
							System.out.println("Parameter added");
						} else if (num_par == 2) {
							String par = "par";
							System.out.println("Enter parameter 1: \n\t<name>\n\t<type>");
							String namepar1 = s.next();
							String typepar1 = s.next();
							st.entries.add(st.insert(namepar1, par, typepar1));
							System.out.println("Parameter added");

							System.out.println("Enter parameter 2: \n\t<name>\n\t<type>");
							String namepar2 = s.next();
							String typepar2 = s.next();
							st.entries.add(st.insert(namepar2, par, typepar2));
							System.out.println("Parameter added");
						} else
							System.out.println("Nothing to Add");

					} 
				} catch (Exception e) {
					System.out.println("Error...");
				}
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
