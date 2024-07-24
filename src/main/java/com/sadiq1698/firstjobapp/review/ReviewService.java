package com.sadiq1698.firstjobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean createReview(Long companyId, Review review);
    Review getAReview(Long companyId, Long id);
    boolean updateAReview(Long companyId, Long id, Review review);
    boolean deleteAReview(Long companyId, Long id);
}
