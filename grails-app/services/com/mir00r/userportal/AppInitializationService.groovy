package com.mir00r.userportal

import user.portal.User


class AppInitializationService {

    static initialize() {
        initUser()
    }

    private static initUser() {
        if (User.count() == 0) {
            User user = new User()
            user.firstName = "System"
            user.lastName = "Admin"
            user.email = "admin@localhost.local"
            user.password = "admin"
            user.phoneNumber = "01733838838"
            user.address = "Middle badda"
            user.birthDate = new Date()
            user.age = 0
            user.userType = GlobalConfig.USER_TYPE.ADMIN
            user.save(flash: true)
        }
    }
}
