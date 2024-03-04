public class GorokeTest {
    public static void main(String[] args) {
        /* 1. TOP 3 고로케를 객체로 만드세요. */
        Goroke goroke1 = new Goroke("피자", 1000);
        Goroke goroke2 = new Goroke("야채", 800);
        Goroke goroke3 = new Goroke("팥", 500);
        Goroke[] gorokes = {goroke1, goroke2, goroke3};

        /* 2. 고로케 정보를 출력하세요. */
        for (Goroke goroke : gorokes) {
            System.out.println(goroke.str());
        }
    }
}

class Goroke {
    // 필드
    String name;
    int price;

    // 생성자
    Goroke(String n, int p) {
        name = n;
        price = p;
    }

    // 메소드
    String str() {
        return String.format("Goroke { name: %s, price: %d원 }", name, price);
    }
}
