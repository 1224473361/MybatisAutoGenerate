/**
 * 项目js主入口
 * 以依赖layui的layer和form模块为例
 */
layui.define(['layer','form'],function(exports){
	var layer=layui.layer;
	var form=layui.form;
	
	//layer.msg("微软第三方");
	//注意这里是模块输出的核心，模块名必须和use时的模块名一致
	exports('index',function(){
		alert("fsdfs")
	});
});