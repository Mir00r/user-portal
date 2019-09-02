package com.mir00r.userportal

import user.portal.User

class AppInitializationService {

    static initialize() {
        initMember()
    }

    private static initMember() {
        if (User.count() == 0) {
            User user = new User()
            user.firstName = "System"
            user.lastName = "Admin"
            user.email = "admin@localhost.local"
            user.password = "admin"
            user.phoneNumber = "01733838838"
            user.address = "Middle badda"
            user.userType = GlobalConfig.USER_TYPE.ADMIN
            user.save(flash: true)
        }
    }
}
