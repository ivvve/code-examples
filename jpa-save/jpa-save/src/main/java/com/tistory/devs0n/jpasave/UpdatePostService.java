package com.tistory.devs0n.jpasave;

import io.hypersistence.utils.spring.repository.HibernateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UpdatePostService {
    private final PostRepository postRepository;

    public UpdatePostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void update(Long postId, String title, String content) {
        var post = this.postRepository.findById(postId).orElseThrow();
        post.update(title, content);
//        this.postRepository.save(post);
        this.postRepository.update(post);
    }
}

@Repository
interface PostRepository extends HibernateRepository<Post>, JpaRepository<Post, Long> {
}
