<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index</title>


<link rel="stylesheet" href="${resource(dir: 'css/metro/crimson', file: 'jtable.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery-ui-1.10.3.custom.css')}" type="text/css">
<script src="${resource(dir: 'js', file: 'jquery-1.8.2.js')}" type="text/javascript"></script>
<script src="${resource(dir: 'js', file: 'jquery-ui-1.10.3.custom.js')}" type="text/javascript"></script>
<script src="${resource(dir: 'js', file: 'jquery.jtable.js')}" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#PersonTableContainer').jtable({
            title: 'Table of Airport',
            actions: {
                listAction: '${createLink(controller:'airport',action:'list')}',
                createAction:'${createLink(controller:'airport',action:'create')}',
                updateAction: '${createLink(controller:'airport',action:'update')}',
                deleteAction: '${createLink(controller:'airport',action:'delete')}'
            },
            fields: {
                id: {
                	
                    key: true,
                    list: false,
                    create:false
                },
                alternateAirport: {
                    title: 'Alternate Airport',
                    width: '30%',
                    edit:true
                },
                notes: {
                    title: 'notes',
                    width: '30%',
                    edit:true
                }            
            }
        });
        $('#PersonTableContainer').jtable('load');
    });
</script>


</head>
<body>
<div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">

<div id="PersonTableContainer"></div>
</div>
</body>
</html>
