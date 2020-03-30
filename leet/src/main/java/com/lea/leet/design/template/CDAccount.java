package com.lea.leet.design.template;

// CDAccount
public class CDAccount extends Account {

    @Override
    protected String doCalculateAccountType() {
        return "Certificate of Deposite";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.065D;
    }

    public static void main(String[] args) {

        Account account = new MoneyMarketAccount();
        System.out.println("Interest from Money Market account: " + account.calculateInterest());
        account = new CDAccount();
        System.out.println("Interest from CD account: " + account.calculateInterest());

    }
}
