<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"
	+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>

<html >
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css">
    <link href="css/font-awesome.min.css"  rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min_EDT.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/master.css">
    <link rel="stylesheet" type="text/css" href="css/plugins/iCheck/custom.css">
    <title>门店管理</title>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>门店管理</h5>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <form class="form-horizontal">
                            <div class="col-sm-12">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="J_menuItem">
                                            <div class="widget green-bg p-lg text-center">
                                                <div class="m-b-md">
                                                    <h1 class="m-xs">50</h1>
                                                    <span class="m-xs box-block">体验门店</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <a class="J_menuItem" data-title="付费门店" href="#">
                                            <div class="widget  yellow-bg p-lg text-center">
                                                <div class="m-b-md">
                                                    <h1 class="m-xs">20</h1>
                                                    <span class="m-xs box-block">付费门店</span>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="col-sm-3">
                                        <a class="J_menuItem" data-title="付费总计" href="#">
                                            <div class="widget  blue-bg p-lg text-center">
                                                <div class="m-b-md">
                                                    <h1 class="m-xs">5146</h1>
                                                    <span class="m-xs box-block">付费总计</span>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="col-md-12">
                                            <div class="widget lazur-bg">
                                                <h4>今日新增</h4>
                                                <div class="box-block">
                                                    <p>1，体验门店个数</p>
                                                    <p>2，付费门店个数</p>
                                                    <p>3，今日付费金额合计</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="hr-line-dashed"></div>
                    <div class="row m-b-lg m-t-lg">
                        <div class="col-sm-4"></div>
                        <div class="col-sm-4 text-center">
                            <div class="form-group">
                                <div class="input-group">
                                    <input class="form-control" id="Keywords" name="Keywords" placeholder="姓名/车牌号" type="text" value="">
                                    <span class="input-group-btn">
                                        <button type="submit" class="btn btn-primary">
                                            <i class="fa fa-search"></i> 搜索
                                        </button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-hover" id="ListTB">
                            <thead>
                                <tr>
                                    <th><input type="checkbox" class="i-checks" name="IDs" style="position: absolute; opacity: 0;"></th>
                                    <th>门店名称</th>
                                    <th>绑定手机 <i class="fa fa-sort"></i></th>
                                    <th>创建活动数 <i class="fa fa-sort"></i></th>
                                    <th>收入合计</th>
                                    <th>类型 <i class="fa fa-sort"></i></th>
                                    <th>状态 <i class="fa fa-sort"></i></th>
                                    <th>到期时间</th>
                                    <th>描述</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <input type="checkbox" class="i-checks" name="IDs" style="position: absolute; opacity: 0;">
                                    </td>
                                    <td>飞翔汽车</td>
                                    <td>13812345678</td>
                                    <td>6</td>
                                    <td>658974.13</td>
                                    <td>体验</td>
                                    <td>到期</td>
                                    <td>2017-09-20 12：09</td>
                                    <td><a href="#">详情</a></td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="checkbox" class="i-checks" name="IDs" style="position: absolute; opacity: 0;">
                                    </td>
                                    <td>飞翔汽车</td>
                                    <td>13812345678</td>
                                    <td>6</td>
                                    <td>658974.13</td>
                                    <td>体验</td>
                                    <td>到期</td>
                                    <td>2017-09-20 12：09</td>
                                    <td><a href="#">详情</a></td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="checkbox" class="i-checks" name="IDs" style="position: absolute; opacity: 0;">
                                    </td>
                                    <td>飞翔汽车</td>
                                    <td>13812345678</td>
                                    <td>6</td>
                                    <td>658974.13</td>
                                    <td>体验</td>
                                    <td>到期</td>
                                    <td>2017-09-20 12：09</td>
                                    <td><a href="#">详情</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <nav class="navbar-right" id="pagination">
                                <ul class="pagination no-margins">
                                    <li class="active"><a href="javascript:;">1</a></li><li><a href="javascript:;" onclick="ToPageIndex(2)">2</a></li><li><a href="javascript:;" onclick="ToPageIndex(3)">3</a></li><li><a href="javascript:;" onclick="ToPageIndex(4)">4</a></li><li><a href="javascript:;" onclick="ToPageIndex(5)">5</a></li><li><a href="javascript:;" onclick="ToPageIndex(6)">6</a></li><li><a href="javascript:;" onclick="ToPageIndex(7)">7</a></li><li><a href="javascript:;" onclick="ToPageIndex(8)">8</a></li><li><a href="javascript:;" onclick="ToPageIndex(2)">&gt;</a></li><li><a aria-label="Next" href="javascript:;" onclick="ToPageIndex(32)"><span aria-hidden="true">&gt;&gt;</span></a></li>
                                </ul>
                            </nav>
                            <div class="clearfix"></div>
                        </div>
                        <div class="col-sm-3 text-left">
                            共 <span class="text-danger">318 </span>条，第 <span class="text-danger">1 / 32 </span> 页
                        </div>
                        <div class="col-sm-3 text-right">
                            <div data-toggle="buttons" class="btn-group" id="PageSizeRG">
                                <label class="btn btn-sm btn-white active">
                                    <input type="radio" name="PageSizeR" value="10">10</label>
                                <label class="btn btn-sm btn-white">
                                    <input type="radio" name="PageSizeR" value="20">20</label>
                                <label class="btn btn-sm btn-white">
                                    <input type="radio" name="PageSizeR" value="50">50</label>
                            </div>
                            <div class="clearfix"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/plugins/iCheck/icheck.min.js"></script>
<script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>
<script>
    $(document).ready(function(){
        $(".nav-tab-info li a:eq(0)").addClass("active");
        $(".i-checks").iCheck({
            checkboxClass:"icheckbox_square-green",
            radioClass:"iradio_square-green"
        })
    });
</script>
</body>
</html>