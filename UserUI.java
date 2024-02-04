package userManagementProgram1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class UserUI {
    private BufferedReader br;
    public UserUI() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int menu() {
        System.out.println("\n사용할 옵션을 선택하십시오.");
        System.out.println("1. 회원등록");
        System.out.println("2. 회원목록");
        System.out.println("3. 회원정보 수정");
        System.out.println("4. 회원정보 삭제");
        System.out.println("5. 종료");
        int menuId = -1;
        try {
            String line = br.readLine();
            menuId = Integer.parseInt(line);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuId;
    }

    public User regUser() {
        while (true) {
            try {
                System.out.print("이메일을 입력하세요: ");
                String email = br.readLine();

                System.out.print("이름을 입력하세요: ");
                String name = br.readLine();
                System.out.print("생일을 입력하세요: ");
                String strBirthday = br.readLine();
                int birthday = Integer.parseInt(strBirthday);

                User user = new User(email, name, birthday);
                return user;
            } catch (NumberFormatException e) {
                System.out.println("올바른 형식이 아닙니다. 다시 입력해주세요.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void printUserList(Iterator<User> iter) {
        System.out.println("이메일               이름              생일");
        System.out.println("=========================================");
        if (!iter.hasNext()) {
            System.out.println("회원 정보가 없습니다.");
        }
        while (iter.hasNext()) {

            User user = iter.next();
            System.out.print(user.getEmail());
            for (int i = 0; i < 20 - user.getEmail().length(); i++) {
                System.out.print(" ");
            }
            System.out.print(user.getName());
            for (int i = 0; i < 18 - user.getName().length(); i++) {
                System.out.print(" ");
            }
            System.out.print(user.getBirthday());
            System.out.println();
        }

    }

    public String inputEmail() {
        System.out.print("변경할 회원의 이메일을 입력하세요: ");
        String email = "";
        try {
            email = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return email;
    }

    public User inputUser(String email) {
        try {
            System.out.print(email + " 회원의 정보를 수정합니다.");
            System.out.print("이름을 입력하세요: ");
            String name = br.readLine();
            System.out.print("생일을 입력하세요: ");
            String strBirthday = br.readLine();
            int birthday = Integer.parseInt(strBirthday);

            User user = new User(email, name, birthday);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


