package com.daveace.greenspaces.comment;

import com.daveace.greenspaces.park.Park;
import com.daveace.greenspaces.util.Constant;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import static com.daveace.greenspaces.util.Constant.INVALID_AUTHOR;
import static com.daveace.greenspaces.util.Regexp.LETTER_REGEX;


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

    @Pattern(regexp = LETTER_REGEX, message = INVALID_AUTHOR)
    @NotBlank
    private String author;

    @NotBlank
    private String text;

    @Min(value=0)
    private int views;

    @Min(value=0)
    private int likes;

    @Min(value=0)
    private int dislikes;

    @Min(value=0)
    private int ratings;

    @NotNull
    private Park park;

    private final Instant postedOn = Instant.now();
    private Instant modifiedAt;

    @PrePersist
    public void onSave(){
        id = UUID.randomUUID().toString();
    }

    @PreUpdate
    public void onUpdate(){
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
