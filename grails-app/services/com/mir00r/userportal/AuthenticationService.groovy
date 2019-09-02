package com.mir00r.userportal

import user.portal.Member


class AuthenticationService {

    private static final String AUTHORIZED = "AUTHORIZED"

    def setMemberAuthorization(Member member) {
        def authorization = [isLoggedIn: true, member: member]
        AppUtils.getAppSession()[AUTHORIZED] = authorization
    }

    def doLogin(String email, String password) {
        password = password.encodeAsMD5()
        Member member = Member.findByEmailAndPassword(email, password)
        if (member) {
            setMemberAuthorization(member)
            return true
        }
        return false
    }

    boolean isAuthenticated() {
        def authorization = AppUtils.getAppSession()[AUTHORIZED]
        if (authorization && authorization.isLoggedIn) {
            return true
        }
        return false
    }

    def getMember() {
        def authorization = AppUtils.getAppSession()[AUTHORIZED]
        return authorization?.member
    }

    def getMemberName() {
        def member = getMember()
        return "${member.firstName} ${member.lastName}"
    }

    def isAdminMember() {
        def member = getMember()
        if (member && member.memberType == GlobalConfig.USER_TYPE.ADMIN) {
            return true
        }
        return false
    }
}
