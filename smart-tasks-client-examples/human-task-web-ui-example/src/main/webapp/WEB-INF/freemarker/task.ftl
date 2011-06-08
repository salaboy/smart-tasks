<head>
	<title>Task</title>
	
	
		<script type="text/javascript">
		var mymap = new Array();
		
		function init() {
		<#list operations.getOperationsList() as operation>
			document.getElementById('button_${operation}').disabled = true;
		</#list>
		<#list operations.getOperations(taskInput['Status']) as operation>
			document.getElementById('button_${operation}').disabled = false;
		</#list>
		}
		
		function buttonClicked(element)
		{
			var doc = document.getElementById('input_Output');
			if (doc == null) {
				doc = document.getElementById('input_Translation');
				if (doc == null) {
					doc = document.getElementById('input_Review');
				}
			}
			var url = "/human-task-web-ui-example/task/execute/${user}/${profile}/${id}/${name}/" + element.split("_")[1] + "/" + doc.value;
			window.location = url;
		}
	
	</script>
	
</head>
<body onLoad="init()">
<h1> 
	<#assign idv="id"/>
	Task details for task ${id}.
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
<div class="mydiv" id="statusid"/>
Details:
<table class="sample">
	<tr>
		<#list taskInput?keys as keys>
			<td><b>${keys}</b></td>
		</#list>
	</tr>
	<tr>	
		<#list taskInput?keys as keys>
					<#if taskInput[keys]?is_string>
						<#assign val = taskInput[keys]/> 
					<#else>
						<#if taskInput[keys]?is_hash>
							<#assign val = ''/>
							<#list taskInput[keys]?keys as ink>
								<#assign val = val + ' || ' + ink + '-' + taskInput[keys][ink]/>
							</#list>						
						</#if>		
					</#if>
			<td id='td_${keys}'><div id = 'div_${keys}'>${val}</div></td>
		</#list>
	</tr>
</table>
<br/>
Task Form:
 <FORM action="#" method="post">
    <P>
    <#list taskOutput?keys as inputKey>
     	<LABEL for="${inputKey}">${inputKey}: </LABEL>
        <INPUT type="text" id="input_${inputKey}" value="${taskOutput[inputKey]}"
        <#if taskInput['Status']!='IN_PROGRESS'> disabled=true</#if>
        /><br/>
    </#list>
    <#list operations.getOperationsList() as operation>
    	<INPUT type="button" id="button_${operation}" value=${operation} onClick="buttonClicked('button_${operation}')">
    </#list>
    </P>
 </FORM>
</table>
<a href="/human-task-web-ui-example/new/">New List</a>
</body>
</html>
