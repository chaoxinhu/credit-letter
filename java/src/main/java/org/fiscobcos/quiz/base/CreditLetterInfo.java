package org.fiscobcos.quiz.base;

import lombok.Data;

@Data
public class CreditLetterInfo {
    private String issuer;
    private String holder;
    private String acceptor;
    private Long timestamp;
    private Integer interestRate;
    private Integer credit;
    private Boolean approved;
    private Boolean paid;
}
