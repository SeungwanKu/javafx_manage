package application;

import javafx.beans.property.StringProperty;

public class TableRowDataModel {
	private StringProperty name;
	private StringProperty num;
	private StringProperty code;
	private StringProperty etc;
	
	public TableRowDataModel(StringProperty name,StringProperty num,StringProperty code,StringProperty etc) {
		this.name = name;
		this.num = num;
		this.code = code;
		this.etc = etc;
	}
	
	public StringProperty nameProperty(){
		return name;
	}
	
	public StringProperty numProperty(){
		return num;
	}
	
	public StringProperty codeProperty(){
		return code;
	}
	
	public StringProperty etcProperty(){
		return etc;
	}
}
