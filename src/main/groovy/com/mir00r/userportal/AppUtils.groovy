package com.mir00r.userportal

import org.grails.web.util.WebUtils

/**
 * @project IntelliJ IDEA
 * @author mir00r on 2019-09-01
 */
class AppUtils {
    /**
     * save the success status of respective model
     * @param isSuccess
     * @param model
     * @return
     */
    static saveResponse(Boolean isSuccess, def model) {
        return [isSuccess: isSuccess, model: model]
    }

    /**
     * get the latest user session to check authorization
     * @return
     */
    static getAppSession() {
        return WebUtils.retrieveGrailsWebRequest().session
    }

    /**
     * to show flash message after user interaction
     * @param message
     * @param status
     * @return
     */
    static infoMessage(String message, boolean status = true) {
        return [info: message, success: status]
    }

    /**
     * get the project base URL context path
     * @return
     */
    static String baseURL() {
        return "${getAppSession().getServletContext().getContextPath()}/"
    }

    /**
     * save error message with different id so that we can invoke the error message depends on errorId
     * @param errorId
     * @param message
     * @return
     */
    static saveErrorMessage(Integer errorId, String message) {
        return [errorId: errorId, errorMessage: message]
    }

    /**
     * Calculate user age between two DATE object
     * @param birthday
     * @param offset
     * @return
     */
    static Integer getAge(Date birthday, Date offset) {
        def birthdayThisYear = offset.clone().clearTime()
        birthdayThisYear[Calendar.MONTH] = birthday[Calendar.MONTH]
        birthdayThisYear[Calendar.DATE] = birthday[Calendar.DATE]

        offset[Calendar.YEAR] - birthday[Calendar.YEAR] - (birthdayThisYear > offset ? 1 : 0)
    }
}
