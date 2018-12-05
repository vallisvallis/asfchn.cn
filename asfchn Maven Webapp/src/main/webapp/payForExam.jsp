<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'payForExam.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body >
  <div align="center">
   <form name=alipayment action=alipay.trade.page.pay.jsp method=post
			target="_blank">
			<div id="body1" class="show" name="divcontent">
				<dl class="content">
					<dt>商户订单号 ：</dt>
					<dd>
						<input id="WIDout_trade_no" name="WIDout_trade_no" />
						
					</dd>
					<hr class="one_line">
					<dt>订单名称 ：</dt>
					<dd>
						<input id="exp" name="exp" value="${joinExamPeople.peoplesn}'s examFee" disabled="disabled"/>
						<input type="hidden" id="WIDsubject" name="WIDsubject" value="${joinExamPeople.peoplesn }'s examFee" />
						
					</dd>
					<hr class="one_line">
					<dt>付款金额 ：</dt>
					<dd>
						<input id="exp1" name="exp1" value="${examFee }" disabled="disabled" />
						<input type="hidden"  id="WIDtotal_amount" name="WIDtotal_amount" value="${examFee }" />
					</dd>
					<hr class="one_line">
					<dt>商品描述：</dt>
					<dd>
						<input id="exp2" name="exp2" value="examFee" disabled="disabled"/>
						<input type="hidden" id="WIDbody" name="WIDbody" value="examFee" />
						
					</dd>
					<hr class="one_line">
					<dt></dt>
					<dd id="btn-dd">
						<span class="new-btn-login-sp">
							<button class="new-btn-login" type="submit"
								style="text-align: center;" onclick="examFeerecordsss()">付 款</button>
						</span> <span class="note-help">如果您点击“付款”按钮，即表示您同意该次的执行操作。</span>
						<span style="color:red">注意！！！ 您的商品号，可以在支付宝内查询。若想再次报名，请重新登录！！！</span>
					</dd>
				</dl>
			</div>
		</form>
		</div>
		
		<script language="javascript">

		function GetDateNow() {
			var vNow = new Date();
			var sNow = "";
			sNow += String(vNow.getFullYear());
			sNow += String(vNow.getMonth() + 1);
			sNow += String(vNow.getDate());
			sNow += String(vNow.getHours());
			sNow += String(vNow.getMinutes());
			sNow += String(vNow.getSeconds());
			sNow += String(vNow.getMilliseconds());
			document.getElementById("WIDout_trade_no").value =  sNow;
		
		
		}
		GetDateNow();
		</script>

  </body>
</html>
