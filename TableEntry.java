public class TableEntry{
	private String identifier;
	private String type;
	private String kind;
	
	public TableEntry(){
		identifier="";
		type="";
		kind="";
	}
	public TableEntry(String id,String k,String t){
		identifier=id;
		type=t;
		kind=k;
	}
	public String getId() {
		return identifier;
	}
	public String getType() {
		return type;
	}
	public String getKind() {
		return kind;
	}
	@Override
	public String toString() {
		return "TableEntry [identifier=" + identifier + ", type=" + type + ", kind=" + kind + "]";
	}

	
}