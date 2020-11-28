package com.online.shopping.models;

public class Message {
	String subject;
	String text;
	String to;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(String subject, String text, String to) {
		super();
		this.subject = subject;
		this.text = text;
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	

}
