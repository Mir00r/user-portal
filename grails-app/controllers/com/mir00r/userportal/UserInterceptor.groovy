package com.mir00r.userportal


class UserInterceptor {

    AuthenticationService authenticationService

    boolean before() {
        if (authenticationService.isAdminUser()) {
            return true
        }
        flash.message = AppUtils.infoMessage("You are not Authorized for this Action.", false)
        redirect(controller: "user", action: "index")
        return false
    }
}
