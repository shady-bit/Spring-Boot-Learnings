package com.web.spring.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.spring.bean.Post;
@Repository
public interface PostRepo  extends JpaRepository<Post, Integer> {

}
