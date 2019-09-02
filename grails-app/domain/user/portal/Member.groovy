package user.portal

import com.mir00r.userportal.GlobalConfig

class Member {

    Integer id
    String firstName
    String lastName
    String password
    String email
    String address
    String phoneNumber
    Integer age
    String memberType = GlobalConfig.USER_TYPE.USER
    Boolean isActive = true

    Date birthDate
    Date dateCreated
    Date lastUpdated

    static constraints = {
        email(email: true, nullable: false, unique: true, blank: false)
        password(blank: false)
        firstName(nullable: false)
        lastName(nullable: true)
    }

    def beforeInsert() {
        this.password = this.password.encodeAsMD5()
    }


    def beforeUpdate() {
        this.password = this.password.encodeAsMD5()
    }
}
