package com.yrx.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yrx.po.Blog;

public interface BlogRepository  extends JpaRepository<Blog,Long>,JpaSpecificationExecutor<Blog>{
	  @Query("select b from Blog b where b.recommend = true")
	    List<Blog> findTop(Pageable pageable);
	    //首页查询方法
	    @Query("select b from Blog b where b.title like ?1 or b.content like ?1")
	    Page<Blog> findByQuery(String query, Pageable pageable);


	    @Transactional
	    @Modifying
	    @Query("update Blog b set b.views = b.views+1 where b.id = ?1")
	    int updateViews(Long id);

	    @Query("select function('date_format',b.updateTime,'%Y') as year from Blog b group by function('date_format',b.updateTime,'%Y') order by year desc ")
	    List<String> findGroupYear();

	    @Query("select b from Blog b where function('date_format',b.updateTime,'%Y') = ?1")
	    List<Blog> findByYear(String year);
}
