package com.yangxi.szy;

import com.yangxi.szy.handler.FuncCode;
import com.yangxi.szy.mapper.YzcxMapper;
import com.yangxi.szy.modal.ResultItem;
import com.yangxi.szy.rqt.Rqt6001;
import com.yangxi.szy.rqt.Rqt6002;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YzcxTests {
    private static final Logger log = LoggerFactory.getLogger(YzcxTests.class);

    @Autowired
    protected YzcxMapper yzcxMapper;

    @Test
    public void login() {
        Rqt6001 rqt = new Rqt6001(FuncCode.YZCX_LOGIN,
                "test1","1123");
        ResultItem resultItem = yzcxMapper.login(rqt);
        log.info(resultItem.toString());
    }

    @Test
    public void adminLogin() {
        Rqt6002 rqt = new Rqt6002(FuncCode.ADMIN_LOGIN,
                "test1","1123");
        ResultItem resultItem = yzcxMapper.adminLogin(rqt);
        log.info(resultItem.toString());
    }
}
