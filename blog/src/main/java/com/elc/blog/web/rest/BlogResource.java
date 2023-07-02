package com.elc.blog.web.rest;

import com.elc.blog.entitity.Blog;
import com.elc.blog.entitity.Post;
import com.elc.blog.repository.BlogRepository;
import com.elc.blog.repository.PostRepository;
import com.elc.blog.repository.TagRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/blogs")
@AllArgsConstructor
@Slf4j
public class BlogResource {
    private final BlogRepository blogRepository;
    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<Page<Blog>> findBlogsByUser(@PathVariable Long userId, Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(blogRepository.findByUserId(userId, pageable));
    }

    @GetMapping
    public ResponseEntity<Page<Blog>> findAllBlogs(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(blogRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
        return ResponseEntity.status(HttpStatus.CREATED).body(blogRepository.save(blog));
    }

    @PutMapping
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(blogRepository.save(blog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id){
        blogRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Posts
     */
    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> findByBlog(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.findByBlogId(id));
    }
    @PostMapping("/{id}/posts")
    public ResponseEntity<Post> addPost(@PathVariable Long id, @RequestBody Post post){
        Blog blog = blogRepository.findById(id).orElseThrow();
        blog.getPosts().add(post);
        blogRepository.save(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(post));
    }

    @PutMapping("/posts")
    public ResponseEntity<Post> updatePost(@RequestBody Post post){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(postRepository.save(post));
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId){
        postRepository.deleteById(postId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Tags
     */

}
