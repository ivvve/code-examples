package com.tistory.devs0n.jpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "replies", joinColumns = @JoinColumn(name = "post_id",referencedColumnName = "id"))
    private List<Reply> replies = new ArrayList<>();

    public Post addReply(Reply reply) {
        this.replies.add(reply);
        return this;
    }

    @Override
    public String toString() {
        return "Post{" +
            "id=" + id +
            ", replies=" + replies +
            '}';
    }
}
