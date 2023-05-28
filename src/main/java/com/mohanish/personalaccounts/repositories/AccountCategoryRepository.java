package com.mohanish.personalaccounts.repositories;

import com.mohanish.personalaccounts.models.AccountCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import java.util.Optional;

public interface AccountCategoryRepository extends JpaRepository<AccountCategory,Integer> {
    Optional<AccountCategory> findByAccountCategoryDescLikeIgnoreCase(@NonNull String accountCategoryDesc);


}
