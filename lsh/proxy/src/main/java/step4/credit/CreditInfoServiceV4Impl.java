package step3.credit;

public class CreditInfoServiceV3Impl implements CreditInfoService {

    private int creditScore;

    public CreditInfoServiceV3Impl(int userId){

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
