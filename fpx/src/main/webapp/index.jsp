<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- BEGIN META -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Olive Enterprise">
    <!-- END META -->
    <script src="<%=basePath%>/js/jquery-1.11.3.min.js"></script>
    <!-- 1.引入 echarts.js -->
    <script src="<%=basePath%>/js/echarts.min.js"></script>
    <html>
    <!-- BEGIN MAIN CONTENT -->
    <section id="main-content">
        <!-- BEGIN WRAPPER  -->
        <section class="wrapper">
            <div class="row">
                <div class="col-lg-12 col-sm-12">
                    <section class="panel">
                        <div class="panel-body">
                            <div id="line" style="width: 800px; height: 400px;"></div>
                            <script type="text/javascript">
                                $(document).ready(
                                    function() {
                                        var myChart = echarts.init(document.getElementById('line'));
                                        // 显示标题，图例和空的坐标轴
                                        myChart.setOption({
                                            title: {
                                                text: '流量信息概况'
                                            },
                                            tooltip: {
                                                trigger: 'axis'
                                            },
                                            legend: {
                                                data:[]
                                            },
                                            grid: {
                                                left: '3%',
                                                right: '4%',
                                                bottom: '3%',
                                                containLabel: true
                                            },
                                            toolbox: {
                                                feature: {
                                                    saveAsImage: {}
                                                }
                                            },
                                            legend : {
                                                data : [ '浏览次数','独立访客','ip', '新独立访客','访问次数' ]
                                            },
                                            xAxis: {
                                                type: 'category',
                                                boundaryGap: false,
                                                data: []
                                            },
                                            yAxis: {
                                                type: 'value'
                                            },
                                            series: [
                                                {
                                                    name: '浏览次数',
                                                    type: 'line',
                                                    stack: '总量',
                                                    data: []
                                                },
                                                {
                                                    name: '独立访客',
                                                    type: 'line',
                                                    stack: '总量',
                                                    data: []
                                                },
                                                {
                                                    name: 'ip',
                                                    type: 'line',
                                                    stack: '总量',
                                                    data: []
                                                },
                                                {
                                                    name: '新独立访客',
                                                    type: 'line',
                                                    stack: '总量',
                                                    data:[]
                                                },
                                                {
                                                    name: '访问次数',
                                                    type: 'line',
                                                    stack: '总量',
                                                    data: []
                                                }
                                            ]
                                        });
                                        myChart.showLoading();
                                        $.ajax({
                                            type:"post",
                                            url:"<%=basePath%>/FlowNum",
                                            dataType:"json",
                                            success:function(data) {
                                                myChart.setOption({
                                                    xAxis : {
                                                        data : data.dateArrays
                                                    },
                                                    series : [ {
                                                        // 根据名字对应到相应的系列
                                                        name : '浏览次数',
                                                        data : data.pvArrays
                                                    },{
                                                        name : '独立访客',
                                                        data : data.uvArrays
                                                    },{
                                                        name : 'ip',
                                                        data : data.ipArrays
                                                    },{
                                                        name : '新独立访客',
                                                        data : data.newUvArrays
                                                    },{
                                                        name : '访问次数',
                                                        data : data.visitArrays
                                                    }]
                                                });
                                                //数据加载完成后再调用 hideLoading 方法隐藏加载动画
                                                myChart.hideLoading();
                                            }
                                        });
                                    });

                            </script>

                            <!-- BEGIN ROW  最近7天日平均PV量-->
                            <div class="row">
                                <div class="col-lg-6 col-sm-6">
                                    <section class="panel">
                                        <div class="panel-body">
                                            <div id="main1" style="width: 600px; height: 400px;"></div>
                                            <script type="text/javascript">
                                                $(document).ready(
                                                    function() {
                                                        var myChart = echarts.init(document.getElementById('main1'));
                                                        // 显示标题，图例和空的坐标轴
                                                        myChart.setOption({
                                                            title : {
                                                                text : '最近7天日平均PV量',
                                                                subtext: '动态数据'
                                                            },
                                                            tooltip : {},
                                                            legend : {
                                                                data : [ '日平均PV量' ]
                                                            },
                                                            xAxis : {
                                                                data : []
                                                            },
                                                            yAxis : {},
                                                            series : [ {
                                                                name : '日平均PV量',
                                                                type : 'bar',
                                                                data : []
                                                            } ]
                                                        });
                                                        //loading 动画
                                                        myChart.showLoading();

                                                        $.ajax({
                                                            type:"post",
                                                            url:"<%=basePath%>/AvgPvNum",
                                                            dataType:"json",
                                                            success:function(data) {
                                                                myChart.setOption({
                                                                    xAxis : {
                                                                        data : data.dates
                                                                    },
                                                                    series : [ {
                                                                        // 根据名字对应到相应的系列
                                                                        name : 'PV量',
                                                                        data : data.data
                                                                    } ]
                                                                });
                                                                //数据加载完成后再调用 hideLoading 方法隐藏加载动画
                                                                myChart.hideLoading();

                                                            }
                                                        });
                                                    });
                                            </script>
                                        </div>
                                    </section>
                                </div>
        <section>
        <!-- END MAIN CONTENT -->
        <!-- BEGIN FOOTER -->
        <footer class="site-footer">
            <div class="text-center">
                2017 &copy; PINYOUGOU by <a href="" target="_blank"> www.gec-edu.org
            </a> <a href="http://www.gec-edu.org" class="go-top">
                <i
                        class="fa fa-angle-up">
                </i>
            </a>
            </div>
            -- END  FOOTER -->
        </footer>
        </section>
    <!-- END SECTION -->
    <!-- BEGIN JS -->
    </html>