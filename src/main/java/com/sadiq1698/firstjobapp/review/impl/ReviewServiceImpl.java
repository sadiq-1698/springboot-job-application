package com.sadiq1698.firstjobapp.review.impl;

import com.sadiq1698.firstjobapp.review.Review;
import com.sadiq1698.firstjobapp.review.ReviewRepository;
import com.sadiq1698.firstjobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =  reviewRepository.findByCompanyId(companyId);
        return reviews;
    }
}
