import org.junit.jupiter.api.*;

import step1.FinancialService;
import step1.FinancialServiceProxy;
import step1.UserRole;
import step1.account.AccountRepositoryV1;
import step1.account.AccountServiceV1;
import step1.credit.CreditInfoServiceV1;

public class Step1Test {

    private static AccountRepositoryV1 accountRepository;
    private static long currentTime;

    @BeforeAll
    static void timeCheck(){
        currentTime = System.currentTimeMillis();
    }
    @BeforeEach
    void init(){
        accountRepository = new AccountRepositoryV1();
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

        FinancialService financialService = new FinancialServiceProxy(UserRole.USER, new AccountServiceV1(accountRepository), new CreditInfoServiceV1(userId));

        System.out.println(financialService.checkBalance(userId));

    }

    @Test
    @DisplayName("기본기능 테스트 - 입금 테스트")
    void basicDepositTest(){
        int userId = 1;
        long money = 500;
        FinancialService financialService = new FinancialServiceProxy(UserRole.USER, new AccountServiceV1(accountRepository), new CreditInfoServiceV1(userId));
        financialService.deposit(userId, money);

        System.out.println(financialService.checkBalance(userId));

    }

    @Test
    @DisplayName("기본기능 테스트 - 계좌 전체 조회 테스트")
    void basicAccountAllSelectTest() {
        int userId = 1;
        FinancialService financialService = new FinancialServiceProxy(UserRole.USER, new AccountServiceV1(accountRepository), new CreditInfoServiceV1(userId));

        System.out.println(financialService.checkAllAccount().size());
    }
    @Test
    @DisplayName("기본기능 테스트 - 신용 점수 조회 테스트")
    void basicCreditScoreSelectTest(){

        int userId = 1;
        FinancialService financialService = new FinancialServiceProxy(UserRole.USER, new AccountServiceV1(accountRepository), new CreditInfoServiceV1(userId));

        System.out.println(financialService.creditScore());

    }

    @Test
    @DisplayName("보호 프록시 테스트 - 일반유저가 관리자 권한인 전체 조회 요청")
    void normalUserGetAllAccountSelectTest(){
        int userId = 1;
        FinancialService financialService = new FinancialServiceProxy(UserRole.USER, new AccountServiceV1(accountRepository), new CreditInfoServiceV1(userId));

        financialService.checkAllAccount();
    }
}
