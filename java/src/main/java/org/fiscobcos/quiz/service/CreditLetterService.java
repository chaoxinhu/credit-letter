/*
 * Copyright 2014-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fiscobcos.quiz.service;

import java.math.BigInteger;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple8;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.fiscobcos.quiz.base.CreditLetterInfo;
import org.fiscobcos.quiz.constants.AddressConstants;
import org.fiscobcos.quiz.constants.GasConstants;
import org.fiscobcos.quiz.contracts.CreditLetter;
import org.fiscobcos.quiz.contracts.CreditLetter.HolderChangedEventResponse;
import org.fiscobcos.quiz.contracts.CreditLetter.StatusChangedEventResponse;
import org.fiscobcos.quiz.contracts.CreditLetterFactory;
import org.fiscobcos.quiz.contracts.CreditLetterFactory.CreateLogEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CreditLetterService
 *
 * @author graysonzhang
 * @Description: CreditLetterService
 */
@Service
@Slf4j
public class CreditLetterService {

    @Autowired
    private Web3j web3j;

    // Factory related methods starts here

    // Factory init
    public String deployFactory() {
        try {
            Credentials credentials = Credentials.create(AddressConstants.DEFAULT_READ_PRIVATE_KEY);
            CreditLetterFactory creditLetterFactory = CreditLetterFactory.deploy(web3j,
                credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT)).send();
            log.info("Factory address is {}", creditLetterFactory.getContractAddress());
            return creditLetterFactory.getContractAddress();
        } catch (Exception e) {
            log.error("deploy factory contract fail: {}", e.getMessage());
        }
        return StringUtils.EMPTY;
    }

    // Letter load
    private CreditLetterFactory loadCreditLetterFactory(String address, String privateKey) {
        Credentials credentials = Credentials.create(privateKey);
        return CreditLetterFactory.load(address, web3j, credentials,
            new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
    }

    // Factory create
    public String createCreditLetter(
        String issuer,
        String holder,
        String acceptor,
        Long issuanceTime,
        Integer interestRate,
        Integer credit,
        String factoryAddress,
        String privateKey
    ) {
        try {
            CreditLetterFactory creditLetterFactory = loadCreditLetterFactory(factoryAddress, privateKey);
            TransactionReceipt receipt = creditLetterFactory.create(issuer, holder, acceptor,
                new BigInteger(String.valueOf(issuanceTime), 10),
                new BigInteger(String.valueOf(interestRate), 10),
                new BigInteger(String.valueOf(credit), 10)).send();
            List<CreateLogEventResponse> eventList =
                creditLetterFactory.getCreateLogEvents(receipt);
            for (CreateLogEventResponse event : eventList) {
                if (StringUtils.isEmpty(event.addr)) {
                    continue;
                }
                return event.addr;
            }
        } catch (Exception e) {
            log.error("create letter contract fail: {}", e.getMessage());
        }
        return StringUtils.EMPTY;
    }

    // Factory split
    public String splitCreditLetter(
        String originalCreditLetterAddress,
        Integer amount,
        Integer timestamp,
        String factoryAddress,
        String privateKey
    ) {
        try {
            CreditLetterFactory creditLetterFactory = loadCreditLetterFactory(factoryAddress, privateKey);
            TransactionReceipt receipt = creditLetterFactory.split(originalCreditLetterAddress,
                new BigInteger(String.valueOf(amount), 10),
                new BigInteger(String.valueOf(timestamp), 10)).send();
            List<CreateLogEventResponse> eventList =
                creditLetterFactory.getCreateLogEvents(receipt);
            for (CreateLogEventResponse event : eventList) {
                if (StringUtils.isEmpty(event.addr)) {
                    continue;
                }
                return event.addr;
            }
        } catch (Exception e) {
            log.error("split letter contract fail: {}", e.getMessage());
        }
        return StringUtils.EMPTY;
    }

    // Credit Letter related methods start from here

    // Letter load
    private CreditLetter loadCreditLetter(String address, String privateKey) {
        Credentials credentials = Credentials.create(privateKey);
        return CreditLetter.load(address, web3j, credentials,
            new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
    }

    // Letter getInfo
    public CreditLetterInfo getCreditLetterInfo(String address) {
        CreditLetter creditLetter = loadCreditLetter(address, AddressConstants.DEFAULT_READ_PRIVATE_KEY);
        try {
            Tuple8<String, String, String, BigInteger, BigInteger, BigInteger, Boolean, Boolean> tuple
                = creditLetter.getInfo().send();
            CreditLetterInfo creditLetterInfo = new CreditLetterInfo();
            creditLetterInfo.setIssuer(tuple.getValue1());
            creditLetterInfo.setHolder(tuple.getValue2());
            creditLetterInfo.setAcceptor(tuple.getValue3());
            creditLetterInfo.setTimestamp(tuple.getValue4().longValue());
            creditLetterInfo.setInterestRate(tuple.getValue5().intValue());
            creditLetterInfo.setCredit(tuple.getValue6().intValue());
            creditLetterInfo.setApproved(tuple.getValue7());
            creditLetterInfo.setPaid(tuple.getValue8());
            return creditLetterInfo;
        } catch (Exception e) {
            log.error("get info of letter fail: {}", e.getMessage());
        }
        return null;
    }

    // Letter set status approved
    public Boolean setStatusApproved(String address, Boolean status, Long timestamp, String privateKey) {
        try {
            CreditLetter creditLetter = loadCreditLetter(address, privateKey);
            TransactionReceipt receipt = creditLetter.setStatusApproved(status,
                new BigInteger(String.valueOf(timestamp), 10)).send();
            List<StatusChangedEventResponse> eventList =
                creditLetter.getStatusChangedEvents(receipt);
            for (StatusChangedEventResponse event : eventList) {
                if (event.id.intValue() == BigInteger.ZERO.intValue() &&
                    event.latestStatus.equals(status)) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("set status fail: {}", e.getMessage());
        }
        return false;
    }

    // Letter set status paid
    public Boolean setStatusPaid(String address, Boolean status, Long timestamp, String privateKey) {
        try {
            CreditLetter creditLetter = loadCreditLetter(address, privateKey);
            TransactionReceipt receipt = creditLetter.setStatusPaid(status,
                new BigInteger(String.valueOf(timestamp), 10)).send();
            List<StatusChangedEventResponse> eventList =
                creditLetter.getStatusChangedEvents(receipt);
            for (StatusChangedEventResponse event : eventList) {
                if (event.id.intValue() == BigInteger.ONE.intValue() &&
                    event.latestStatus.equals(status)) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("set status fail: {}", e.getMessage());
        }
        return false;
    }

    // Letter transfer
    public Boolean transfer(String contractAddress, String to, Long timestamp, String privateKey) {
        try {
            CreditLetter creditLetter = loadCreditLetter(contractAddress, privateKey);
            TransactionReceipt receipt = creditLetter.transfer(to,
                new BigInteger(String.valueOf(timestamp), 10)).send();
            List<HolderChangedEventResponse> eventList =
                creditLetter.getHolderChangedEvents(receipt);
            for (HolderChangedEventResponse event : eventList) {
                if (event.to.equalsIgnoreCase(to)) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("set status fail: {}", e.getMessage());
        }
        return false;
    }

    // Letter getAllLogs: finish this by yourselves
}
