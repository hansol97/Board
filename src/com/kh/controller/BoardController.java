package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.vo.Board;
import com.kh.model.vo.Comment;

public class BoardController {
    
    private ArrayList<Board> list = new ArrayList<Board>();
    private ArrayList<Comment> cmntList = new ArrayList<Comment>();
    
    // 글 작성
    public void insert(String title, String writer, String content) {
        list.add(new Board(title, writer, content));
    }
    
    // 전체 글 출력
    public ArrayList<Board> printAll(){
        
        return list;
    }
    
    // 댓글 작성
    public void createCmnt(String cmnt, int idx) {
        cmntList.add(new Comment(cmnt, idx));
    }
    
    // 댓글 목록
    public ArrayList<Comment> printAllCmnt(){
        
        return cmntList;
    }

    // 게시글 삭제하기
    public int delete(int index) {
        int result = 0;
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdx() == index) {
                list.remove(i);
                
                result++;
            }
        }
        return result;
    }
    
    // 글 수정하기
    public int update(int index, String newTitle, String newWriter, String newContent) {
        int result = 0;
        
        for (int i = 0; i < list.size(); i++) {
            if (index == list.get(i).getIdx()) {
                // 게터 써가지고 int형이 값이 온걸 변수로 빼놓는다
                int existingIdx = list.get(i).getIdx();
                list.set(i, new Board(newTitle, newWriter, newContent));
                list.get(i).setIdx(existingIdx);
                result++;
            }
        }
        return result;
    }
    
    // 글 검색하기
    public ArrayList<Board> search(String keyword) {
        ArrayList<Board> searched = new ArrayList<Board>();
        
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getTitle().contains(keyword) ||
               list.get(i).getContent().contains(keyword) ||
               list.get(i).getWriter().contains(keyword)) {
                searched.add(list.get(i));
            }  
        }
        return searched;
    }
}
