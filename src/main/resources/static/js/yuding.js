window.onload = function() {
    var today = new Date(); // 获取当前日期
    var days = ['日', '一', '二', '三', '四', '五', '六'];
    var dateList = document.getElementById('dateList');

    // 计算本周一的日期
    var monday = new Date(today.getTime() - (today.getDay() - 1) * 24 * 3600 * 1000);

    // 计算本周的日期
    for (var i = 0; i < 7; i++) {
        for (var i = 0; i < 7; i++) {
        var date = new Date(monday.getTime() + i * 24 * 3600 * 1000);
        var dateString = (date.getMonth() + 1) + '月' + date.getDate() + '日';
        var div = document.createElement('div');
        div.innerHTML = dateString;

        // 将日期添加到不同的位置
        if (i === 0) {
            document.getElementById('date1').appendChild(div);
        } else if (i === 1) {
            document.getElementById('date2').appendChild(div);
        } else if (i === 2) {
            document.getElementById('date3').appendChild(div);
        } else if (i === 3) {
            document.getElementById('date4').appendChild(div);
        } else if (i === 4) {
            document.getElementById('date5').appendChild(div);
        } else if (i === 5) {
            document.getElementById('date6').appendChild(div);
        } else {
            document.getElementById('date7').appendChild(div);
        }
    }
}
}

 function updateEndTime(select) {
    // 获取选择的开始时间
    var startTimeStr = select.value;
    // 将开始时间转换为Date对象
    var startTime = new Date('2021-01-01 ' + startTimeStr);
    // 将开始时间的小时数加1，得到结束时间
    var endTime = new Date(startTime.getTime() + 60 * 60 * 1000);
    // 格式化结束时间，只显示小时和分钟
    var endTimeStr = ('0' + endTime.getHours()).slice(-2) + ':' + ('0' + endTime.getMinutes()).slice(-2);
    // 获取当前行
    var row = select.parentNode.parentNode;
    // 更新结束时间的输入框
    row.querySelector('.end-time').value = endTimeStr;
  }
