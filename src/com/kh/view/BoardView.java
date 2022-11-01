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
            System.out.println("1. �� �ۼ��ϱ�");
            System.out.println("2. �� �����ϱ�");
            System.out.println("3. �� �����ϱ�");
            System.out.println("4. �� �˻��ϱ�");
            System.out.println("5. ��ü �� ��� ����");
            System.out.println("6. �� �� ����");
            System.out.println("0. ����");
            System.out.print("�޴� �Է� : ");
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
                case 0 : System.out.println("���α׷��� �����մϴ�."); return;
                default : System.out.println("�߸� �����̽��ϴ�.");
            }
        }
    }
    
    // �� ��ü����
    public void printAll() {

        if (list.isEmpty()) {
            System.out.println("��ϵ� ���� �����ϴ�.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getIdx() + "��. ���� : " + list.get(i).getTitle()
                                  + "\t �۾��� : " + list.get(i).getWriter());
            }
        }
        System.out.println();
    }
    
    // �Խñ� �󼼺���
    public void select() {
        printAll();
        
        System.out.print("�󼼺��� �� �� ��ȣ�� �Է����ּ���. : ");
        int index = sc.nextInt();
        
        for (int i = 0; i <list.size(); i++) {
            if(list.get(i).getIdx() == index) {
                System.out.println("���� : " + list.get(i).getTitle()
                                 + "\t �۾��� : " + list.get(i).getWriter());
                System.out.println("�ۼ� ��¥ : " + list.get(i).getDate());
                System.out.println("���� : " + list.get(i).getContent());
                

            }
        }
        printCmnt(index);
        
        while (true) {
            System.out.println("1. ����ۼ�");
            System.out.println("2. ó������");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
            case 1:
                insertCmnt(index);
                return;
            case 2:
                return;
            default : System.out.println("�߸� �����̽��ϴ�.");
            }
        }
        
        
    }
    
    // ��� �ۼ��ϱ�
    public void insertCmnt(int bIdx){
        System.out.print("���� : ");
        String cmnt = sc.nextLine();
        bc.createCmnt(cmnt, bIdx);
    }
    
    // ��� ����
    public void printCmnt(int bIdx) {
        if (cmntList.isEmpty()) {
            System.out.println("�ۼ��� ����� �����ϴ�.");
        } else {
            for (int i = 0; i < cmntList.size(); i++) {
                if(bIdx == cmntList.get(i).getIdx())
                System.out.println(cmntList);
            }
        }
        System.out.println();
    }
    
    
    // �� �ۼ��ϱ�
    public void insert() {
        System.out.println("���� : ");
        String title = sc.nextLine();
        System.out.println("�г��� : ");
        String writer = sc.nextLine();
        System.out.println("����");
        System.out.print("> ");
        String content = sc.nextLine();
        
        bc.insert(title, writer, content);
    }
    
    // �� �����ϱ�
    public void delete() {
        printAll();
        
        System.out.print("������ �� ��ȣ�� �Է����ּ���. : ");
        int index = sc.nextInt();
        
        int result = bc.delete(index);
        
        if(result > 0) {
            System.out.println("���������� �����Ǿ����ϴ�.");
        } else {
            System.out.println("������ ���������� �̷����� �ʾҽ��ϴ�.");
        }
        
        System.out.println();
    }
    
    // �� ����
    public void update() {
        printAll();
        
        System.out.print("������ �� ��ȣ�� �Է����ּ���. : ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.print("������ ���� : ");
        String newTitle = sc.nextLine();
        System.out.print("������ �۾��� : ");
        String newWriter = sc.nextLine();
        System.out.println("������ �� ����");
        System.out.print(" > ");
        String newContent = sc.nextLine();
        
        int result = bc.update(index, newTitle, newWriter, newContent);
        
        if (result > 0) {
            System.out.println("���������� �����Ǿ����ϴ�.");
        } else {
            System.out.println("������ ���� ã�� ���߽��ϴ�.");
        }
    }
    
    // �� �˻�
    public void search() {
        System.out.println("�˻��� ������ �Է����ּ���.");
        System.out.print(" > ");
        String keyword = sc.nextLine();
        
        ArrayList<Board> searched = bc.search(keyword);
        if(searched.isEmpty()) {
            System.out.println("�˻� ����� �����ϴ�.");
        } else {
            System.out.println("��ȸ ��� " + searched.size() + "��");
            for (Board b : searched) {
                System.out.println(b.getTitle() + "-" + b.getWriter());
            }
        }
        System.out.println();
    }
}
