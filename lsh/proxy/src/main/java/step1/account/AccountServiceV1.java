package step1.account;

import java.util.List;
import java.util.Set;

public class AccountServiceV1 {

    private AccountRepositoryV1 accountRepository;

    public AccountServiceV1(AccountRepositoryV1 accountRepository){
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
