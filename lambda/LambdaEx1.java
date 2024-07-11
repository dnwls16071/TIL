package lambda;

public class LambdaEx1 {
	public static void main(String[] args) {
		// 람다식
		MyFunction f1 = () -> {
			System.out.println("f1.run()");
		};

		// 익명 클래스
		MyFunction f2 = new MyFunction() {
			@Override
			public void run() {
				System.out.println("f2.run()");
			}
		};

		// static 메서드
		MyFunction f3 = getMyFunction();
		execute(f1);
		execute(f2);
		execute(f3);
	}

	static void execute(MyFunction f) {
		f.run();
	}

	static MyFunction getMyFunction() {
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
	}
}
