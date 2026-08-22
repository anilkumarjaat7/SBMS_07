package com.p1.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.p1.entity.Review;
import com.p1.repository.ReviewRepository;



@Service
public class ReviewService {

    private ReviewRepository repository;


    public ReviewService(ReviewRepository repository) {

        this.repository = repository;
    }


    // CREATE / UPDATE

    public Review saveReview(Review review) {

        if (review.getCreatedDate() == null) {

            review.setCreatedDate(LocalDate.now());
        }

        return repository.save(review);
    }


    // READ ALL

    public List<Review> getAllReviews() {

        return repository.findAllByOrderByCreatedDateDesc();
    }


    // READ BY COURSE NAME

    public List<Review> getReviewsByCourseName(String courseName) {

        return repository
                .findByCourseNameContainingIgnoreCaseOrderByCreatedDateDesc(courseName);
    }


    // DELETE

    public void deleteReview(int id) {

        repository.deleteById(id);
    }
}