package net.anjero.pro.common.constant;

/**
*
 */
public final class Globals {
	/**
	 * 保存用户到SESSION
	 */
	public static String USER_SESSION="USER_SESSION";
	/**
	 * 人员类型
	 */
	public static Integer User_Normal=1;//正常
	public static Integer User_Forbidden=0;//禁用
	public static Integer User_ADMIN=-1;//超级管理员
	/**
	 *日志级别定义
	 */
	public static Integer Log_Leavel_INFO=1;
	public static Integer Log_Leavel_WARRING=2;
	public static Integer Log_Leavel_ERROR=3;
	 /**
	  * 日志类型
	  */
	 public static Integer Log_Type_LOGIN=1; //登陆
	 public static Integer Log_Type_EXIT=2;  //退出
	 public static Integer Log_Type_INSERT=3; //插入
	 public static Integer Log_Type_DEL=4; //删除
	 public static Integer Log_Type_UPDATE=5; //更新
	 public static Integer Log_Type_UPLOAD=6; //上传
	 public static Integer Log_Type_OTHER=7; //其他
	 
	 
	 /**
	  * 词典分组定义
	  */
	 public static String TypeGroup_Database="database";//数据表分类
	 
	 /**
	  * 权限等级
	  */
	 public static Integer Function_Leave_ONE=0;//一级权限
	 public static Integer Function_Leave_TWO=1;//二级权限
	 
	 /**
	  * 权限等级前缀
	  */
	 public static String Function_Order_ONE="ofun";//一级权限
	 public static String Function_Order_TWO="tfun";//二级权限

	 /**
	  * 新闻法规
	  */
	 public static Integer Document_NEW=0; //新建
	 public static Integer Document_PUBLICH=0; //发布

	 /**
	  * 配置系统是否开启按钮权限控制
	  */
	 public static boolean BUTTON_AUTHORITY_CHECK = false;

}
