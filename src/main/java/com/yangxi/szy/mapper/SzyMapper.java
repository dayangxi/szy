package com.yangxi.szy.mapper;

import com.yangxi.szy.modal.ResultItem;
import com.yangxi.szy.modal.ZbjkItem;
import com.yangxi.szy.rqt.Rqt6001;
import com.yangxi.szy.rqt.Rqt6002;
import com.yangxi.szy.rqt.Rqt6003;
import com.yangxi.szy.rqt.Rqt6004;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SzyMapper {
    //小程序登录
    @Select("call p_usr_verify_ex(#{usr}, #{pwd}, #{yzm})")
    ResultItem login(Rqt6001 rqt);

    //小程序登录
    @Select("call p_usr_mmxg(#{usr}, #{pwdold}, #{pwdnew}, #{yzm})")
    ResultItem modifyPwd(Rqt6004 rqt);

    //驻场服务后台
    @Select("call p_admin_verify(#{usr}, #{pwd})")
    ResultItem adminLogin(Rqt6002 rqt);

    //驻场服务单号
    @Select("call p_next_fwdh()")
    String nextFWDH(Rqt6003 rqt);

    //添加新的验证码
    @Insert({"insert into tbyzm(cyzm, itype, dsj) "+
            "values(#{yyzm}, #{ttype}, now())"})
    int addYZM(String yyzm, int ttype);

    //得到一个待发送的指标监控
    @Select("select * from tbzbbj where izt = 0 order by djssj limit 1")
    ZbjkItem getOneZbjk();

    //更新指定指标的发送状态和发送时间
    @Update("update tbzbbj set izt = 1, dfssj = now() where iid = #{iid}")
    int updateZbjk(int iid);
}
