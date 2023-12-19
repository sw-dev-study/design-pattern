package step4;

import step4.account.Account;
import step4.account.AccountServiceV4;
import step4.credit.CreditInfoService;

import java.util.List;

//클라이언트가 접근하는 클래스 -> 퍼사드 패턴 적용.
public class FinancialServiceV4Impl implements FinancialService {

    private Account accountService;
    private CreditInfoService creditInfoService;

    public FinancialServiceV4Impl(Account account, CreditInfoService creditInfoService){
        this.accountService = account;
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
