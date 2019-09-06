package user.portal

import com.mir00r.userportal.GlobalConfig

class User {

    Integer id
    String firstName
    String lastName
    String password
    String address
    String phoneNumber
    String email
    Integer age
    String userType = GlobalConfig.USER_TYPE.USER
    Boolean isActive = true
    Date birthDate

    Date dateCreated
    Date lastUpdated

    static constraints = {
        email(email: true, nullable: false, unique: true, blank: false)
        password(blank: false)
        lastName(nullable: true)
        address(nullable: true)
        phoneNumber(nullable: false)
        age(nullable: true)
    }

    def beforeInsert() {
        this.password = this.password.encodeAsMD5()
    }


    def beforeUpdate() {
        this.password = this.password.encodeAsMD5()
    }
}
