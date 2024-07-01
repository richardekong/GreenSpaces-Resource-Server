package com.daveace.greenspaces.comment;

import com.daveace.greenspaces.park.Park;

import java.time.Instant;

public class CommentDTO {

    private String id;
    private String author;
    private String text;
    private int views;
    private int likes;
    private int dislikes;
    private int ratings;
    private Park park;
    private Instant postedOn;
    private Instant modifiedAt;

    public CommentDTO() {
    }

    public CommentDTO(Comment comment){
        id = comment.getId();
        author = comment.getAuthor();
        text = comment.getText();
        views = comment.getViews();
        likes = comment.getLikes();
        dislikes=comment.getDislikes();
        ratings=comment.getRatings();
        park = comment.getPark();
        postedOn=comment.getPostedOn();
        modifiedAt=comment.getModifiedAt();
    }
}
