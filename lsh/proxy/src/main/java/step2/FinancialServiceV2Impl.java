package step2;

import step2.account.AccountServiceV1;
import step2.credit.CreditInfoServiceV1Impl;

import java.util.List;

//클라이언트가 접근하는 클래스 -> 퍼사드 패턴 적용.
public class FinancialServiceV1Impl implements FinancialService {

    private AccountServiceV1 accountService;
    private CreditInfoServiceV1Impl creditInfoService;

    public FinancialServiceV1Impl(AccountServiceV1 accountService, CreditInfoServiceV1Impl creditInfoService){
        this.accountService = accountService;
        this.creditInfoService = creditInfoService;
    }

    //계좌에 돈 넣기
    public void deposit(int userId, long money){
        accountService.depositMoney(userId, money);
    }

    //계좌 잔액 확인
    public long checkBalance(int userId){
        return accountService.getAccountMoney(userId);
    }

    //모든 계좌 확인.
    public List<String> checkAllAccount(){
        return accountService.getAllAccount();
    }

    //일부 계좌 확인.

    //신용점수 조회서비스
    public int creditScore(){
        return creditInfoService.getCreditScore();
    }

}
