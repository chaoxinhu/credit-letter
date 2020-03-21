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
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.fiscobcos.quiz.constants.GasConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * CreditLetterService
 *
 * @Description: CreditLetterService
 * @author graysonzhang
 * @data 2019-05-08 16:09:43
 *
 */
@Service
@Slf4j
public class CreditLetterService {
    @Autowired 
    private Web3j web3j;
    @Autowired 
    private Credentials credentials;
    
    public LAGCredit deploy() {
        LAGCredit lagCredit = null;
        try {
            lagCredit = LAGCredit.deploy(web3j, credentials, new StaticGasProvider(
                    GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), new BigInteger("100000"), "LAGC", "LAG").send();
            log.info("LAGC address is {}", lagCredit.getContractAddress());
            return lagCredit;
        } catch (Exception e) {
          log.error("deploy lacg contract fail: {}", e.getMessage());
        }  
        return lagCredit;
    }
    
    public LAGCredit load(String creditAddress){
        LAGCredit lagCredit = LAGCredit.load(creditAddress, web3j, credentials, new StaticGasProvider(
                    GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        return lagCredit;
    }
    
    public boolean transfer(String creditAddress, String to, BigInteger value){
        try {
            LAGCredit lagCredit = load(creditAddress);
            TransactionReceipt receipt = lagCredit.transfer(to, value).send();
            log.info("status : {}", receipt.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public long getBalanceByOwner(String creditAddress, String owner) throws Exception{
        LAGCredit lagCredit = load(creditAddress);
        BigInteger balance = lagCredit.balanceOf(owner).send();
        return balance.longValue();
    }
    
    public long getTotalSupply(String creditAddress) throws Exception{
        LAGCredit lagCredit = load(creditAddress);
        BigInteger total = lagCredit.getTotalSupply().send();
        return total.longValue();
    }

}
