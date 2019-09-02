package com.mir00r.userportal

import user.portal.Member


class AppInitializationService {

    static initialize() {
        initMember()
    }

    private static initMember() {
        if (Member.count() == 0) {
            Member member = new Member()
            member.firstName = "System"
            member.lastName = "Admin"
            member.email = "admin@localhost.local"
            member.password = "admin"
            member.address = "Badda"
            member.phoneNumber = "0139393939"
            member.memberType = GlobalConfig.USER_TYPE.ADMIN
            member.save(flash: true)
        }
    }
}
