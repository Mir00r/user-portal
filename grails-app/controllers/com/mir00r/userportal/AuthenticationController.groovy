package com.mir00r.userportal

import grails.converters.JSON

class AuthenticationController {

    AuthenticationService authenticationService
    UserService userService

    /**
     * Redirect the dashboard index page after login authentication
     * @return
     */
    def login() {
        if (authenticationService.isAuthenticated()) {
            redirect(controller: "dashboard", action: "index")
        }
    }

    /**
     * If entered email and password is valid then redirect the
     * dashboard page otherwise it's shows the validation flash message to the user
     * @return
     */
    def doLogin() {
        if (authenticationService.doLogin(params.email, params.password)) {
            if (authenticationService.isAdminUser()) {
                redirect(controller: "user", action: "index")
            } else {
                redirect(controller: "profile", action: "details", id: authenticationService.getLoginUserId())
            }
        } else {
            flash.message = AppUtils.infoMessage("Email or password is not valid.", false)
            redirect(controller: "authentication", action: "login")
        }
    }

    /**
     * invalidate the user session after logout and redirect to login page
     * @return
     */
    def logout() {
        session.invalidate()
        redirect(controller: "authentication", action: "login")
    }

    def registration() {
        [user: flash.redirectParams]
    }

    /**
     * Save new user registration data
     * @return
     */
    def doRegistration() {
        def response = userService.save(params)
        if (response.isSuccess) {
            authenticationService.setUserAuthorization(response.model)
            redirect(controller: "profile", action: "details", id: response.model.getAt("id"))
        } else {
            flash.redirectParams = response.model
            redirect(controller: "authentication", action: "registration")
        }
    }

    def checkEmailAvailable = {
        def available = [:]
        if(userService.getUserByEmail(params.emailId)) {
            available["msg"] = true
        } else {
            available["msg"] = false
        }
        render available as JSON
    }
}
