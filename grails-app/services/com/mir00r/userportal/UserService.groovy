package com.mir00r.userportal

import grails.web.servlet.mvc.GrailsParameterMap
import user.portal.User


class UserService {

    /**
     * Save user information to user domain model
     * @param params
     * @return
     */
    def save(GrailsParameterMap params) {
        User user = new User(params)
        def response = AppUtils.saveResponse(false, user)
        if (user.validate()) {
            user.save(flush: true)
            if (!user.hasErrors()) {
                response.isSuccess = true
            }
        }
        return response
    }

    /**
     * Update user information and save it respective domain model
     * @param user
     * @param params
     * @return
     */
    def update(User user, GrailsParameterMap params) {
        user.properties = params
        def response = AppUtils.saveResponse(false, user)
        if (user.validate()) {
            user.save(flush: true)
            if (!user.hasErrors()) {
                response.isSuccess = true
            }
        }
        return response
    }

    /**
     * get user model through Id
     * @param id
     * @return
     */
    def getById(Serializable id) {
        return User.get(id)
    }

    /**
     * get user list ordered by id
     * @param params
     * @return
     */
    def list(GrailsParameterMap params) {
        params.max = params.max ?: GlobalConfig.itemsPerPage()
        List<User> userList = User.createCriteria().list(params) {
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
            eq("userType", GlobalConfig.USER_TYPE.USER)
        }
        return [list: userList, count: userList.totalCount]
    }

    /**
     * Delete the user from db
     * @param user
     * @return
     */
    def delete(User user) {
        try {
            user.delete(flush: true)
        } catch (Exception e) {
            println(e.getMessage())
            return false
        }
        return true
    }
}
