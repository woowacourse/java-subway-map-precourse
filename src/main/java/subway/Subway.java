package subway;

import java.util.Scanner;

import subway.util.Input;
import subway.util.Output;

public class Subway {
	private int selectorInt;
	
	public void run(Scanner scanner) {
		while (true) {
			Output.mainView();
			selectorInt = Input.nextInt(scanner);
			moveViewBySelector(selectorInt);
		}
	}
	
	private void moveViewBySelector(int selectorInt) {
		if (selectorInt == 1) {
			System.out.println("1을 선택");
		}
	}
}
