import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("==== Todo App ====");
            System.out.println("1. 할 일 추가");
            System.out.println("2. 할 일 목록 보기");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택: ");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                System.out.println("할 일 추가 기능은 아직 준비 중입니다.");
            }else if (input.equals("2")) {
                System.out.println("목록 보기 기능은 아직 준비 중입니다.");
            }else if(input.equals("0")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }else{
                System.out.println("잘못된 입력입니다.");
            }
        }
        scanner.close();
    }
}