package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.BoardController;
import com.kh.model.vo.Board;
import com.kh.model.vo.Comment;

public class BoardView {
    
    private Scanner sc = new Scanner(System.in);
    private BoardController bc = new BoardController();
    private ArrayList<Board> list = bc.printAll();
    private ArrayList<Comment> cmntList = bc.printAllCmnt();
    
    public void mainMenu() {
        while(true) {
            System.out.println();
            System.out.println("1. 글 작성하기");
            System.out.println("2. 글 수정하기");
            System.out.println("3. 글 삭제하기");
            System.out.println("4. 글 검색하기");
            System.out.println("5. 전체 글 목록 보기");
            System.out.println("6. 글 상세 보기");
            System.out.println("0. 종료");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            switch(menu) {
                case 1 : insert(); break;
                case 2 : update(); break;
                case 3 : delete(); break;
                case 4 : search(); break;
                case 5 : printAll(); break;
                case 6 : select(); break;
                case 0 : System.out.println("프로그램을 종료합니다."); return;
                default : System.out.println("잘못 누르셨습니다.");
            }
        }
    }
    
    // 글 전체보기
    public void printAll() {

        if (list.isEmpty()) {
            System.out.println("등록된 글이 없습니다.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getIdx() + "번. 제목 : " + list.get(i).getTitle()
                                  + "\t 글쓴이 : " + list.get(i).getWriter());
            }
        }
        System.out.println();
    }
    
    // 게시글 상세보기
    public void select() {
        printAll();
        
        System.out.print("상세보기 할 글 번호를 입력해주세요. : ");
        int index = sc.nextInt();
        
        for (int i = 0; i <list.size(); i++) {
            if(list.get(i).getIdx() == index) {
                System.out.println("제목 : " + list.get(i).getTitle()
                                 + "\t 글쓴이 : " + list.get(i).getWriter());
                System.out.println("작성 날짜 : " + list.get(i).getDate());
                System.out.println("내용 : " + list.get(i).getContent());
                

            }
        }
        printCmnt(index);
        
        while (true) {
            System.out.println("1. 댓글작성");
            System.out.println("2. 처음으로");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
            case 1:
                insertCmnt(index);
                return;
            case 2:
                return;
            default : System.out.println("잘못 누르셨습니다.");
            }
        }
        
        
    }
    
    // 댓글 작성하기
    public void insertCmnt(int bIdx){
        System.out.print("내용 : ");
        String cmnt = sc.nextLine();
        bc.createCmnt(cmnt, bIdx);
    }
    
    // 댓글 보기
    public void printCmnt(int bIdx) {
        if (cmntList.isEmpty()) {
            System.out.println("작성된 댓글이 없습니다.");
        } else {
            for (int i = 0; i < cmntList.size(); i++) {
                if(bIdx == cmntList.get(i).getIdx())
                System.out.println(cmntList);
            }
        }
        System.out.println();
    }
    
    
    // 글 작성하기
    public void insert() {
        System.out.println("제목 : ");
        String title = sc.nextLine();
        System.out.println("닉네임 : ");
        String writer = sc.nextLine();
        System.out.println("내용");
        System.out.print("> ");
        String content = sc.nextLine();
        
        bc.insert(title, writer, content);
    }
    
    // 글 삭제하기
    public void delete() {
        printAll();
        
        System.out.print("삭제할 글 번호를 입력해주세요. : ");
        int index = sc.nextInt();
        
        int result = bc.delete(index);
        
        if(result > 0) {
            System.out.println("성공적으로 삭제되었습니다.");
        } else {
            System.out.println("삭제가 성공적으로 이뤄지지 않았습니다.");
        }
        
        System.out.println();
    }
    
    // 글 수정
    public void update() {
        printAll();
        
        System.out.print("수정할 글 번호를 입력해주세요. : ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.print("수정할 제목 : ");
        String newTitle = sc.nextLine();
        System.out.print("수정할 글쓴이 : ");
        String newWriter = sc.nextLine();
        System.out.println("수정할 글 내용");
        System.out.print(" > ");
        String newContent = sc.nextLine();
        
        int result = bc.update(index, newTitle, newWriter, newContent);
        
        if (result > 0) {
            System.out.println("성공적으로 수정되었습니다.");
        } else {
            System.out.println("수정할 글을 찾지 못했습니다.");
        }
    }
    
    // 글 검색
    public void search() {
        System.out.println("검색할 내용을 입력해주세요.");
        System.out.print(" > ");
        String keyword = sc.nextLine();
        
        ArrayList<Board> searched = bc.search(keyword);
        if(searched.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("조회 결과 " + searched.size() + "건");
            for (Board b : searched) {
                System.out.println(b.getTitle() + "-" + b.getWriter());
            }
        }
        System.out.println();
    }
}
