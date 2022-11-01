package com.kh.model.vo;

public class Comment {
    // 댓글내용, 게시글 번호
    private String cmnt;
    private int idx;
    
    public Comment() {
        super();
    }
    public Comment(String cmnt, int idx) {
        super();
        this.cmnt = cmnt;
        this.idx = idx;
    }
    
    public String getCmnt() {
        return cmnt;
    }
    public void setCmnt(String cmnt) {
        this.cmnt = cmnt;
    }
    public int getIdx() {
        return idx;
    }
    public void setIdx(int idx) {
        this.idx = idx;
    }
    
    @Override
    public String toString() {
        return "Comment [cmnt=" + cmnt + ", idx=" + idx + "]";
    }
    
    

}
