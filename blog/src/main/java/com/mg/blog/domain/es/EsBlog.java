package com.mg.blog.domain.es;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
/**
 * blog es 类
 * @author miaogang
 *
 */
@Document(indexName="blog" ,type="blog")
public class EsBlog implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String title;
	private String content;
	
	
	
	protected EsBlog( ) {
		
	}
	public EsBlog( String title, String content) {
		this.title = title;
		this.content = content;
	}
	public EsBlog(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
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
	@Override
	public String toString() {
		return String.format("EsBlog [id='%d',title='%s',content='%s']", id,title,content);
	}
	
	
	
	

}
