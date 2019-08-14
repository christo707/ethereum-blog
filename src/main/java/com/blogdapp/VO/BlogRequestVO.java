package com.blogdapp.VO;

public class BlogRequestVO {
	
	public String title;
	public String typeOf;
	public String content;
	public BlogRequestVO() {
		super();
	}
	public BlogRequestVO(String title, String typeOf, String content) {
		super();
		this.title = title;
		this.typeOf = typeOf;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTypeOf() {
		return typeOf;
	}
	public void setTypeOf(String typeOf) {
		this.typeOf = typeOf;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "BlogVO [title=" + title + ", typeOf=" + typeOf + ", content=" + content + "]";
	}

}
