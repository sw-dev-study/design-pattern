package step2;

import java.util.List;

public interface FinancialService {


    //계좌에 돈 넣기
    public void deposit(int userId, long money);

    //계좌 잔액 확인
    public long checkBalance(int userId);

    //모든 계좌 확인.
    public List<String> checkAllAccount();

    //일부 계좌 확인.

    //신용점수 조회서비스
    public int creditScore();


}
