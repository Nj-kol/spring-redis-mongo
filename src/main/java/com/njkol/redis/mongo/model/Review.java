package com.njkol.redis.mongo.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * A user review
 * 
 * @author Nilanjan Sarkar
 *
 */
public class Review implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Name of the reviewer")
	private String reviewerName;
	@ApiModelProperty(notes = "Rating given by the user")
	private int rating;
	@ApiModelProperty(notes = "Comment given by the user")
	private String comment;

	public String getReviewerName() {
		return reviewerName;
	}
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + rating;
		result = prime * result + ((reviewerName == null) ? 0 : reviewerName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (rating != other.rating)
			return false;
		if (reviewerName == null) {
			if (other.reviewerName != null)
				return false;
		} else if (!reviewerName.equals(other.reviewerName))
			return false;
		return true;
	}
}