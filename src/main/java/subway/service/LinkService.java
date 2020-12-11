package subway.service;

import subway.constant.Information;

import java.util.Scanner;

public class LinkService {

    private Scanner scanner;

    public LinkService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println(Information.LINK_INFO);
    }
}
