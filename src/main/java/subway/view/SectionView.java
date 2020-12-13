package subway.view;

import subway.domain.Name;
import subway.domain.Order;

import java.util.Scanner;

public class SectionView {
    private static SectionView sectionView;
    private final Scanner scanner;

    private SectionView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static SectionView getInstance(Scanner scanner) {
        if (sectionView == null) {
            sectionView = new SectionView(scanner);
            return sectionView;
        }
        return sectionView;
    }

    public Name getLineNameToAddSection() {
        OutputView.printMsg("## 노선을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public Order getOrder() {
        OutputView.printMsg("## 순서를 입력하세요.\n");
        return new Order(InputView.getInteger(scanner));
    }

    public void announceAddSectionSuccess() {
        OutputView.printInfoMsg("구간이 등록되었습니다.");
    }

    public Name getLineNameOfDeleteSection() {
        OutputView.printMsg("## 삭제할 노선을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public Name getStationNameOfSection() {
        OutputView.printMsg("## 역이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public void announceDeleteSectionSuccess() {
        OutputView.printInfoMsg("구간이 삭제되었습니다.");
    }
}
