package br.feevale.physis.view.tag;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TableTag extends BodyTagSupport {

	private static final long serialVersionUID = -1071421111330810042L;
	
	private List<String> header = new ArrayList<String>();
	private List<Object> items;
	
	private String var;
	
	public void addHeader(String header) {
		this.header.add(header);
	}
	
	public List<Object> getItems() {
		return items;
	}
	
	public void setItems(List<Object> items) {
		this.items = items;
	}
	
	public String getVar() {
		return var;
	}
	
	public void setVar(String var) {
		this.var = var;
	}
	
	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		try {
			getBodyContent().append("<table>");
			
			getBodyContent().append("<thead>");
			
			for (String header : this.header) {
				getBodyContent().append(String.format("<th>%s</th>", header));
			}
			
			getBodyContent().append("</thead>");
			
			getBodyContent().append("</table>");
		} catch (Exception e) {
			throw new JspException(e);
		}
		
		return super.doAfterBody();
	}
}
