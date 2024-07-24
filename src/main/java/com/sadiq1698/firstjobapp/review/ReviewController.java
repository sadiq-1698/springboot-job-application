package com.sadiq1698.firstjobapp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}/review")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addAReview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean reviewAdded = reviewService.createReview(companyId, review);
        if(!reviewAdded)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getAReview(@PathVariable Long companyId, @PathVariable Long id) {
        return new ResponseEntity<>(reviewService.getAReview(companyId, id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAReview(@PathVariable Long companyId, @PathVariable Long id, @RequestBody Review review) {
        boolean isUpdated = reviewService.updateAReview(companyId, id, review);
        if(isUpdated)
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        return new ResponseEntity<>("Failed updating review", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAReview(@PathVariable Long companyId, @PathVariable Long id) {
        boolean isDeleted = reviewService.deleteAReview(companyId, id);
        if(isDeleted)
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>("Failed deleting review", HttpStatus.NOT_FOUND);
    }

}
