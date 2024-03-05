public class TeamTest {
    public static void main(String[] args) {
        // 선수 객체 생성
        Player kim = new Player("Kim", new int[] { 9, 8, 10 });
        Player lee = new Player("Lee", new int[] { 10, 9, 10 });
        Player park = new Player("Park", new int[] { 8, 10, 9 });

        Player Xiao = new Player("Xiao", new int[]{10, 9, 10});
        Player Yu = new Player("Yu", new int[]{8, 9, 10});
        Player Xui = new Player("Xui", new int[]{8, 9, 9});

        // 객체 배열 만들기
        Player[] koreaPlayers = { kim, lee, park };
        Player[] chinaPlayers = { Xiao, Yu, Xui };

        // 팀 객체 생성
        Team korea = new Team("KOREA", koreaPlayers);
        Team china = new Team("CHINA", chinaPlayers);

        // 팀 점수 출력
        korea.printTeamPoints();
        china.printTeamPoints();
    }
}

// 팀 클래스
class Team {
    // 필드
    String nation;    // 나라
    Player[] players; // 선수들

    // 생성자
    Team (String str, Player[] arr) {
        nation = str;
        players = arr;
    }

    // 메소드
    void printTeamPoints() {
        int sum = 0;
        for (int i = 0; i < players.length; i++) {
            sum += players[i].totalPoints();
        }
        System.out.printf("%s -> %d points\n", nation, sum);
    }
}

// 선수 클래스
class Player {
    // 필드
    String name;  // 이름
    int[] points; // 득점 현황

    // 생성자
    Player (String str, int[] arr) {
        name = str;
        points = arr;
    }

    // 메소드
    int totalPoints() {
        int sum = 0;
        for (int i = 0; i < points.length; i++) {
            sum += points[i];
        }
        return sum;
    }
}
