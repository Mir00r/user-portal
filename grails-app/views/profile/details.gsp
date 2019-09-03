<%--
  Created by IntelliJ IDEA.
  User: mir00r
  Date: 2019-09-03
  Time: 12:23
--%>

%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header text-center page-title">
        <g:message code="user" args="['Profile']"/>
    </div>

    <div class="card-body">
        <g:if test="${user}">
            <table class="table">
                <tr>
                    <th class="text-right"><g:message code="first.name"/></th><td
                        class="text-left">${user.firstName}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="last.name"/></th><td
                        class="text-left">${user.lastName}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="email"/></th><td class="text-left">${user.email}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="user.type"/></th><td
                        class="text-left">${user.userType}</td>
                </tr>
            </table>
        </g:if>
    </div>
</div>