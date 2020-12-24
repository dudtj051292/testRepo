package com.min.edu.dto;


public class AnswerboardDto {

	private String seq;
	private String id;
	private String title;
	private String content;

	private String refer;
	private String step;
	private String depth;
	private String readcount;
	private String delflag;
	private String regdate;
	public AnswerboardDto() {
		super();
	}
	public AnswerboardDto(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRefer() {
		return refer;
	}
	public void setRefer(String refer) {
		this.refer = refer;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getReadcount() {
		return readcount;
	}
	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "AnswerboardDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", refer="
				+ refer + ", step=" + step + ", depth=" + depth + ", readcount=" + readcount + ", delflag=" + delflag
				+ ", regdate=" + regdate + "]";
	}
	
	
}
