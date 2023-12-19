package origin;

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

        if(accountMap.containsKey(userId)){
            accountMap.put(userId, 0L);
        }

        accountMap.put(userId, accountMap.get(userId) + money);
    }

    public Long getMoney(int userId){

        return accountMap.get(userId);
    }

    public List<String> getAllInfo(){

        return accountMap.keySet().stream()
                .map(key -> "["+ key +"]" + ": [" + accountMap.get(key)+ "] 원")
                .collect(Collectors.toList());
    }

    public List<String> getSubInfo(Set<Integer> userIdList){

        return accountMap.keySet().stream()
                .filter(key -> userIdList.contains(key))
                .map(key -> "["+ key +"]" + ": [" + accountMap.get(key)+ "] 원")
                .collect(Collectors.toList());
    }


}
