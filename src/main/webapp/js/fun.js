function destroyUser() {
    var row = $('#dg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('Confirm', 'Are you sure you want to destroy this book?', function(r) {
            if (r) {
                $.post('Delete', {
                	  //传递选中的行中指定列，注意名字和field相同！
                    id : row.Id
                }, function(result) {
                    if (result.success) {
                    	window.location.href ="index.jsp";
                    	 $('#dg').datagrid('reload');
                    	  // reload the user data
                    } else {
                        $.messager.show({ // show error message
                            title : 'Error',
                            msg : result.errorMsg
                        });
                    }
                }, 'json');
            }
        });
    }
}


function saveUser() {
	 $('#dlg').dialog('close');
    $('#fm').form('submit', {
    	 
    	//注意这里使用了url而不指明哪个 Servlet，使得 New 里边的save 和 Edit 里边的 save 通用！！！ 
        url : url,
        onSubmit : function() {
            return $(this).form('validate');
        },
        success : function(result) {
            var result = eval('(' + result + ')');
            
            if (result.errorMsg) {
                $.messager.show({
                    title : 'Error',
                    msg : result.errorMsg
                });
            } else {
            	
                $('#dlg').dialog('close'); // close the dialog
                $('#dg').datagrid('reload'); // reload the user data
            }
        }
    });
}

function newUser() {
    $('#dlg').dialog('open').dialog('setTitle', 'New Book');
    $('#fm').form('clear');
    url = "Save";
}

function editUser() {
    var row = $('#dg').datagrid('getSelected');
    if (row) {
        $('#dlg').dialog('open').dialog('setTitle', 'Edit Book');
        $('#fm').form('load', row);
        //参数在这里传进去，后面的 save 就不传了！
        url = 'Edit?Id=' + row.Id;
    }
}

$('#dg').datagrid({
    columns : [ [ //添加列  
        {
            field : 'Id', //绑定数据源ID  
            title : 'Id', //显示列名称
            align : 'center', //内容在列居中
            width : 100 //列的宽度
        },
        {
            field : 'Name',
            title : '书名',
            align : 'center',
            width : 100
        },
        {
            field : 'Author',
            title : '作者',
            align : 'center',
            width : 100
        },
        {
            field : 'Price',
            title : '价格',
            align : 'center',
            width : 100
        },
        {
            field : 'Date',
            title : '发布日期',
            align : 'center',
            width : 100
        },
    ] ],
    pagination : true, //开启分页
    url : 'DB', //获取数据地址
    loadFilter : pagerFilter, //①调用分页函数
});

//②构造分页函数，万能的Tools函数! 
//分页数据的操作 :
function pagerFilter(data) {
    if (typeof data.length == 'number' && typeof data.splice == 'function') { // is array  
        data = {
            total : data.length,
            rows : data
        }
    }
    var dg = $(this);
    var opts = dg.datagrid('options');
    var pager = dg.datagrid('getPager');
    pager.pagination({
        onSelectPage : function(pageNum, pageSize) {
            opts.pageNumber = pageNum;
            opts.pageSize = pageSize;
            pager.pagination('refresh', {
                pageNumber : pageNum,
                pageSize : pageSize
            });
            dg.datagrid('loadData', data);
        }
    });
    if (!data.originalRows) {
        data.originalRows = (data.rows);
    }
    var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
    var end = start + parseInt(opts.pageSize);
    data.rows = (data.originalRows.slice(start, end));
    return data;
}