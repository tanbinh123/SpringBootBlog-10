package com.yrx.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="t_comment")
public class Comment {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nickname;
	private String email;
	private String content;
	private String avatar;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	
	@ManyToOne
	private Blog blog;
	
	private boolean adminComment;
	
	public boolean isAdminComment() {
		return adminComment;
	}

	public void setAdminComment(boolean adminComment) {
		this.adminComment = adminComment;
	}

	@OneToMany(mappedBy="parentComment")
	private List<Comment> replyComments=new ArrayList<>();
	@ManyToOne
	private Comment parentComment;

	public Blog getBlog() {
		return blog;
	}

	public List<Comment> getReplyComments() {
		return replyComments;
	}

	public void setReplyComments(List<Comment> replyComments) {
		this.replyComments = replyComments;
	}

	public Comment getParentComment() {
		return parentComment;
	}

	public void setParentComment(Comment parentComment) {
		this.parentComment = parentComment;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Comment() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", nickname=" + nickname + ", email=" + email + ", content=" + content
				+ ", avatar=" + avatar + ", createTime=" + createTime + ", blog=" + blog + ", adminComment="
				+ adminComment + ", replyComments=" + replyComments + ", parentComment=" + parentComment + "]";
	}

	
	
}
