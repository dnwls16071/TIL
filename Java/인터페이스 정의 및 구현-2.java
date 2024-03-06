public class SmartPhoneTest2 {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone("상어송");

        sp.beep();

        sp.playMusic();
    }
}


interface Alarm {
    void beep();

    void playMusic();
}

class SmartPhone implements Alarm {
    String songName;

    SmartPhone(String songName) {
        this.songName = songName;
    }

    @Override
    public void beep() {
        System.out.println("삐빕! 삐비비빕~!");
    }

    @Override
    public void playMusic() {
        System.out.printf("[%s]을 재생합니다..!",songName);
    }
}
