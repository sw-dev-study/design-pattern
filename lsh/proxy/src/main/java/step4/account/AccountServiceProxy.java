package step4.account;

import java.util.List;
import java.util.Set;

public class AccountServiceProxy implements Account {

    private AccountServiceV4 accountServiceV4;
    private List<String> cacheList;

    public AccountServiceProxy(){
        this.accountServiceV4 = new AccountServiceV4(new AccountRepositoryV4());
    }

    @Override
    public long getAccountMoney(int userId) {
        return this.accountServiceV4.getAccountMoney(userId);
    }

    @Override
    public void depositMoney(int userId, long money) {
        this.accountServiceV4.depositMoney(userId,money);
    }

    //다량의 데이터 조회가 필요한 곳에 캐싱적용해서 성능 올리기
    @Override
    public List<String> getAllAccount() {

        if(cacheList == null){
            cacheList = this.accountServiceV4.getAllAccount();
        }

        return cacheList;
    }

    @Override
    public List<String> getSubAccount(Set<Integer> userIdSet) {
        return accountServiceV4.getSubAccount(userIdSet);
    }
}
