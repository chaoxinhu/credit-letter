pragma solidity ^0.4.25;

import "./CreditLetter.sol";

/**
 * @title Credit letter Factory
 * Credit letter factory, handling creation and split of Credit letter.
 */

contract CreditLetterFactory {
    event CreateLog(address addr, uint256 timestamp);
    
    function create(
        address issuer,
        address holder,
        address acceptor,
        uint256 issuanceTime,
        uint256 interestRate,
        uint256 credit
    ) public {
        CreditLetter creditLetter = new CreditLetter(issuer, holder, acceptor, issuanceTime, interestRate, credit);
        emit CreateLog(creditLetter, issuanceTime);
    }

    function split(address originalAddress, uint256 amount, uint256 timestamp) public {
        CreditLetter originalLetter = CreditLetter(originalAddress);
        (address issuer, address holder, address acceptor, , uint256 interestRate, uint256 credit, , )
            = originalLetter.getInfo();
        originalLetter.resetCreditAmount(credit - amount, timestamp);
        CreditLetter creditLetter = new CreditLetter(issuer, holder, acceptor, timestamp, interestRate, amount);
        emit CreateLog(creditLetter, timestamp);
    }
}