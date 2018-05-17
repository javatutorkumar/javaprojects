package com.jpa.examples.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.examples.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}