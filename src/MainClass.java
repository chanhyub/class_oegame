public class MainClass {
    public static void main(String[] args) {
        //System.out.println("Hello Class!");
        // 클래스를 선언
        // 객체를 생성 해보자
        //NewClass nc = new NewClass();
        //nc.m1();
        //nc.m2();

        boolean isMyTurn = true;
        int betMarble = 0;
        int userMarble = 10;
        int comMarble = 10;
        String answer;

        OddEven game = new OddEven();
        game.intro(); // 인트로 출력
        while (game.gameOver()) {
            game.betting(); // 배팅 기능
            game.checkMarble(); // 구슬 체크
            game.turnChange(); // 턴 넘기기
        }
    }
}
