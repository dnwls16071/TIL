public class SongTest {
    public static void main(String[] args) {
        // 객체 생성
        Song s0 = new Song("별헤는 밤", "유재하");
        Song s1 = new Song("비상", "임재범");
        Song s2 = new Song("비밀", "박완규");

        // 객체 배열 생성
        Song[] songs = { s0, s1, s2 };

        // 모든 배열 속 객체 출력
        for (int i = 0; i < songs.length; i++) {
            System.out.println(songs[i].toStr());
        }
    }
}

class Song {
    // 필드
    String name;
    String singer;

    // 생성자
    Song(String n, String s) {
        name = n;
        singer = s;
    }

    // 메소드
    String toStr() {
        return String.format("Song { name: %s, singer: %s }", name, singer);
    }
}
