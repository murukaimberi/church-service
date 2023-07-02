package com.elc.blog.entitity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "blogs")
public class Blog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "blog_name", nullable = false)
    private String name;
    @Column(name = "blog_handle", nullable = false)
    private String handle;
    @OneToMany(mappedBy = "blog")
    private List<Post> posts;
    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;
}
