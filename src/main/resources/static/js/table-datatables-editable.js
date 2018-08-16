var TableDatatablesEditable = function () {

    var handleTable = function () {

        function restoreRow(oldRow, nRow) {
            // var aData = oTable.fnGetData(nRow);
            // var jqTds = $('>td', nRow);
            //
            // for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
            //     oTable.fnUpdate(aData[i], nRow, i, false);
            // }
            //
            // oTable.fnDraw();
           //resetRow(nRow)
            location.reload();
        }

        function editRow(oTable, nRow) {
            var aData = oTable.fnGetData(nRow);

            var jqTds = $('>td', nRow);
            var childed = $(nRow).children();

            for(var i=1;i<=13;i++){
                var childtext = childed[i].innerHTML;
                if(i==6){
                    var value = $(childed[i]).attr("value");
                    if(value ==1){
                        childed[i].innerHTML ="<select ><option value=''>请选择</option><option value='1' selected>按站点采集</option><option value='2'>按地区采集</option></select>"
                    }else if(value ==2){
                        childed[i].innerHTML ="<select ><option value=''>请选择</option><option value='1' >按站点采集</option><option value='2' selected>按地区采集</option></select>"
                    }else{
                        childed[i].innerHTML ="<select ><option value=''>请选择</option><option value='1' >按站点采集</option><option value='2'>按地区采集</option></select>"
                    }

                }else if(i==7){
                    var value = $(childed[i]).attr("value");
                    if(value ==0){
                        childed[i].innerHTML ="<select><option value='0' selected>否</option><option value='1'>是</option></select>"
                    }else if(value ==1){
                        childed[i].innerHTML ="<select ><option value='0'>否</option><option value='1' selected>是</option></select>"
                    }
                }else if(i==8){
                    var value = $(childed[i]).attr("value");
                    if(value ==0){
                        childed[i].innerHTML ="<select ><option value='0' selected>否</option><option value='1'>是</option></select>"
                    }else {
                        childed[i].innerHTML ="<select ><option value='0'>否</option><option value='1' selected>是</option></select>"
                    }
                }else  if(i==11){
                    var value = $(childed[i]).attr("value");
                    if(value ==1){
                        childed[i].innerHTML ="<select ><option value=''>请选择</option><option value='1' selected>分钟数据</option><option value='2'>小时数据</option><option value='3'>日数据</option></select>"
                    }else if(value ==2){
                        childed[i].innerHTML ="<select ><option value=''>请选择</option><option value='1' >分钟数据</option><option value='2'selected>小时数据</option><option value='3'>日数据</option></select>"
                    }else if(value ==3){
                        childed[i].innerHTML ="<select ><option value=''>请选择</option><option value='1' >分钟数据</option><option value='2'>小时数据</option><option value='3' selected>日数据</option></select>"
                    }else{
                        childed[i].innerHTML ="<select ><option value=''>请选择</option><option value='1' >分钟数据</option><option value='2'>小时数据</option><option value='3'>日数据</option></select>"
                    }
                } else{
                    childed[i].innerHTML="<input type='text' class='form-control input-small' value='" + childtext + "'>";
                }


            }

            childed[14].innerHTML = '<a class="edit" href="">Save</a>';
            childed[15].innerHTML = '<a class="cancel" href="">Cancel</a>';
        }

        function saveRow(oTable, nRow) {
            var param = getRowData(nRow);
            //校验任务参数
            if(param.dataTime==null || param.dataType=='' || param.dataType==undefined){
                alert("请填写数据采集时间");
                return ;
            }
            if(param.dataInterval==null || param.dataInterval=='' || param.dataInterval==undefined){
                alert("请填写数据采集时间间隔");
                return ;
            }
            if(param.taskTime==null || param.taskTime=='' || param.taskTime==undefined){
                alert("请填写任务执行时间");
                return ;
            }
            if(param.taskDelay==null || param.taskDelay=='' || param.taskDelay==undefined){
                alert("请填写任务执行延时时间");
                return ;
            }
            if(param.taskInterval==null || param.taskInterval=='' || param.taskInterval==undefined){
                alert("请填写任务执行间隔");
                return ;
            }
            if(param.collType==null || param.collType=='' || param.collType==undefined){
                alert("请选择采集类型");
                return ;
            }
            if(param.isRetry ==1){
               if(param.retryTimes ==null || param.retryTimes =='' || param.retryTimes ==undefined  || param.retryTimes<=0  ){
                   alert("请填写重试次数");
                   return;
               }
                if(param.retryInterval ==null || param.retryInterval =='' || param.retryInterval ==undefined  || param.retryInterval<=0  ){
                    alert("请填写重试间隔");
                    return;
                }
            }
            if(param.dataType ==null || param.dataType =='' || param.dataType==undefined){
                alert("请选择数据类型");
                return ;
            }
            if(param.collType==1){
                if(param.stations ==null || param.stations=='' || param.stations == undefined){
                    alert("请填写站点信息");
                    return ;
                }
            }else if(param.collType==2){
                if(param.areacodes ==null || param.areacodes =='' || param.areacodes==undefined){
                    alert("请填写采集区域编码");
                    return;
                }

            }
            //保存任务信息
            $.ajax({
                type: "post",
                url: "/saveTask",
                dataType: "json",
                data:param,
                success: function (result) {
                    location.reload();

                   //resetRow(nRow);
                }
            });






        }

        function cancelEditRow(oTable, nRow) {
            location.reload();
            //resetRow(nRow);
        }

        function resetRow(nRow){
            //$("<td>"+data.taskName+"</td>")
            var param = getRowData(nRow);
           var tds = $(nRow).children();
            tds[1].innerHTML=param.dataTime;
            tds[2].innerHTML=param.dataInterval;
            tds[3].innerHTML=param.taskTime;
            tds[4].innerHTML=param.taskDelay;
            tds[5].innerHTML=param.taskInterval;
            var ctxt="";
            if(param.collType==1){
                ctxt='按站点采集'
            }else if(param.collType==2){
                ctxt='按地区采集';
            }
            tds[6].innerHTML=ctxt;

            tds[7].innerHTML=param.isRun==0?'否':'是';
            tds[8].innerHTML=param.isRetry==0?'否':'是';
            tds[9].innerHTML=param.retryTimes;
            tds[10].innerHTML=param.retryInterval;
            var dtxt="";
            if(param.dataType==1){
                dtxt='分钟数据';
            }else if(param.dataType==2){
                dtxt='小时数据';
            }else if(param.dataType==3){
                dtxt='日数据';
            }
            tds[11].innerHTML=dtxt;
            tds[12].innerHTML=param.areacodes;
            tds[13].innerHTML=param.stations;
            tds[14].innerHTML = '<a class="edit" href="">Edit</a>';
            tds[15].innerHTML = '<a class="cancel" href="">Cancel</a>';



        }

        function getRowData(nRow){

            var children = $(nRow).children();
            var param={};

            var ftd = $(children[0]);
            var taskCode = ftd.attr("value");
            param.taskCode= taskCode;
            var dataTime = $(children[1]).children()[0].value;
            param.dataTime=dataTime;
            var dataInterval = $(children[2]).children()[0].value;
            param.dataInterval=dataInterval;
            var taskTime= $(children[3]).children()[0].value;
            param.taskTime=taskTime;
            var taskDelay=$(children[4]).children()[0].value;
            param.taskDelay=taskDelay;
            var taskInterval=$(children[5]).children()[0].value;
            param.taskInterval=taskInterval;
            var collType=$(children[6]).children()[0].value;
            param.collType=collType
            var isRun =$(children[7]).children()[0].value;
            param.isRun= isRun;
            var isRetry=$(children[8]).children()[0].value;
            param.isRetry=isRetry;
            var retryTimes= $(children[9]).children()[0].value;
            param.retryTimes=retryTimes;
            var retryInterval =$(children[10]).children()[0].value;
            param.retryInterval= retryInterval;
            var dataType=$(children[11]).children()[0].value;
            param.dataType =dataType
            var areacodes = $(children[12]).children()[0].value;
            param.areacodes = areacodes;
            var stations =$(children[13]).children()[0].value;
            param.stations=stations;
            return param;
        }

        var table = $('#sample_editable_1');

        var oTable = table.dataTable({


            "lengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "All"] // change per page values here
            ],



            "pageLength": 5,

            "language": {
                "lengthMenu": " _MENU_ records"
            },
            "columnDefs": [{ // set default column settings
                'orderable': false,

            }, {
                "searchable": false,
                "targets": [0]
            }]

        });


        var nEditing = null;
        var nNew = false;

        $('#sample_editable_1_new').click(function (e) {
            e.preventDefault();

            if (nNew && nEditing) {
                if (confirm("Previose row not saved. Do you want to save it ?")) {
                    saveRow(oTable, nEditing); // save
                    $(nEditing).find("td:first").html("Untitled");
                    nEditing = null;
                    nNew = false;

                } else {
                    oTable.fnDeleteRow(nEditing); // cancel
                    nEditing = null;
                    nNew = false;
                    
                    return;
                }
            }

            var aiNew = oTable.fnAddData(['', '', '', '', '', '']);
            var nRow = oTable.fnGetNodes(aiNew[0]);
            editRow(oTable, nRow);
            nEditing = nRow;
            nNew = true;
        });

        table.on('click', '.delete', function (e) {
            e.preventDefault();

            if (confirm("Are you sure to delete this row ?") == false) {
                return;
            }

            var nRow = $(this).parents('tr')[0];
            oTable.fnDeleteRow(nRow);
            alert("Deleted! Do not forget to do some ajax to sync with backend :)");
        });

        table.on('click', '.cancel', function (e) {
            e.preventDefault();
            var parent = $(this).parent().parent();
            restoreRow(oTable, parent);
            nEditing = null;

        });

        table.on('click', '.edit', function (e) {
            e.preventDefault();
            nNew = false;
            
            /* Get the row as a parent of the link that was clicked on */
            var nRow = $(this).parents('tr')[0];

            if (nEditing !== null && nEditing != nRow) {

                var parent = $(this).parent().parent();
                restoreRow(oTable, parent);
                editRow(oTable, nRow);
                nEditing = parent;
            } else if (nEditing == nRow && this.innerHTML == "Save") {

                var parent = $(this).parent().parent();
                saveRow(oTable, parent);
                nEditing = null;

            }
            else {
                /* No edit in progress - let's start one */
                editRow(oTable, nRow);
                nEditing = nRow;
            }
        });
    }

    return {

        //main function to initiate the module
        init: function () {
            handleTable();
        }

    };

}();

jQuery(document).ready(function() {
    TableDatatablesEditable.init();
});