package com.yangxi.szy.relationtree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class FamilyTree {
    private static final Logger log = LoggerFactory.getLogger(FamilyTree.class);

    //全局零地址
    public static final String ZERO_ADDR = "0x0000000000000000000000000000000000000000";

    //全局错误类型
    public enum ErrorType {
        ET_NONE, ET_ADDR, ET_EXIST, ET_SELF ;
    }

    //全局玩家表
    private Map<String, Player> payers = new HashMap<>();

    public FamilyTree() {
        //初始化族谱，只存在一个空地址的根节点
        Player root = new Player(ZERO_ADDR, ZERO_ADDR, new ArrayList<Player>());
        payers.put(ZERO_ADDR, root);
    }

    //添加一个新的玩家father:推荐人地址
    public ErrorType addPlayer(String addr, String father) {
        //统一将地址转为小写
        String addrLoc = addr.toLowerCase();
        String fatherLoc = father.toLowerCase();

        //玩家地址无效
        if (addrLoc.equals(ZERO_ADDR)){
            return ErrorType.ET_ADDR;
        }

        //不能自己推荐自己
        if (addrLoc.equals(fatherLoc)){
            return ErrorType.ET_SELF;
        }

        //检查玩家是否已经注册
        if (payers.containsKey(addrLoc)){
            return ErrorType.ET_EXIST;
        }

        //检查推荐人节点是否存在，如果不存在默认为根节点
        if (!payers.containsKey(fatherLoc))
            fatherLoc = ZERO_ADDR;

        //玩家不存在，增加新玩家
        Player newGuy = new Player(addrLoc, fatherLoc, new ArrayList<Player>());

        //增加到全局映射表
        payers.put(addrLoc, newGuy);

        //父亲节点子孙增加该节点
        Player fatherGuy = payers.get(fatherLoc);
        fatherGuy.getSons().add(newGuy);

        return ErrorType.ET_NONE;
    }

    //得到指定节点的推荐人
    public String getFather(String addr){
        //玩家未注册
        if(!payers.containsKey(addr))
            return ZERO_ADDR;

        Player guy = payers.get(addr);
        return guy.getFatherAddr();
    }

    //从根节点开始遍历树
    public void prtAllSons() {
        prtHelper(payers.get(ZERO_ADDR));
    }

    //递归打印节点
    public void prtHelper(Player node) {
        //首先打印自己
        log.info(node.toString());

        //递归打印所有孩子
        for(Player son : node.getSons()){
            prtHelper(son);
        }
    }
}
