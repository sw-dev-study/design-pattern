package step3;

import step3.account.Account;
import step3.account.AccountServiceV3;
import step3.credit.CreditInfoService;

import java.util.Collections;
import java.util.List;

public class FinancialServiceProxy implements FinancialService {

    private UserRole userRole;
    private FinancialServiceV3Impl financialServiceV3;

    public FinancialServiceProxy(UserRole userRole, Account account, CreditInfoService creditInfoService){

        this.userRole = userRole;
        this.financialServiceV3 = new FinancialServiceV3Impl(account, creditInfoService);

    }
    private FinancialServiceProxy(){
    }
    @Override
    public void deposit(int userId, long money) {
        financialServiceV3.deposit(userId,money);
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
            return financialServiceV3.checkBalance(userId);
        }
    }

    @Override
    public List<String> checkAllAccount() {
        if(userRole.equals(UserRole.ADMIN)){
            return financialServiceV3.checkAllAccount();
        }
        System.out.println("관리자만 조회 가능합니다.");
        return Collections.EMPTY_LIST;
    }

    @Override
    public int creditScore() {
        //TODO : 실제로 로직를 짤때는 userId 값도 받아서 같은지 비교하는 로직 필요.
        //일반유저이고 관리자이면 조회가능
        if(!userRole.equals(UserRole.MANAGER)){
            return financialServiceV3.creditScore();
        }
        else{
            System.out.println("허가받지 않은 매니저는 접근할 수 없습니다.");
            return -1;
        }
    }
}
