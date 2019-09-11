package com.yangxi.szy.relationtree;

import java.util.List;

public class Player {
    private String selfAddr;
    private String fatherAddr;
    private List<Player> sons;

    public Player() {
    }

    public Player(String selfAddr, String fatherAddr, List<Player> sons) {
        this.selfAddr = selfAddr;
        this.fatherAddr = fatherAddr;
        this.sons = sons;
    }

    public String getSelfAddr() {
        return selfAddr;
    }

    public void setSelfAddr(String selfAddr) {
        this.selfAddr = selfAddr;
    }

    public String getFatherAddr() {
        return fatherAddr;
    }

    public void setFatherAddr(String fatherAddr) {
        this.fatherAddr = fatherAddr;
    }

    public List<Player> getSons() {
        return sons;
    }

    public void setSons(List<Player> sons) {
        this.sons = sons;
    }

    @Override
    public String toString() {
        String sonStr = "[empty]";
        if(sons!=null && sons.size() > 0){
            sonStr = "["+sons.size()+" : ";
            for (Player player : sons){
                sonStr = sonStr + player.getSelfAddr() + ",";
            }
            sonStr = sonStr + "]";
        }

        return "Player{" +
                "addr='" + selfAddr + '\'' +
                ", sons=" + sonStr +
                '}';
    }
}
