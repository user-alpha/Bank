CREATE DATABASE Bank;

USE Bank;

CREATE TABLE BankAccount (
    AccountNo double NOT NULL PRIMARY KEY,
    OwnerName varchar(50) NOT NULL,
    balance double NOT NULL
);

SET @AccountNo = 12345,
    @OwnerName = 'John Doe',
    @balance = 100.00;
INSERT INTO BankAccount
(AccountNo, OwnerName, balance)
VALUES
    (@AccountNo, @OwnerName, @balance);
    
UPDATE  bankaccount SET balance = @balance WHERE AccountNo = 12345;

