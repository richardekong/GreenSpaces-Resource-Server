package com.daveace.greenspaces.comment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepo repo;

    @Autowired
    public void setRepo(CommentRepo repo) {
        this.repo = repo;
    }
}
