package azure.keyvault;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RequestWSLogin {

	private int type;
	
	private List<String> source;
	
	public RequestWSLogin() {
		
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<String> getSource() {
		return source;
	}

	public void setSource(List<String> source) {
		this.source = source;
	}
	
	public void addSource(String value) {
		if(Objects.isNull(source)) {
			source = new ArrayList<String>();
		}
		source.add(source.size(), value);
	}
}
