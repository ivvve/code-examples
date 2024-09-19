package com.tistory.devs0n.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Reply {
    @Column
    private String content;

    @Override
    public String toString() {
        return "Reply{" +
            "content='" + content + '\'' +
            '}';
    }
}
