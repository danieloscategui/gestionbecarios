<table id="dg" title="My Users" class="easyui-datagrid" style="width:800px;height:455px"
	            url="employee/api/page"
	            method="get"
	            loadMsg="Procesando, espere por favor ..."
	            toolbar="#toolbar" pagination="true" pageSize="10"
	            rownumbers="true" fitColumns="true" singleSelect="true"
	            pagePosition="bottom"
	            border="false" fit="true">
    <thead>
        <tr>
            <th field="fullName" width="50">Full Name</th>
            <th field="email" width="50">Email</th>
            <th field="phoneNumber" width="50">Phone Number</th>
            <th field="hireDate" width="50">Hire Date</th>
        </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
  	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
  	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
</div>