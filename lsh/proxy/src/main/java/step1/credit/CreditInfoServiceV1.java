package origin.credit;

public class CreditInfoService {

    private int creditScore;

    public CreditInfoService(int userId){

        try{
            Thread.sleep(1000);
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
