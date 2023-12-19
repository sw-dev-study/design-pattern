package step1;

import step1.account.AccountServiceV1;
import step1.credit.CreditInfoServiceV1;

import java.util.Collections;
import java.util.List;

public class FinancialServiceProxy implements FinancialService{

    private UserRole userRole;
    private FinancialServiceV1Impl financialServiceV1;

    public FinancialServiceProxy(UserRole userRole, AccountServiceV1 accountService, CreditInfoServiceV1 creditInfoService){

        this.userRole = userRole;
        this.financialServiceV1 = new FinancialServiceV1Impl(accountService, creditInfoService);

    }
    private FinancialServiceProxy(){
    }
    @Override
    public void deposit(int userId, long money) {
        financialServiceV1.deposit(userId,money);
    }

    @Override
    public long checkBalance(int userId) {
        //TODO : 실제로 로직를 짤때는 userId 값도 받아서 같은지 비교하는 로직 필요.
        //일반유저이고 관리자이면 조회가능
        if(!userRole.equals(UserRole.MANAGER)){
            System.out.println("허가받지 않은 매니저는 접근할 수 없습니다.");
            return -1;

        }
        else{
            return financialServiceV1.checkBalance(userId);
        }
    }

    @Override
    public List<String> checkAllAccount() {
        if(userRole.equals(UserRole.ADMIN)){
            return financialServiceV1.checkAllAccount();
        }
        System.out.println("관리자만 조회 가능합니다.");
        return Collections.EMPTY_LIST;
    }

    @Override
    public int creditScore() {
        //TODO : 실제로 로직를 짤때는 userId 값도 받아서 같은지 비교하는 로직 필요.
        //일반유저이고 관리자이면 조회가능
        if(!userRole.equals(UserRole.MANAGER)){
            return financialServiceV1.creditScore();
        }
        else{
            System.out.println("허가받지 않은 매니저는 접근할 수 없습니다.");
            return -1;
        }
    }
}
