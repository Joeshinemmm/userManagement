package userManagementProgram1;

public class UserMain {

    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        UserDao userDao = new UserDao("C:\\javastudy\\HappyJava\\src\\users.dat");
        UserService userService = new UserServiceInMemory(userDao.getUsers());

        while (true) {
            int menuId = userUI.menu();

            if (menuId == 1) {
                User user = userUI.regUser();
                if (userService.exists(user.getEmail())) {
                    System.out.println("이미 등록된 이메일입니다.");
                    continue;
                }
                userService.addUser(user);
                System.out.println("등록되었습니다.");
            } else if (menuId == 2) {
                userUI.printUserList(userService.getUsers());
            } else if (menuId == 3) {
                String email = userUI.inputEmail();
                boolean isFindEmail = userService.exists(email);

                if (isFindEmail) {
                    User updateUser = userUI.inputUser(email);
                    userService.updateUser(updateUser);
                    System.out.println("회원 정보가 수정되었습니다.");
                } else {
                    System.out.println("회원 정보를 찾지 못했습니다.");
                }
            } else if (menuId == 4) {
                String email = userUI.inputEmail();
                boolean isFindEmail = userService.exists(email);

                if (isFindEmail) {
                    userService.deleteUser(email);
                    System.out.println("회원 정보가 삭제되었습니다.");
                } else {
                    System.out.println("회원 정보를 찾지 못했습니다.");
                }
            } else if (menuId == 5) {
                System.out.println("시스템을 종료합니다.");
                userDao.saveUser(userService.getUsers());
                break;
            } else {
                System.out.println("잘못 입력했습니다.");
            }
        }
    }
}
