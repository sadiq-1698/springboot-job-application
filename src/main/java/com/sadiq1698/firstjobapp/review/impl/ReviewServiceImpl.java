package com.sadiq1698.firstjobapp.review.impl;

import com.sadiq1698.firstjobapp.company.Company;
import com.sadiq1698.firstjobapp.company.CompanyRepository;
import com.sadiq1698.firstjobapp.company.CompanyService;
import com.sadiq1698.firstjobapp.review.Review;
import com.sadiq1698.firstjobapp.review.ReviewRepository;
import com.sadiq1698.firstjobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =  reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getAReview(Long companyId, Long id) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean updateAReview(Long companyId, Long id, Review review) {
        Company toBeUpdatedCompany = companyService.getCompanyById(companyId);
        if(toBeUpdatedCompany == null) return false;
        review.setCompany(toBeUpdatedCompany);
        review.setId(id);
        reviewRepository.save(review);
        return true;
    }

    @Override
    public boolean deleteAReview(Long companyId, Long id) {
        Company companyExists = companyService.getCompanyById(companyId);
        if(companyExists == null) return false;

        Review review = reviewRepository.findById(id).orElse(null);
        if(review == null) return false;

        if(!review.getCompany().getId().equals(companyId)) return false;

        reviewRepository.deleteById(id);
        return true;
    }
}
