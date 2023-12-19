import org.junit.jupiter.api.*;
import step2.FinancialService;
import step2.FinancialServiceProxy;
import step2.UserRole;
import step2.account.AccountRepositoryV2;
import step2.account.AccountServiceV2;
import step2.credit.CreditInfoServiceProxy;
import step2.credit.CreditInfoServiceV2Impl;

public class Step2Test {

    private static AccountRepositoryV2 accountRepository;
    private static long currentTime;

    @BeforeAll
    static void timeCheck(){
        currentTime = System.currentTimeMillis();
    }
    @BeforeEach
    void init(){
        accountRepository = new AccountRepositoryV2();
        accountRepository.insertMoney(1, 100);
        accountRepository.insertMoney(2, 200);
    }

    @AfterAll
    static void AfterTimeCheck(){
        System.out.println("total time : " + (System.currentTimeMillis() - currentTime));
    }

    @Test
    @DisplayName("기본기능 테스트 - 계좌 조회 테스트")
    void basicAccountSelectTest(){


        int userId = 1;

        FinancialService financialService = new FinancialServiceProxy(UserRole.USER, new AccountServiceV2(accountRepository), new CreditInfoServiceProxy(userId));

        System.out.println(financialService.checkBalance(userId));

    }

    @Test
    @DisplayName("기본기능 테스트 - 입금 테스트")
    void basicDepositTest(){
        int userId = 1;
        long money = 500;
        FinancialService financialService = new FinancialServiceProxy(UserRole.USER, new AccountServiceV2(accountRepository), new CreditInfoServiceProxy(userId));
        financialService.deposit(userId, money);

        System.out.println(financialService.checkBalance(userId));

    }

    @Test
    @DisplayName("기본기능 테스트 - 계좌 전체 조회 테스트")
    void basicAccountAllSelectTest() {
        int userId = 1;
        FinancialService financialService = new FinancialServiceProxy(UserRole.USER, new AccountServiceV2(accountRepository), new CreditInfoServiceProxy(userId));

        System.out.println(financialService.checkAllAccount().size());
    }
    @Test
    @DisplayName("기본기능 테스트 - 신용 점수 조회 테스트")
    void basicCreditScoreSelectTest(){

        int userId = 1;
        FinancialService financialService = new FinancialServiceProxy(UserRole.USER, new AccountServiceV2(accountRepository), new CreditInfoServiceProxy(userId));

        System.out.println(financialService.creditScore());

    }

    @Test
    @DisplayName("보호 프록시 테스트 - 일반유저가 관리자 권한인 전체 조회 요청")
    void normalUserGetAllAccountSelectTest(){
        int userId = 1;
        FinancialService financialService = new FinancialServiceProxy(UserRole.USER, new AccountServiceV2(accountRepository), new CreditInfoServiceProxy(userId));

        financialService.checkAllAccount();
    }

}
