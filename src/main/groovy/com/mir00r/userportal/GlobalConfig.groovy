package com.mir00r.userportal

/**
 * @project IntelliJ IDEA
 * @author mir00r on 2019-09-01
 */
class GlobalConfig {
    public static final def USER_TYPE = [
            ADMIN: "ADMIN",
            USER : "USER",
    ]

    public static Integer itemsPerPage() {
        return 10
    }
}
