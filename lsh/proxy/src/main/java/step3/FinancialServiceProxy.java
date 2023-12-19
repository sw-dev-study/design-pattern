package step2;

import step2.account.AccountServiceV2;
import step2.credit.CreditInfoService;
import step2.credit.CreditInfoServiceV2Impl;

import java.util.Collections;
import java.util.List;

public class FinancialServiceProxy implements FinancialService {

    private UserRole userRole;
    private FinancialServiceV2Impl financialServiceV2;

    public FinancialServiceProxy(UserRole userRole, AccountServiceV2 accountService, CreditInfoService creditInfoService){

        this.userRole = userRole;
        this.financialServiceV2 = new FinancialServiceV2Impl(accountService, creditInfoService);

    }
    private FinancialServiceProxy(){
    }
    @Override
    public void deposit(int userId, long money) {
        financialServiceV2.deposit(userId,money);
    }

    @Override
    public long checkBalance(int userId) {
        //TODO : 실제로 로직를 짤때는 userId 값도 받아서 같은지 비교하는 로직 필요.
        //일반유저이고 관리자이면 조회가능
        if(!userRole.equals(UserRole.USER)){
            return financialServiceV2.checkBalance(userId);
        }
        else{
            System.out.println("허가받지 않은 매니저는 접근할 수 없습니다.");
            return -1;
        }
    }

    @Override
    public List<String> checkAllAccount() {
        if(userRole.equals(UserRole.ADMIN)){
            return financialServiceV2.checkAllAccount();
        }
        System.out.println("관리자만 조회 가능합니다.");
        return Collections.EMPTY_LIST;
    }

    @Override
    public int creditScore() {
        //TODO : 실제로 로직를 짤때는 userId 값도 받아서 같은지 비교하는 로직 필요.
        //일반유저이고 관리자이면 조회가능
        if(!userRole.equals(UserRole.USER)){
            return financialServiceV2.creditScore();
        }
        else{
            System.out.println("허가받지 않은 매니저는 접근할 수 없습니다.");
            return -1;
        }
    }
}
