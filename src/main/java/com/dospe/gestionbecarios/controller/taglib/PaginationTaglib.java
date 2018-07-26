package com.dospe.gestionbecarios.controller.taglib;

import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//https://github.com/gitekiras/Spring-Hibernate-Bootstrap-Pagination/blob/master/src/main/java/com/ekiras/taglib/PaginationTaglib.java
public class PaginationTaglib extends SimpleTagSupport{
	private String uri;
	private int offset;
	private int count;
	private int max = 10;
	private int steps = 10;
	private String previous = "Anterior";
	private String next = "Siguiente";

	private Writer getWriter(){
		JspWriter out = getJspContext().getOut();
		return out;
	}
	
	private String constructLink(int page, String text, String className, boolean disabled){
		StringBuilder link = new StringBuilder("<li");
		
		if(className != null){
			link.append(" class=\"");
			link.append(className);
			link.append("\"");
		}
		
		if (disabled)
			link.append(">").append("<a class=\"page-link\" href=\"#\">"+text+"</a></li>");
		else
			link.append(">").append("<a class=\"page-link\" href=\"" + uri + "?offset="+ page + "\">"+text+"</a></li>");
		
		return link.toString();
	}
	
	
	@Override
	public void doTag() throws JspException {
		Writer out = getWriter();
		try {
			out.write("<nav>");
			out.write("<ul class=\"pagination pagination-sm justify-content-start\">");
			
			if(offset < steps)
				out.write(constructLink(1, previous, "page-item disabled", true));
			else
				out.write(constructLink(offset-steps, previous, "page-item", false));
			
			for(int index = 0; index < count; index+=steps){
				if(offset == index)
					out.write(constructLink((index/10+1)-1 * steps, String.valueOf(index/10+1), "page-item active", true));
				else
					out.write(constructLink(index/10*steps, String.valueOf(index/10+1), "page-item", false));
			}

			if (offset+steps>=count)
				out.write(constructLink(offset+steps, next, "page-item disabled", true));
			else
				out.write(constructLink(offset+steps, next, "page-item", false));
		
			out.write("</ul>");
			out.write("</nav>");
		} catch (java.io.IOException ex){
			throw new JspException("Error in Paginator Tag", ex);
		}
	}
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getSteps() {
		return steps;
	}
	public void setSteps(int steps) {
		this.steps = steps;
	}
	public String getprevious() {
		return previous;
	}
	public void setprevious(String previous) {
		this.previous = previous;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	
}
