<html>
<head>
	<title>List</title>
</head>
<body>
<h1> 
	Tasks list for user: ${user} and Profile: ${profile}
</h1>
<style type="text/css">
table.sample {
	border-width: medium;
	border-spacing: 2px;
	border-style: outset;
	border-color: black;
	border-collapse: collapse;
	background-color: white;
}
table.sample th {
	border-width: 1px;
	padding: 4px;
	border-style: solid;
	border-color: red;
	background-color: white;
	-moz-border-radius: 0px 0px 0px 0px;
}
table.sample td {
	border-width: 1px;
	padding: 4px;
	border-style: solid;
	border-color: red;
	background-color: white;
	-moz-border-radius: 0px 0px 0px 0px;
}
</style>
<table class="sample">
	<tr>
		<#list headers as headerValue>
			<td><b>${headerValue}</b></td>
		</#list>
	</tr>
	
	<#list data as row>
		<tr>
			<#assign i=0>
			<#list row as cell>
				<#if i == idIndex>
					<td><a href="/human-task-web-ui-example/task/${user}/${profile}/${cell}/${taskNames[cell]}">${cell}</a></td>
				<#else>
					<td>${cell}</td>
				</#if>
				<#assign i=i+1>
			</#list>
		</tr>
	</#list>
</table>
<a href="../../new/">New List</a>
</body>
</html>
