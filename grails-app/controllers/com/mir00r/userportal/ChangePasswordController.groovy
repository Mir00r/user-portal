package com.mir00r.userportal

import user.portal.User

class ChangePasswordController {
    AuthenticationService authenticationService
    ChangePasswordService changePasswordService
    UserService userService

    def create() {
        [changePassword: flash.redirectParams]
    }

    def edit(Integer id) {
        if (flash.redirectParams) {
            [changePassword: flash.redirectParams]
        } else {
            def response = userService.getById(id)
            if (!response) {
                flash.message = AppUtils.infoMessage(g.message(code: "invalid.entity"), false)
                redirect(controller: "profile", action: "details", id: id)
            } else {
                [user: response]
            }
        }
    }

    def updatePassword() {
        def response = userService.getById(params.id)
        if (!response) {
            flash.message = AppUtils.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "changePassword", action: "edit", id: params.id)
        } else {
            response = changePasswordService.updateUserPassword(response, params)
            if (!response.isSuccess) {
                flash.message = AppUtils.infoMessage(response.errorMessage, false)
                redirect(controller: "changePassword", action: "edit", id: params.id)
            } else {
                flash.message = AppUtils.infoMessage(g.message(code: "updated"))
                redirect(controller: "authentication", action: "logout")
            }
        }
    }
}
