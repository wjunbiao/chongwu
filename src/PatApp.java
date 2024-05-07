import controller.Controller;

import java.io.IOException;

public class PatApp {
    public static void main(String[] args) throws IOException {
        new Controller().mainMenu();
        System.out.println("=====您退出了宠物医生管理系统=====");
    }
}
