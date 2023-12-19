package origin.account;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class AccountRepository {

    private static ConcurrentHashMap<Integer, Long> accountMap;

    public AccountRepository(){

        accountMap = new ConcurrentHashMap<>();
    }

    public void insertMoney(int userId, long money){

        if(!accountMap.containsKey(userId)){
            accountMap.put(userId, 0L);
        }

        accountMap.put(userId, accountMap.get(userId) + money);
    }

    public Long getMoney(int userId){

        return accountMap.get(userId);
    }

    public List<String> getAllInfo(){

        //TODO : 레포지토리에서는 엔트리셋만 리턴하고 아래의 가공로직은 서비스 계층에서 처리하도록.

        return accountMap.keySet().stream()
                .map(key -> "["+ key +"]" + ": [" + accountMap.get(key)+ "] 원")
                .collect(Collectors.toList());
    }

    public List<String> getSubInfo(Set<Integer> userIdSet){

        //TODO : 레포지토리에서는 엔트리셋만 리턴하고 아래의 가공로직은 서비스 계층에서 처리하도록.

        return accountMap.keySet().stream()
                .filter(key -> userIdSet.contains(key))
                .map(key -> "["+ key +"]" + ": [" + accountMap.get(key)+ "] 원")
                .collect(Collectors.toList());
    }


}
