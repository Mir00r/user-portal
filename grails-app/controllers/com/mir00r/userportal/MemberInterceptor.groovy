package com.mir00r.userportal


class MemberInterceptor {

    AuthenticationService authenticationService

    boolean before() {
        if (authenticationService.isAdminMember()) {
            return true
        }
        flash.message = AppUtils.infoMessage("You are not Authorized for this Action.", false)
        redirect(controller: "dashboard", action: "index")
        return false
    }
}
