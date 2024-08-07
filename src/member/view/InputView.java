package member.view;

import common.IsDeleted;
import member.Member;
import member.constant.MemberMenu;
import member.controller.MemberController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;


public class InputView {

    public static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static MemberMenu printMenu() throws IOException {
        if(MemberController.loginMember != null) {
            System.out.println();
            System.out.printf("환영합니다 %s님!", MemberController.loginMember.getNickname());
        }
        System.out.println();
        System.out.println("----- 회원 기능 -----");
        System.out.println("1. 회원 가입");
        System.out.println("2. 로그인");
        System.out.println("3. 로그아웃");
        System.out.println("-1. 뒤로가기");
        System.out.println("------------------------");
        System.out.print("1번 2번 중에서 고르세요: ");
        return MemberMenu.fromString(BR.readLine());
    }

    public static Member printJoin() throws IOException {
        System.out.print("아이디(이메일)을 입력하세요: ");
        String email = BR.readLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = BR.readLine();
        System.out.print("확인을 위해 입력한 비밀번호를 한번 더 입력하세요: ");
        String confirmPassword = BR.readLine();
        System.out.print("닉네임을 입력하세요: ");
        String nickname = BR.readLine();
        return new Member(email, password, nickname, confirmPassword, null, null);
    }

    public static Member printLogin() throws IOException {
        System.out.print("아이디(이메일)을 입력하세요: ");
        String email = BR.readLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = BR.readLine();
        return new Member(email, password, null, null, null, null);
    }
}
