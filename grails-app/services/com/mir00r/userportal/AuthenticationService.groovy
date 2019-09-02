package com.mir00r.userportal

import user.portal.User


class AuthenticationService {

    private static final String AUTHORIZED = "AUTHORIZED"

    /**
     * Set the logged in user authorization status from the session after login
     * @param user
     * @return
     */
    def setUserAuthorization(User user) {
        def authorization = [isLoggedIn: true, user: user]
        AppUtils.getAppSession()[AUTHORIZED] = authorization
    }

    /**
     * Login to the application through email and password and set the user authorization
     * @param email
     * @param password
     * @return
     */
    def doLogin(String email, String password) {
        password = password.encodeAsMD5()
        User user = User.findByEmailAndPassword(email, password)
        if (user) {
            setUserAuthorization(user)
            return true
        }
        return false
    }

    /**
     * Check the logged in user authorization status
     * @return
     */
    boolean isAuthenticated() {
        def authorization = AppUtils.getAppSession()[AUTHORIZED]
        if (authorization && authorization.isLoggedIn) {
            return true
        }
        return false
    }

    /**
     * get the logged in user
     * @return
     */
    def getUser() {
        def authorization = AppUtils.getAppSession()[AUTHORIZED]
        return authorization?.user
    }

    /**
     * get the full name of logged in user
     * @return
     */
    def getUserName() {
        def user = getUser()
        return "${user.firstName} ${user.lastName}"
    }

    /**
     * check the ADMIN user status
     * @return
     */
    def isAdminUser() {
        def user = getUser()
        if (user && user.userType == GlobalConfig.USER_TYPE.ADMIN) {
            return true
        }
        return false
    }
}
