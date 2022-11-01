package com.kh.model.vo;

import java.util.Calendar;
import java.util.Date;

public class Board {
    // �ۼ���, ����, ����, ��¥, �� ��ȣ
    public static int count;
    private String writer; // ����� �ۼ�
    private String title; // ����� �ۼ�
    private String content; // ����� �ۼ�
    private Date date;
    private int idx;
    
    public Board() {
    }
    public Board(String writer, String title, String content) {
        count++;
        this.writer = writer;
        this.title = title;
        this.content = content;
        idx = count;
        date = Calendar.getInstance().getTime(); 
        
    }
    
    public static int getCount() {
        return count;
    }
    public static void setCount(int count) {
        Board.count = count;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getIdx() {
        return idx;
    }
    public void setIdx(int idx) {
        this.idx = idx;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        return "Board [idx=" + idx + ", title=" + title + ", writer=" + writer +  ", date=" + date + "]\n[content=" + content + "]";
    }
}
