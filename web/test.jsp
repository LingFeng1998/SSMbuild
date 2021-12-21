<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/21
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    </script>
    <script>
        function a1(){
            $.post({
                url:"${pageContext.request.contextPath}/a1",
                data:{'name':$("#txtName").val()},
                success:function (data,status) {
                    alert(data);
                    alert(status);
                }
            });
        }

        $(function () {
            $("#btn").click(function () {
                $.post("${pageContext.request.contextPath}/books/allBook",function (data) {
                    console.log(data)
                    var html="";
                    for (var i = 0; i <data.length ; i++) {
                        html+= "<tr>" +
                            "<td>" + data[i].bookID + "</td>" +
                            "<td>" + data[i].bookName + "</td>" +
                            "<td>" + data[i].bookName + "</td>" +
                            "<td>" + data[i].bookName + "</td>" +
                            "</tr>"
                    }
                    $("#content").html(html);
                });
            })
        })
    </script>
</head>
<body>

<%--onblur：失去焦点触发事件--%>
用户名:<input type="text" id="txtName" onblur="a1()"/>


<input type="button" id="btn" value="获取数据"/>
<table width="80%" align="center">
    <tr>
        <th>书籍编号</th>
        <th>书籍名字</th>
        <th>书籍数量</th>
        <th>书籍详情</th>
    </tr>
    <tbody id="content">
    </tbody>
</table>

</body>
</html>
