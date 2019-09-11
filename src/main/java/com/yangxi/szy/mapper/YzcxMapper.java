package com.yangxi.szy.mapper;

import com.yangxi.szy.modal.ResultItem;
import com.yangxi.szy.rqt.Rqt6001;
import com.yangxi.szy.rqt.Rqt6002;
import com.yangxi.szy.rqt.Rqt6003;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface YzcxMapper {
    //小程序登录
    @Select("call p_usr_verify(#{usr}, #{pwd})")
    ResultItem login(Rqt6001 rqt);

    //驻场服务后台
    @Select("call p_admin_verify(#{usr}, #{pwd})")
    ResultItem adminLogin(Rqt6002 rqt);

    //驻场服务单号
    @Select("call p_next_fwdh()")
    String nextFWDH(Rqt6003 rqt);
}
