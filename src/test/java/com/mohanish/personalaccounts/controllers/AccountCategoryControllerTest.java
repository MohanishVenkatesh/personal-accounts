package com.mohanish.personalaccounts.controllers;

import com.mohanish.personalaccounts.exceptions.EntityAlreadyExistsException;
import com.mohanish.personalaccounts.models.AccountCategory;
import com.mohanish.personalaccounts.services.AccountCategoryService;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

class AccountCategoryControllerTest {
    private final AccountCategoryService accountCategoryService = mock(AccountCategoryService.class);
    private final AccountCategoryController accountCategoryController = new AccountCategoryController(accountCategoryService);

    @Test
    void createAccountCategory_ValidInput_ReturnsCreatedResponse() {
        //Arrange
        String accountCategoryDesc = "Food Delivery";
        AccountCategory savedAccountCategory = new AccountCategory();
        when(accountCategoryService.save(accountCategoryDesc)).thenReturn(savedAccountCategory);

        //Act
        ResponseEntity<AccountCategory> response = accountCategoryController.createAccountCategory(accountCategoryDesc);

        //Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedAccountCategory, response.getBody());
        assertEquals("/test", Objects.requireNonNull(response.getHeaders().getLocation()).getPath()); // Verify the URI path in the Location header
        verify(accountCategoryService).save(accountCategoryDesc.trim());

    }

}