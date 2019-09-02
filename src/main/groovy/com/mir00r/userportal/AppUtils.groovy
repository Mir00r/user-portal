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
}
