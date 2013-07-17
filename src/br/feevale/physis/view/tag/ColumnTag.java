package br.feevale.physis.view.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ColumnTag extends TagSupport {

	private static final long serialVersionUID = -7643819154476777087L;
	
	private String header;
	private Object value;
	
	public String getHeader() {
		return header;
	}
	
	public void setHeader(String header) {
		this.header = header;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public int doStartTag() throws JspException {
		TableTag table = (TableTag) findAncestorWithClass(this, TableTag.class);
		
		if (table == null) {
			throw new RuntimeException("Eh necessario preceder esse elemento com uma table.");
		}
		
		return EVAL_BODY_AGAIN;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		TableTag table = (TableTag) findAncestorWithClass(this, TableTag.class);
		table.addHeader(header);
		
		return super.doAfterBody();
	}

}
