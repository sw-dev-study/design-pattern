package step4.account;

import java.util.List;
import java.util.Set;

public interface Account {


    long getAccountMoney(int userId);

    //계좌 입금
    void depositMoney(int userId, long money);
    //계좌 전체 조회
    List<String> getAllAccount();

    //계좌 일부 조회
    List<String> getSubAccount(Set<Integer> useridSet);
}
