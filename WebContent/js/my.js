function loadSelect(typecode,positionId,selectname,selectedId){
		//创建select对象，将name属性指定
		var $select = $("<select name="+selectname+"></select>");
		//添加提示按钮
		$select.append($("<option value=''>---请选择---</select>"));
		//使用jquery的ajax方法，访问后台Action
		$.post("${pageContext.request.contextPath}/BaseDictAction",{dict_type_code:typecode},
				function(data){
					//json为data对象
					$.each(data,function(i,json){             
						var $option = $("<option value='"+json['dict_id']+"'>"+json['dict_item_name']+"</option>");
						if(json['dict_id'] == selectedId){
							//判断是否需要回显
							//设置optionde id与selected参数相等，则设置option的selected属性为选中
							$option.attr("selected","selected");
						}
						$select.append($option);
					});
		},"json");
		//将组装好的select对象放入页面指定位置
		$("#"+positionId).append($select);
	};