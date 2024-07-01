package com.daveace.greenspaces.comment;

import com.daveace.greenspaces.park.Park;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Setter
@Getter
@Entity
@Table(name="comments")
public class Comment {

    @Id
    private String id;
    private String author;
    private String text;
    private int views;
    private int likes;
    private int dislikes;
    private int ratings;
    private Park park;
    private final Instant postedOn = Instant.now();
    private Instant modifiedAt;

    @PrePersist
    public void doBeforePersisting(){
        id = UUID.randomUUID().toString();
        modifiedAt = Instant.now();
    }

    @PreUpdate
    public void doBeforeUpdate(){
        modifiedAt = Instant.now();
    }

    public CommentDTO toDTO(){
        return new CommentDTO(this);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", views=" + views +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", ratings=" + ratings +
                ", park=" + park.getName() +
                ", postedOn=" + postedOn +
                ", modifiedAt=" + modifiedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return views == comment.views
                && likes == comment.likes
                && dislikes == comment.dislikes
                && ratings == comment.ratings
                && Objects.equals(id, comment.id)
                && Objects.equals(author, comment.author)
                && Objects.equals(text, comment.text)
                && Objects.equals(park, comment.park)
                && Objects.equals(postedOn, comment.postedOn)
                && Objects.equals(modifiedAt, comment.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, text, views, likes, dislikes, ratings, park, postedOn, modifiedAt);
    }
}
