package com.mir00r.userportal

import grails.web.servlet.mvc.GrailsParameterMap
import user.portal.User


class ChangePasswordService {

    /**
     * Validate the change password form
     * @param user
     * @param params
     * @return
     */
    def updateUserPassword(User user, GrailsParameterMap params) {
        user.properties = params
        def response = AppUtils.saveResponse(false, user)

        String previousPassword = params.previousPassword
        String newPassword = params.newPassword
        String confirmPassword = params.confirmPassword

        if (user) {
            if (previousPassword.encodeAsMD5() == user.getPassword()) {
                if (newPassword != previousPassword) {
                    if (newPassword == confirmPassword) {
                        user.password = confirmPassword
                        user.save(flush: true)
                        response.isSuccess = true
                    } else {
                        response = AppUtils.saveErrorMessage(0, "New password did not match with confirm password")
                    }
                } else {
                    response = AppUtils.saveErrorMessage(1, "Previous password match with your new password")
                }
            } else {
                response = AppUtils.saveErrorMessage(2, "Wrong previous password please check")
            }
        }
        return response
    }
}
