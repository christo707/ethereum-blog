package com.blogdapp.VO;

public class BlogVO {
	
	private int id;
	private long epoch;
	private String owner;
	private String title;
	private String typeOf;
	private String content;
	private int totalReactions;
	private int toalComments;
	public BlogVO(int id, long epoch, String owner, String title, String typeOf, String content, int totalReactions,
			int toalComments) {
		super();
		this.id = id;
		this.epoch = epoch;
		this.owner = owner;
		this.title = title;
		this.typeOf = typeOf;
		this.content = content;
		this.totalReactions = totalReactions;
		this.toalComments = toalComments;
	}
	public BlogVO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getEpoch() {
		return epoch;
	}
	public void setEpoch(long epoch) {
		this.epoch = epoch;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
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
	public int getTotalReactions() {
		return totalReactions;
	}
	public void setTotalReactions(int totalReactions) {
		this.totalReactions = totalReactions;
	}
	public int getToalComments() {
		return toalComments;
	}
	public void setToalComments(int toalComments) {
		this.toalComments = toalComments;
	}
	@Override
	public String toString() {
		return "BlogVO [id=" + id + ", epoch=" + epoch + ", owner=" + owner + ", title=" + title + ", typeOf=" + typeOf
				+ ", content=" + content + ", totalReactions=" + totalReactions + ", toalComments=" + toalComments
				+ "]";
	}
	
	
	

}
