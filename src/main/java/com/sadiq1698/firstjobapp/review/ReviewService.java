package com.sadiq1698.firstjobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
}
