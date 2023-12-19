import org.junit.jupiter.api.*;
import step3.FinancialService;
import step3.FinancialServiceProxy;
import step3.UserRole;
import step3.account.AccountRepositoryV3;
import step3.account.AccountServiceProxy;
import step3.credit.CreditInfoServiceProxy;

public class Step3Test {

    private static AccountRepositoryV3 accountRepository;
    private static long currentTime;

    @BeforeAll
    static void timeCheck(){
        currentTime = System.currentTimeMillis();
    }
    @BeforeEach
    void init(){
        accountRepository = new AccountRepositoryV3();
        accountRepository.insertMoney(1, 100);
        accountRepository.insertMoney(2, 200);
    }

    @AfterAll
    static void AfterTimeCheck(){
        System.out.println("total time : " + (System.currentTimeMillis() - currentTime));
    }



    @Test
    @DisplayName("캐싱 프록시 테스트 - 동일한 전체 데이터를 두번 조회.")
    void cacheProxyTest(){
        int userId = 1;
        FinancialService financialService = new FinancialServiceProxy(UserRole.ADMIN, new AccountServiceProxy(), new CreditInfoServiceProxy(userId));

        System.out.println("-------select1---------");
        long currentTime = System.currentTimeMillis();
        System.out.println("size : " + financialService.checkAllAccount().size());
        System.out.println("total time : " + (System.currentTimeMillis() - currentTime));
        System.out.println("-----------------------");

        System.out.println("-------select2---------");
        currentTime = System.currentTimeMillis();
        System.out.println("size : " + financialService.checkAllAccount().size());
        System.out.println("total time : " + (System.currentTimeMillis() - currentTime));
        System.out.println("-----------------------");

    }
}
