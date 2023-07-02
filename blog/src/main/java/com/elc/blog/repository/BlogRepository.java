package com.elc.blog.repository;

import com.elc.blog.entitity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findByUserId(Long userId, Pageable pageable);
}
