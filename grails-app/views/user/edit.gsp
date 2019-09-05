<%--
  Created by IntelliJ IDEA.
  User: mir00r
  Date: 2019-09-04
  Time: 00:38
--%>

%{--Include Main Layout--}%
<meta name="layout" content="main"/>
<title><g:message code="user" args="['Edit']"/></title>

<div class="card">
    <div class="card-header">
        <g:message code="user" args="['Update']"/>
    </div>

    <div class="card-body">
        <g:form controller="member" action="update">
            <g:hiddenField name="id" value="${user.id}"/>
            <g:render template="form" model="[edit: 'yes']"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="update" value="${g.message(code: "update")}"/>
                <g:link controller="user" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>