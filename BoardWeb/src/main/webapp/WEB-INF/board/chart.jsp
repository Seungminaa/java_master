<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
		
      let chartData = [['Name','countPerName']]; //[[], [], []]
      const xhtp = new XMLHttpRequest();
      xhtp.open('get','replyCountJson.do');
      xhtp.send();
      xhtp.onload = function(){ //onload 중에 데이터를 요청해서 데이터를 사용해야함(비동기 방식 : 쓰레드가 병렬으로 처리되어서 다른곳에서 데이터가 사용안됨)
        let result = JSON.parse(xhtp.responseText);
        result.forEach(item => {
          chartData.push([item.name, item.cnt]);
        })
          google.charts.setOnLoadCallback(drawChart);
      }
      function drawChart() {

        var data = google.visualization.arrayToDataTable(chartData);

        var options = {
          title: 'My Daily Activities'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
