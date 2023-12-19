import org.junit.jupiter.api.*;
import step4.FinancialService;
import step4.FinancialServiceProxy;
import step4.UserRole;

import step4.account.AccountServiceProxy;
import step4.credit.CreditInfoServiceProxy;
import step4.account.AccountRepositoryV4;

public class Step4Test {

    private static AccountRepositoryV4 accountRepository;
    private static long currentTime;

    @BeforeAll
    static void timeCheck(){
        currentTime = System.currentTimeMillis();
    }
    @BeforeEach
    void init(){
        accountRepository = new AccountRepositoryV4();
        accountRepository.insertMoney(1, 100);
        accountRepository.insertMoney(2, 200);
    }

    @AfterAll
    static void AfterTimeCheck(){
        System.out.println("total time : " + (System.currentTimeMillis() - currentTime));
    }



    @Test
    @DisplayName("로깅 프록시 테스트 - 로그가 걸려있는 예금조회 호출.")
    void cacheProxyTest(){
        int userId = 1;
        long money = 80000;
        FinancialService financialService = new FinancialServiceProxy(UserRole.ADMIN, new AccountServiceProxy(), new CreditInfoServiceProxy(userId));

        financialService.deposit(userId, money);
    }


}
