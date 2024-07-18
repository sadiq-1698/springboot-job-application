package com.sadiq1698.firstjobapp.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getaLLCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@RequestBody Company company, @PathVariable Long id) {
        if(companyService.updateCompany(company, id)) {
            return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed updating company", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) {
        boolean isDeleted = companyService.deleteCompany(id);
        if (isDeleted) return new ResponseEntity<String>("Company Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<String>("Failed Deleting company", HttpStatus.NOT_FOUND);
    }
}
