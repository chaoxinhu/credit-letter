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
package org.fiscobcos.quiz.tools;

import org.fisco.bcos.web3j.crypto.ECKeyPair;
import org.fisco.bcos.web3j.crypto.Keys;
import org.fisco.bcos.web3j.utils.Numeric;

import lombok.extern.slf4j.Slf4j;

/**
 * UserKeyUtils
 *
 * @Description: UserKeyUtils
 * @author graysonzhang
 * @data 2019-05-08 15:19:50
 *
 */
@Slf4j
public class UserKeyUtils{
    
    static final int PUBLIC_KEY_SIZE = 64;
    static final int PUBLIC_KEY_LENGTH_IN_HEX = PUBLIC_KEY_SIZE << 1;

    public static void createUserKey() {
        try {
            ECKeyPair keyPair = Keys.createEcKeyPair();
            String publicKey = Numeric.toHexStringWithPrefixZeroPadded(keyPair.getPublicKey(), PUBLIC_KEY_LENGTH_IN_HEX);
            String privateKey = Numeric.toHexStringNoPrefix(keyPair.getPrivateKey());
            String address = "0x" + Keys.getAddress(publicKey);

            System.out.println("public key :" +  publicKey);
            System.out.println("private key:" + privateKey);
            System.out.println("address :" + address);
            
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    
    public static void main(String[] args) {
        createUserKey();
    }

}
