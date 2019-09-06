<%--
  Created by IntelliJ IDEA.
  User: mir00r
  Date: 2019-09-06
  Time: 02:54
--%>

<!doctype html>
<html lang="en" class="no-js">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>

    <script type="text/javascript">
        USERPORTAL.baseURL = "${UIHelper.appBaseURL()}";
        <g:if test="${flash?.message && flash?.message?.info}">
        jQuery(document).ready(function () {
            USERPORTAL.messageBox.showMessage(Boolean(${flash.message?.success}), "${flash.message?.info}");
        });
        </g:if>
    </script>
    <g:layoutHead/>
</head>

<body>

<div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
        <div class="sidebar-heading">User Portal</div>

        <div class="list-group list-group-flush">
            <UIHelper:leftNavigation/>
        </div>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
            <button class="btn btn-light" id="menu-toggle"><span class="navbar-toggler-icon"></span></button>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                    <UIHelper:userActionMenu/>
                </ul>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="mt-4">
                <g:layoutBody/>
            </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Menu Toggle Script -->
<script>
    $("#menu-toggle").click(function (e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>

</body>

</html>