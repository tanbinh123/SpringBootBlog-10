package com.yrx.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yrx.po.Blog;
import com.yrx.vo.BlogQuery;

public interface BlogService {
	Blog getBlog(Long id);
	
	Blog getAndConvert(Long id);
	
	Page<Blog> listBlog(Pageable pageable,BlogQuery blog);
	
	Page<Blog> listBlog(Pageable pageable);
	
	Page<Blog> listBlog(String query, Pageable pageable);
	
	Blog saveBlog(Blog blog);
	
	Blog updateBlog(Long id,Blog blog);
	
	void deleteBlog(Long id);
	
	Long countBlog();
	List<Blog> listRecommendBlogTop(Integer size);
	
	Page<Blog> listBlog(Long tagId,Pageable pageable);
	
	Map<String,List<Blog>> archiveBlog();
}
