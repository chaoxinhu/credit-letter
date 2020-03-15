pragma solidity ^0.4.25;

/**
 * @title Credit letter
 * Credit letter instance created from factory / manager.
 */

 contract CreditLetter {
    // Issuer of the credit letter (开证人)
    address private issuer;
    // Current holder of the credit letter (持证人)
    address private holder;
    // Acceptor of the credit (承兑人)
    address private acceptor;
    // Issuance timestamp (发证日期)
    uint256 private issuanceTime;
    // Interest rate (利率，需要和base结合使用)
    uint256 private interestRate;
    // Credit (信用证额度)
    uint256 private credit;

    // 状态定义相关
    // 状态：是否已批准
    bool private statusApproved = false;
    // 状态：是否已兑付
    bool private statusPaid = false;
    // 标志位编码
    uint256 private STATUS_APPROVED_ID = 0;
    uint256 private STATUS_PAID_ID = 1;
    event StatusChanged(uint256 id, bool latestStatus, uint256 timestamp);

    // 流转记录相关
    address[] private holderChangeHistory;
    uint256[] private holderChangeTimestamps;
    event HolderChanged(address from, address to, uint256 timestamp);

    // 额度改变相关
    event CreditChanged(uint256 original, uint256 amount, uint256 timestamp);

    constructor (
        address issuerVal,
        address holderVal,
        address acceptorVal,
        uint256 issuanceTimeVal,
        uint256 interestRateVal,
        uint256 creditVal
    ) public {
        issuer = issuerVal;
        holder = holderVal;
        acceptor = acceptorVal;
        issuanceTime = issuanceTimeVal;
        interestRate = interestRateVal;
        credit = creditVal;
        holderChangeHistory.push(holderVal);
        holderChangeTimestamps.push(issuanceTimeVal);
    }

    function getInfo() public view returns (
        address issuerVal,
        address holderVal,
        address acceptorVal,
        uint256 issuanceTimeVal,
        uint256 interestRateVal,
        uint256 creditVal,
        bool approved,
        bool paid
    ) {
        return (issuer, holder, acceptor, issuanceTime, interestRate, credit, statusApproved, statusPaid);
    }

    function setStatusApproved(bool status, uint256 timestamp) public {
        require (timestamp > 0);
        // 只有承兑人或开证人才能改变批准状态
        require (msg.sender == acceptor || msg.sender == issuer, "Only acceptor or issuer can approve");
        statusApproved = status;
        emit StatusChanged(STATUS_APPROVED_ID, status, timestamp);
    }

    function setStatusPaid(bool status, uint256 timestamp) public {
        require (timestamp > 0);
        // 只有承兑人才能改变兑付状态
        require (msg.sender == acceptor, "Only acceptor can pay");
        statusPaid = status;
        emit StatusChanged(STATUS_PAID_ID, status, timestamp);
    }

    function transfer(address to, uint256 timestamp) public {
        require (holder != to);
        require (timestamp > 0);
        // 只有当前的持证人才能流转
        require (msg.sender == holder, "Only holder can transfer");
        holder = to;
        holderChangeHistory.push(msg.sender);
        holderChangeTimestamps.push(timestamp);
        emit HolderChanged(msg.sender, to, timestamp);
    }

    function getAllTransferLogs() public view returns (address[], uint256[]) {
        // 只有发证人和持证人才能查看流转记录
        require (msg.sender == issuer || msg.sender == acceptor, "Only issuer or acceptor can check transfer logs");
        return (holderChangeHistory, holderChangeTimestamps);
    }

    function resetCreditAmount(uint256 amount, uint256 timestamp) public {
        // 思考题：为什么要用tx.origin？
        require (tx.origin == issuer || tx.origin == acceptor, "Only issuer or acceptor can reset credit amount");
        credit = amount;
        emit CreditChanged(credit, amount, timestamp);
    }
}