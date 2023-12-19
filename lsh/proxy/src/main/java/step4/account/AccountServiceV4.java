package step4.account;

import java.util.List;
import java.util.Set;

public class AccountServiceV4 implements Account {

    private AccountRepositoryV4 accountRepository;

    public AccountServiceV4(AccountRepositoryV4 accountRepository){
        this.accountRepository = accountRepository;
    }

    //계좌 잔액 조회
    public long getAccountMoney(int userId){

        return this.accountRepository.getMoney(userId);
    }

    //계좌 입금
    public void depositMoney(int userId, long money){
        this.accountRepository.insertMoney(userId, money);
    }

    //계좌 전체 조회
    public List<String> getAllAccount(){
        return this.accountRepository.getAllInfo();
    }

    //계좌 일부 조회
    public List<String> getSubAccount(Set<Integer> useridSet){
        return this.accountRepository.getSubInfo(useridSet);
    }





}
