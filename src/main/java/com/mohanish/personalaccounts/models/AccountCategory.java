package com.mohanish.personalaccounts.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ACCOUNT_CATEGORY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_CATEGORY_ID")
    private Integer accountCategoryId;

    @Column(name = "ACCOUNT_CATEGORY_DESC" ,length = 150)
    private String accountCategoryDesc;


}
