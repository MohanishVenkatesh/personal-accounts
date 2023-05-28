package com.mohanish.personalaccounts.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ACCOUNT_CATEGORY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer AccountCategoryId;

    @Column(length = 150)
    private String AccountCategoryDesc;


}
