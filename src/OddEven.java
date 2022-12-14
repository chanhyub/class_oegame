import java.util.Random;
import java.util.Scanner;

public class OddEven {
    // 변수
    int betMarble;
    int userMarble = 10;
    int comMarble = 10;
    int ranMarble;
    boolean isMyTurn = true;
    Random random = new Random();
    Scanner sc = new Scanner(System.in);


    // 메소드
    public void intro(){
        System.out.println("홀짝 게임");
        System.out.println("두 명의 참가자가 각각 10개의 구슬 보유");
        System.out.println("10개의 구슬을 다 잃을 시 사망");
        System.out.println("게임 시작");
    }

    // 배팅 기능
    public void betting(){
        while(true){

            if(isMyTurn) {
                try {
                    System.out.print("배팅할 구슬의 갯수 : ");
                    betMarble = sc.nextInt(); // 숫자 스캔 후 입력 받기
                    if (betMarble > userMarble) {
                        System.out.println("구슬 갯수 초과 ");
                    } else if (betMarble > comMarble) {
                        System.out.println("상대 구슬 갯수 모자람");
                    } else {
                        System.out.println("배팅된 구슬 갯수 : " + betMarble);
                        break;
                    }
                }catch (Exception e){
                    System.out.println("숫자만 입력하세요");
                    sc.nextLine();
                }

            }else{
                betMarble = random.nextInt(Math.min(comMarble, userMarble)) + 1;
                break;
            }
        }
    }

    //컴이 하는 기능
    public String comTurn(){
        // 난수 생성
        int ranMarble = random.nextInt(Math.min(comMarble, userMarble)) * random.nextInt(Math.min(comMarble, userMarble)) % 10 + 1;

        // 홀 / 짝 판별
        String isOdd = ranMarble % 2 == 0 ? "짝" : "홀";
        System.out.println("컴퓨터가 선택한 구슬 갯수 : " + ranMarble + isOdd);

        if(!isMyTurn){
            System.out.println("상대방 배팅 : " + betMarble);
            betMarble *= -1;
        }
        return isOdd;
    }

    // 유저가 하는 기능
    public String userTurn(){
        // User 정답 입력 / 문제 내기
        if(isMyTurn) {
            System.out.print("홀 / 짝 예측( 홀 / 짝 ) : ");
        }else{
            System.out.print("문제 내기( 홀 / 짝 ) : ");
        }
        return sc.next();

    }

    public void checkMarble(){
        // 정답 / 오답 판별 후 구슬 더하거나 빼기
        String answer = userTurn();
        String isOdd = comTurn();
        if(answer.equals(isOdd)){
            System.out.println("\n정답");
            userMarble += betMarble;
            comMarble -= betMarble;
        }else {
            System.out.println("\n오답");
            userMarble -= betMarble;
            comMarble += betMarble;
        }

    }

    // 턴 바꾸기
    public void turnChange(){
        //턴 넘기기
        isMyTurn = !isMyTurn;
        System.out.println("\n");
        System.out.println("현재 구슬 갯수 : " + userMarble);
        System.out.println("상대 구슬 갯수 : " + comMarble);
    }

    // 게임 종료
    public boolean gameOver(){
        boolean isOver = true;

        // 게임 종료
        if(userMarble <= 0){
            System.out.println("짐");
            isOver = false;
        } else if (userMarble >= 20) {
            System.out.println("이김");
            isOver = false;
        }
        return isOver;
    }

}
