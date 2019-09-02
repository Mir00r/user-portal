<%--
  Created by IntelliJ IDEA.
  User: mir00r
  Date: 2019-09-02
  Time: 23:22
--%>

<meta name="layout" content="public"/>

<div id="global-wrapper">
    <div id="content-wrapper">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <g:img dir="images" file="user.svg" class="profile-img"/>
                    <h1 class="text-center login-title">Registration Panel</h1>

                    <div class="card">
                        <div class="card-body">
                            <g:form controller="authentication" action="doRegistration" class="">
                                <div class="form-group row">
                                    <label class="col-md-4 col-form-label text-md-right"><g:message
                                            code="first.name"/></label>

                                    <div class="col-md-6">
                                        <g:textField name="firstName" class="form-control" required="required"/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-md-4 col-form-label text-md-right"><g:message
                                            code="last.name"/></label>

                                    <div class="col-md-6">
                                        <g:textField name="lastName" class="form-control" required="required"/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-md-4 col-form-label text-md-right"><g:message
                                            code="address"/></label>

                                    <div class="col-md-6">
                                        <g:textField name="address" class="form-control" required="required"/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-md-4 col-form-label text-md-right"><g:message
                                            code="phone.number"/></label>

                                    <div class="col-md-6">
                                        <g:textField name="phoneNumber" class="form-control" required="required"/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-md-4 col-form-label text-md-right"><g:message
                                            code="email"/></label>

                                    <div class="col-md-6">
                                        <g:textField name="email" class="form-control" required="required"/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-md-4 col-form-label text-md-right"><g:message
                                            code="birth.date"/></label>

                                    <div class="col-md-6">
                                        %{--                                        <g:jqDatePicker name="birthDate" precision="day" value="${user?.birthDate}"--}%
                                        %{--                                                        required="required"/>--}%
                                        <g:datePicker relativeYears="[-7..7]" id="fechaEstimadaInicio"
                                                      name="birthDate" precision="day"
                                                      value="${user?.birthDate}"/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-md-4 col-form-label text-md-right"><g:message
                                            code="password"/></label>

                                    <div class="col-md-6">
                                        <g:passwordField name="password" class="form-control"
                                                         required="required"/>
                                    </div>

                                </div>

                                <div class="col-md-6 offset-md-4">
                                    <g:submitButton name="registration" value="Registration"
                                                    class="btn btn-primary"/>
                                    <g:link controller="authentication" action="login"
                                            class="btn btn-primary"><g:message
                                            code="cancel"/></g:link>

                                </div>

                            </g:form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
