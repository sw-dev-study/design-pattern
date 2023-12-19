import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import origin.FinancialService;
import origin.account.AccountRepository;
import origin.account.AccountService;
import origin.credit.CreditInfoService;
import step1.UserRole;


public class OriginFeatureTest {

    private static AccountRepository accountRepository;

    @BeforeEach
    void init(){
        accountRepository = new AccountRepository();
        accountRepository.insertMoney(1, 100);
        accountRepository.insertMoney(2, 200);
    }

    @Test
    @DisplayName("기본기능 테스트 - 계좌 조회 테스트")
    void basicAccountSelectTest(){
        int userId = 1;

        FinancialService financialService = new FinancialService(new AccountService(accountRepository), new CreditInfoService(userId));

        System.out.println(financialService.checkBalance(userId));

    }

    @Test
    @DisplayName("기본기능 테스트 - 입금 테스트")
    void basicDepositTest(){
        int userId = 1;
        long money = 500;
        FinancialService financialService = new FinancialService(new AccountService(accountRepository), new CreditInfoService(userId));
        financialService.deposit(userId, money);

        System.out.println(financialService.checkBalance(userId));

    }

    @Test
    @DisplayName("기본기능 테스트 - 계좌 전체 조회 테스트")
    void basicAccountAllSelectTest() {
        int userId = 1;
        FinancialService financialService = new FinancialService(new AccountService(accountRepository), new CreditInfoService(userId));

        System.out.println(financialService.checkAllAccount().size());
    }
    @Test
    @DisplayName("기본기능 테스트 - 신용 점수 조회 테스트")
    void basicCreditScoreSelectTest(){

        int userId = 1;
        FinancialService financialService = new FinancialService(new AccountService(accountRepository), new CreditInfoService(userId));

        System.out.println(financialService.creditScore());

    }


}
