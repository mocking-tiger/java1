import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> todos = new ArrayList<>();
        while (true) {
            System.out.println("==== Todo App ====");
            System.out.println("1. 할 일 추가");
            System.out.println("2. 할 일 목록 보기");
            System.out.println("3. 할 일 삭제");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택: ");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                System.out.print("할 일 입력: ");
                String todo = scanner.nextLine();
                todos.add(todo);
                System.out.println("할 일이 추가되었습니다.");
            }else if (input.equals("2")) {
                int index = 1;
                for(String todo : todos) {
                    System.out.println(index + ". " + todo);
                    index++;
                }
            }else if (input.equals("3")) {
                System.out.print("삭제할 할 일의 번호 입력:");
                String deleteInput = scanner.nextLine();
                if (!deleteInput.matches("\\d+")) {
                    System.out.println("⚠️ 숫자만 입력 가능합니다.");
                    continue;
                }
                int index = Integer.parseInt(deleteInput) - 1;
                if(index >= todos.size() || index < 0) {
                    System.out.println("존재하지 않는 인덱스 입니다.");
                    continue;
                }
                todos.remove(index);
                System.out.println("삭제 완료되었습니다.");
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