package com.mohanish.personalaccounts.services.servicesImpl;

import com.mohanish.personalaccounts.exceptions.EntityAlreadyExistsException;
import com.mohanish.personalaccounts.models.AccountCategory;
import com.mohanish.personalaccounts.repositories.AccountCategoryRepository;
import com.mohanish.personalaccounts.services.AccountCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountCategoryServiceImpl implements AccountCategoryService {
    private final AccountCategoryRepository accountCategoryRepository;

    @Override
    public AccountCategory save(String accountCategoryDesc) {
        log.info("<-> Inside save method AccountCategoryServiceImpl class");
        Optional<AccountCategory> accountCategory = accountCategoryRepository.findByAccountCategoryDescLikeIgnoreCase(accountCategoryDesc);
        if (accountCategory.isPresent()) {
            log.error("<-> Account Category with  Name [{}] Already Present with ID [{}] ", accountCategory.get().getAccountCategoryDesc(), accountCategory.get().getAccountCategoryId());
            throw new EntityAlreadyExistsException("Account Category with the Same Name Already Exists");
        }
        AccountCategory savedAccountCategory = accountCategoryRepository.saveAndFlush(AccountCategory.builder()
                .accountCategoryDesc(accountCategoryDesc)
                .build());
        log.info("<-> Account Category Saved Successfully");
        return savedAccountCategory;
    }
}
