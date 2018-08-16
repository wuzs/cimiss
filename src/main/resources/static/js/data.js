$(function () {
    $.ajax({
        type: "GET",
        url: "/listTasks",
        dataType: "json",
        success: function(result){

            if(result && result.length>0){
                var dataTable = $("#tcontent");
                dataTable.empty();
                for(var i=0;i<result.length;i++){
                    var data = result[i];
                    var tr= $("<tr></tr>");
                    tr.appendTo(dataTable)
                    var tname=$("<td value='"+data.taskCode+"'>"+data.taskName+"</td>").appendTo(tr);
                    var ctime = $("<td>"+(data.dataStartTime==null?'':data.dataStartTime)+"</td>").appendTo(tr);;
                    var dinterval = $("<td>"+(data.nextDataTimeInterval==null?'':data.nextDataTimeInterval)+"</td>").appendTo(tr);
                    var ttime= $("<td>"+(data.taskStartTime==null?'':data.taskStartTime)+"</td>").appendTo(tr);
                    var tdelay= $("<td>"+(data.taskStartTimeDelay==null?'':data.taskStartTimeDelay)+"</td>").appendTo(tr);
                    var tinterval=$("<td>"+(data.nextTaskStartTimeInterval==null?'':data.nextTaskStartTimeInterval)+"</td>").appendTo(tr);

                    /**
                     * 采集类型：
                     1 站点采集
                     2 按地区采集

                     */
                    var ctyp= data.collType;
                    var ctext=""
                    if(ctyp==1){
                        ctext='按站点采集';
                    }else if(ctyp==2){
                        ctext='按地区采集';
                    }
                    var colltype= $("<td value ='"+ctyp+"'>"+ctext+"</td>").appendTo(tr);

                    var irun= data.isRun;
                    var runtext ="否";
                    if(irun ==0){
                        runtext='否'
                    }else {
                        runtext='是';
                    }
                    var isrun = $("<td value ='"+irun+"'>"+runtext+"</td>").appendTo(tr);

                    var itry= data.isRetry;
                    var rtrytext ="否";
                    if(1==itry){
                        rtrytext='是';
                    }
                   var isTry=  $("<td value ='"+itry+"'>"+rtrytext+"</td>").appendTo(tr);
                    var retry=  $("<td >"+(data.retryTimes==null?'':data.retryTimes)+"</td>").appendTo(tr);
                    var retryint=  $("<td >"+(data.retryInterval==null?'':data.retryInterval)+"</td>").appendTo(tr);
                    var dt = data.dataType;
                    var dttext = "";
                    /**
                     * 数据类型：
                     1 分钟数据
                     2 小时数据
                     3 日数据
                     */
                    if(1==dt){
                        dttext="分钟数据";
                    }else if(2==dt){
                        dttext="小时数据";
                    }else if(3==dt){
                        dttext="日数据";
                    }
                    $("<td value ='"+dt+"' >"+dttext+"</td>").appendTo(tr);
                    $("<td value ='"+dt+"' >"+(data.areacodes==null?'':data.areacodes)+"</td>").appendTo(tr);
                    $("<td value ='"+dt+"' >"+(data.stationTypes==null?'':data.stationTypes)+"</td>").appendTo(tr);

                    $( "<td> <a class='edit' href='javascript:;'> Edit </a> </td> <td> <a class='delete' href='javascript:;'> Delete </a> </td>").appendTo(tr);


                }
            }

        }
    });


})