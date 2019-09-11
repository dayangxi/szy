/**
 * @desc : 后台请求辅助函数
 * @auth : v0.1 by yx 2019-04-23
 * */
layui.define(function(exports){
    var obj = {
        //请求url
        url : function(){
            return 'https://127.0.0.1/phy';
        },

        //对指定对象进行url编码
        encode : function(obj){
            return encodeURIComponent(JSON.stringify(obj));
        },

        //医院添加
        rqt4002: function(key, yybm, yymc, desc){
            var rqtObj = {
                code:"4002",
                key:key,
                yybm:yybm,
                yymc:yymc,
                desc:desc
            };

            return rqtObj;
        },

        //医院更新
        rqt4003: function(key, yyid, yybm, yymc, desc){
            var rqtObj = {
                code:"4003",
                key:key,
                yyid:yyid,
                yybm:yybm,
                yymc:yymc,
                desc:desc
            };

            return rqtObj;
        },

        //医院删除
        rqt4004: function(key, yyid){
            var rqtObj = {
                code:"4004",
                key:key,
                yyid:yyid
            };

            return rqtObj;
        },

        //医院列表
        rqt4006: function(key, gltj){
            var rqtObj = {
                code:"4006",
                key:key,
                gltj:gltj
            };

            return rqtObj;
        },
    };

    //输出test接口
    exports('yxHelper', obj);
});
