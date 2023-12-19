package step2.credit;

public class CreditInfoServiceV2Impl implements CreditInfoService{

    private int creditScore;

    public CreditInfoServiceV2Impl(int userId){

        try{
            Thread.sleep(5000);
            System.out.println("userId : " + userId + " 의 신용정보를 조회해옵니다.");
            this.creditScore = 998;
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public int getCreditScore(){
        return this.creditScore;
    }
}
