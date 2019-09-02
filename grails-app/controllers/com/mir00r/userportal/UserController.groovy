package com.mir00r.userportal

class UserController {

    UserService userService

    def index() {
        def response = userService.list(params)
        [userList: response.list, total: response.count]
    }

    /**
     * get user details view page
     * @param id
     * @return
     */
    def details(Integer id) {
        def response = userService.getById(id)
        if (!response) {
            redirect(controller: "user", action: "index")
        } else {
            [user: response]
        }
    }

    def create() {
        [user: flash.redirectParams]
    }

    /**
     * save the user information
     * @return
     */
    def save() {
        def response = userService.save(params)
        if (!response.isSuccess) {
            flash.redirectParams = response.model
            flash.message = AppUtils.infoMessage(g.message(code: "unable.to.save"), false)
            redirect(controller: "user", action: "create")
        } else {
            flash.message = AppUtils.infoMessage(g.message(code: "saved"))
            redirect(controller: "user", action: "index")
        }
    }

    /**
     * return edit view page when the user update method called
     * @param id
     * @return
     */
    def edit(Integer id) {
        if (flash.redirectParams) {
            [user: flash.redirectParams]
        } else {
            def response = userService.getById(id)
            if (!response) {
                flash.message = AppUtils.infoMessage(g.message(code: "invalid.entity"), false)
                redirect(controller: "user", action: "index")
            } else {
                [user: response]
            }
        }
    }

    /**
     * get the user information edit view page through respective user id
     * @return
     */
    def update() {
        def response = userService.getById(params.id)
        if (!response) {
            flash.message = AppUtils.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "user", action: "index")
        } else {
            response = userService.update(response, params)
            if (!response.isSuccess) {
                flash.redirectParams = response.model
                flash.message = AppUtils.infoMessage(g.message(code: "unable.to.update"), false)
                redirect(controller: "user", action: "edit")
            } else {
                flash.message = AppUtils.infoMessage(g.message(code: "updated"))
                redirect(controller: "user", action: "index")
            }
        }
    }

    /**
     * Delete the user through respective user id
     * @param id
     * @return
     */
    def delete(Integer id) {
        def response = userService.getById(id)
        if (!response) {
            flash.message = AppUtils.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "user", action: "index")
        } else {
            response = userService.delete(response)
            if (!response) {
                flash.message = AppUtils.infoMessage(g.message(code: "unable.to.delete"), false)
            } else {
                flash.message = AppUtils.infoMessage(g.message(code: "deleted"))
            }
            redirect(controller: "user", action: "index")
        }
    }
}
