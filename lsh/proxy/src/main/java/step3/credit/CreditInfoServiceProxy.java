package step2.credit;

public class CreditInfoServiceProxy implements CreditInfoService{

    private CreditInfoServiceV2Impl creditInfoServiceV2;
    private int userId;

    public CreditInfoServiceProxy(int userId){
        this.userId = userId;
    }
    @Override
    public int getCreditScore() {

        //해당 객체는 오래걸리기 때문에 조회 호출 시점에 실제객체를 로딩함.
        creditInfoServiceV2 = new CreditInfoServiceV2Impl(this.userId);
        return creditInfoServiceV2.getCreditScore();

    }
}
