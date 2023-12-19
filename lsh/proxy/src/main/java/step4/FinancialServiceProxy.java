package step4;

import step4.account.Account;
import step4.account.AccountServiceV4;
import step4.credit.CreditInfoService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

//TODO : 예제이므로 시스템 출력으로 로그를 대신했지만 로그 라이브러리를 이용해야 한다.

public class FinancialServiceProxy implements FinancialService {

    private UserRole userRole;
    private FinancialServiceV4Impl financialServiceV4;

    public FinancialServiceProxy(UserRole userRole, Account account, CreditInfoService creditInfoService){

        this.userRole = userRole;
        this.financialServiceV4 = new FinancialServiceV4Impl(account, creditInfoService);

    }
    private FinancialServiceProxy(){
    }
    @Override
    public void deposit(int userId, long money) {

        System.out.println("[" +userId+"]" + "[" + LocalDateTime.now().toString() + "] - ["+ money + "원 예금을 시도합니다.]");

        financialServiceV4.deposit(userId,money);

        System.out.println("[" +userId+"]" + "[" + LocalDateTime.now().toString() + "] - ["+ money + "원 예금을 성공했습니다.]");
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
            return financialServiceV4.checkBalance(userId);
        }
    }

    @Override
    public List<String> checkAllAccount() {
        if(userRole.equals(UserRole.ADMIN)){

            return financialServiceV4.checkAllAccount();
        }
        System.out.println("관리자만 조회 가능합니다.");
        return Collections.EMPTY_LIST;
    }

    @Override
    public int creditScore() {
        //TODO : 실제로 로직를 짤때는 userId 값도 받아서 같은지 비교하는 로직 필요.
        //일반유저이고 관리자이면 조회가능
        if(!userRole.equals(UserRole.MANAGER)){
            return financialServiceV4.creditScore();
        }
        else{
            System.out.println("허가받지 않은 매니저는 접근할 수 없습니다.");
            return -1;
        }
    }
}
