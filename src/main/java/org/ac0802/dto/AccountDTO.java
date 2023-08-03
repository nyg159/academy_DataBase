package org.ac0802.dto;

import java.sql.Date;

public class AccountDTO {
    private int idx;
    private String userId;
    private String userPw;
    private String nick;
    private String email;
    private Date join_Date;

    public String getUserId() {

        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserPw() {

        return userPw;
    }
    public void setUserPw(String userPw) {

        this.userPw = userPw;
    }
    public String getNick() {

        return nick;
    }
    public void setNick(String nick) {

        this.nick = nick;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public Date getJoin_Date() {

        return join_Date;
    }
    public void setJoin_Date(Date join_Date) {

        this.join_Date = join_Date;
    }
    public int getIdx() {
        return idx;
    }
    public void setIdx(int idx) {
        this.idx = idx;
    }
}
