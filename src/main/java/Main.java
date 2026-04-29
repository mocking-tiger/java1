import java.util.Scanner;

public class Main {

    // 사용자 입력값 유효성 검사
    private static int getValidatedIndex(String userInput, TodoService todoService){
        if(!userInput.matches("\\d+")){
            System.out.println("⚠️ 숫자만 입력 가능합니다.");
            return -1;
        }
        int index = Integer.parseInt(userInput) - 1;
        if(index >= todoService.size() || index < 0){
            System.out.println("존재하지 않는 인덱스 입니다.");
            return -1;
        }else{
            return index;
        }
    }

    // 할 일 추가
    private static void addTodo(Scanner scanner, TodoService todoService){
        System.out.print("할 일 입력: ");
        String title = scanner.nextLine();
        todoService.addTodo(title);
        System.out.println("할 일이 추가되었습니다.");
    }

    // 할 일 조회
    private static void viewTodos(TodoService todoService){
        int index = 1;
        for(Todo todo : todoService.getTodos()) {
            String status = todo.getIsComplete() ? "[완료]" : "[미완료]";
            System.out.println(index + "." + status + todo.getTitle());
//                    17버전에서는 String Templates 안됨(21+, 21버전에서도 정식기능은 아니고 preview라고 함)
//                    System.out.println(STR."\{index}.\{status}\{todo.getTitle()}");
            index++;
        }
    }

    // 할 일 삭제
    private static void deleteTodo(Scanner scanner, TodoService todoService){
        System.out.print("삭제할 할 일의 번호 입력:");
        String todoInput = scanner.nextLine();
        int index = getValidatedIndex(todoInput, todoService);
        if(index == -1){
            return;
        }
        todoService.deleteTodo(index);
        System.out.println("삭제 완료되었습니다.");
    }

    // 할 일 상태변경
    private static void toggleTodoStatus(Scanner scanner, TodoService todoService){
        System.out.print("상태변경할 할 일의 번호 입력:");
        String todoInput = scanner.nextLine();
        int index = getValidatedIndex(todoInput, todoService);
        if(index == -1){
            return;
        }
        String status = todoService.toggleTodoStatus(index) ? "[완료]" : "[미완료]";
        System.out.println((index+1) + "번 할 일의 상태가" + status + "로 변경되었습니다.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoService todoService = new TodoService();

        while (true) {
            System.out.println("==== Todo App ====");
            System.out.println("1. 할 일 추가");
            System.out.println("2. 할 일 목록 보기");
            System.out.println("3. 할 일 삭제");
            System.out.println("4. 할 일 상태변경");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택: ");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                addTodo(scanner, todoService);
            }else if (input.equals("2")) {
                viewTodos(todoService);
            }else if (input.equals("3")) {
                deleteTodo(scanner, todoService);
            }else if (input.equals("4")) {
                toggleTodoStatus(scanner, todoService);
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