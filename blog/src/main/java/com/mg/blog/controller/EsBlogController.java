package com.mg.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mg.blog.domain.es.EsBlog;
import com.mg.blog.repository.es.EsBlogRepository;

@RestController
@RequestMapping("/blog")
public class EsBlogController {
	@Autowired
	private EsBlogRepository esBlogRepository;

	@GetMapping
	public List<EsBlog> listEsBlogs(
			@RequestParam(value="title") String title,
			@RequestParam(value="content") String content,
			@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
			@RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
			Model model) {
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		Page<EsBlog>  page= esBlogRepository.findByTitleLikeOrContentLike(title,content,pageable);
		return page.getContent();
		
	}

}
