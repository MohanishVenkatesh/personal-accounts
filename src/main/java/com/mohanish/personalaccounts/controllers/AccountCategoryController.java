package com.mohanish.personalaccounts.controllers;

import com.mohanish.personalaccounts.services.AccountCategoryService;
import com.mohanish.personalaccounts.models.AccountCategory;
import com.mohanish.personalaccounts.validations.Sanitized;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/account-category")
@RequiredArgsConstructor
@Slf4j
@Validated
public class AccountCategoryController {
    private final AccountCategoryService accountCategoryService;

    @PostMapping
    public ResponseEntity<AccountCategory> createAccountCategory(@RequestParam("desc") @Sanitized String accountCategoryDesc) {
        log.info("<->Inside createAccountCategory method");
        AccountCategory accountCategory = accountCategoryService.save(accountCategoryDesc);
        log.info("<->Exit createAccountCategory method");
        return ResponseEntity
                .created(URI.create("/test")) // TODO: RETURN THE CREATED RESOURCE URI.
                .body(accountCategory);
    }

}
