<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.css"  rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/master.css" rel="stylesheet">
    <link href="css/style.min_EDT.css" rel="stylesheet">
    <title>河南省航空运动管理服务中心后台</title>
  </head>  
  <body class="fixed-sidebar full-height-layout gray-bg">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i></div>
            <div class="sidebar-collapse">
                <ul class="nav nav_L" id="side-menu">
                    <li class="nav-header">
                        <div class="profile-element">
                            <div class="index_logo"></div>
                            <div class="logo-element">河南省航空运动管理服务中心后台</div>
                        </div>
                        <div class="logo-element">航协</div>
                    </li>
                    <li>
                          <a href="hxTeamUi?id=${hxTeam.id }">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">主页</span>
                        </a>
                    </li>
                    <li>
                        <a class="J_menuItem" href="showTeamIntroduceByself?id=${hxTeam.id }">
                            <i class="fa fa-sitemap"></i>
                            <span class="nav-label">会员单位详情</span>
                            <span class="fa arrow"></span>
                        </a>
                        <!--  <ul class="nav nav-second-level">
                            
                            <li>
                                <a class="J_menuItem" href="">会员单位详情</a>
                            </li>                          
                        </ul>-->
                    </li>
                    <li>
                        <a  class="J_menuItem" href="showTeamPeople?id=${hxTeam.id }">
                            <i class="fa fa-user"></i>
                            <span class="nav-label">会员信息管理</span>
                        </a>
                       
                    </li>
                    <li>
                        <a href="">
                            <i class="fa fa-flag"></i>
                            <span class="nav-label">赛事管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="showMatchInTeam?id=${hxTeam.id }">赛事查看</a></li>
                                                     <li><a class="J_menuItem" href="toJoinMatch?id=${hxTeam.id }">赛事报名</a></li>
<!--<li><a class="J_menuItem" href="">赛事报名<span style="color:red;">(已截止)</span></a></li>-->
                            <li><a class="J_menuItem" href="showMyJoinTeam?id=${hxTeam.id }">查看报名队伍</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                         
                             <i class="fa fa-cny"></i>
                            <span class="nav-label">缴纳费用</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="teamIsFee?id=${hxTeam.id}">缴纳单位会费</a></li>
                            <li><a class="J_menuItem" href="toPayYearFeeForPeople?id=${hxTeam.id }">缴纳会员会费</a></li>
                          <!--    <li><a class="J_menuItem" href="AgentSettings.html">缴纳驾照考试费</a></li>
                            <li><a class="J_menuItem" href="ShareRecords.html">缴纳赛事报名费</a></li> -->                           
                        </ul>
                    </li>
                    <li>
                        <a href="WriteOffRecord.html">
                            <i class="fa fa-list"></i>
                            <span class="nav-label">缴费记录</span>
                        </a>
						<ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="showFeeRecovd?id=${hxTeam.id }">会费缴费记录</a></li>
                            <!-- <li><a class="J_menuItem" href="AgentSettings.html">驾照考试费缴费记录</a></li>
                            <li><a class="J_menuItem" href="ShareRecords.html">赛事报名费缴费记录</a></li>--> 
                            
                        </ul>
                    </li>
                  <!--  <li>
                        <a href="newsInfo">
                            <i class="fa fa-newspaper-o"></i>
                            <span class="nav-label">查看新闻</span>
                        </a>
						<ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="showNewsInTeam?id=${hxteam.id }">查看新闻</a></li>                         
                        </ul>
                    </li>   -->               
                    <li>
                        <a href="#">
                            <i class="fa fa-gear"></i>
                            <span class="nav-label">系统设置</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="tochangewordforHxTeam?id=${hxTeam.id }">修改密码</a></li>                            
                            <li><a class="J_menuItem" href="helpword">帮助文档</a></li>
                            <li><a class="J_menuItem" href="feedback">意见反馈</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">
                       <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " >
                            <i class="fa fa-bars"></i> 
                        </a> 
                    </div>
                    <ul class="nav nav_r navbar-top-links navbar-right">                        
                        <li class="">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:;" aria-expanded="false">
                                <i class="fa fa-user"></i>
                                ${hxTeam.fullname }${hxTeam.sn}
                            </a>
                            
                        </li>
                        <li>
                            <a href="logout"><i class="fa fa fa-sign-out"></i>退出</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row content-tabs">
                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-angle-double-left"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="javascript:;" class="active J_menuTab" data-id="index_v1.html">首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-angle-double-right"></i></button>
                <div class="btn-group roll-nav roll-right">
                    <button data-toggle="dropdown" class="dropdown J_tabClose" aria-expanded="false">
                        操作<span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                        <li class="J_tabShowActive">
                            <a>定位当前选项卡</a>
                        </li>
                        <li class="divider"></li>
                        <li class="J_tabCloseAll">
                            <a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther">
                            <a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>  
            </div>
            		<style type="text/css">
.scroll-wrapperaaaa{height:100%;-webkit-overflow-scrolling:touch;overflow:auto;}
		</style>
<script type="text/javascript">
var UA = navigator.userAgent;
    var forIOS = function(){
        if(!UA.match(/iPad/) && !UA.match(/iPhone/) && !UA.match(/iPod/)){return;}
        if($('#wrapper').length){return;}
        $('body').children().not('script').wrapAll(''); }();
</script>
            <div class="row J_mainContent scroll-wrapperaaaa" id="content-main">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="showTeamPeople?id=${hxTeam.id } " frameborder="0" data-id="" seamless> </iframe><!-- getTeamHxPeople?id=${id } -->
            </div>
            <div class="footer">
                <div class="pull-right">
                    Copyright © 2018 猛犸科技 
                </div>
            </div>
        </div>
        <!--右侧部分结束-->
    </div>
    <!-- 全局js -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="js/plugins/layer/layer.min.js"></script>
    <!-- 自定义js -->
    <script src="js/hplus.min.js"></script>
    <script type="text/javascript" src="js/contabs.min.js"></script>
    <!-- 第三方插件 -->
    <script src="js/plugins/pace/pace.min.js"></script>
</body>
</html>
