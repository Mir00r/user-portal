package com.mir00r.userportal

class AuthenticationController {

    AuthenticationService authenticationService
    MemberService memberService
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
            redirect(controller: "dashboard", action: "index")
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
        def response = memberService.save(params)
        if (response.isSuccess) {
            authenticationService.setMemberAuthorization(response.model)
            redirect(controller: "dashboard", action: "index")
        } else {
            flash.redirectParams = response.model
            redirect(controller: "authentication", action: "registration")
        }
    }
}
