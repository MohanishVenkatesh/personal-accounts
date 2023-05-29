package com.mohanish.personalaccounts.controllers;

import com.mohanish.personalaccounts.dtos.ErrorResponse;
import com.mohanish.personalaccounts.services.AccountCategoryService;
import com.mohanish.personalaccounts.models.AccountCategory;
import com.mohanish.personalaccounts.validations.Sanitized;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/account-category")
@RequiredArgsConstructor
@Slf4j
@Validated
@Tag(name = "Account Category")
public class AccountCategoryController {
    private final AccountCategoryService accountCategoryService;

    @PostMapping
    @Operation(summary = "This endpoint used to create Account Category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Account Category Created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AccountCategory.class))),
            @ApiResponse(responseCode = "409", description = "Account Category with same name already exists",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "400", description = "Input contains invalid characters.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<AccountCategory> createAccountCategory(@RequestParam("accountCategoryDesc")
//                                                                 @Parameter(in = ParameterIn.QUERY, name = "accountCategoryDesc",
//                                                                             examples = {
//                                                                                     @ExampleObject(name = "Example 1", value = "Category 1"),
//                                                                                     @ExampleObject(name = "Example 2", value = "Category 2"),
//                                                                                     @ExampleObject(name = "Example 3", value = "Category 3")
//                                                                             })
                                                                 @Sanitized
                                                                 //@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Invalid parameter")
                                                                 String accountCategoryDesc) {
        log.info("<->Inside createAccountCategory method");
        AccountCategory accountCategory = accountCategoryService.save(accountCategoryDesc.trim());
        log.info("<->Exit createAccountCategory method");
        return ResponseEntity
                .created(URI.create("/test")) // TODO: RETURN THE CREATED RESOURCE URI.
                .body(accountCategory);
    }

}
