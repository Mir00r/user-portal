package com.mir00r.userportal

class UIHelperTagLib {
    static namespace = "UIHelper"

    AuthenticationService authenticationService

    /**
     * render error message and show it to user for invalid input
     */
    def renderErrorMessage = { attrs, body ->
        def model = attrs.model
        String fieldName = attrs.fieldName
        String errorMessage = attrs.errorMessage ? g.message(code: attrs.errorMessage) : g.message(code: "invalid.input")
        if (model && model.errors && model.errors.getFieldError(fieldName)) {
            out << "<small class='form-text text-danger''><strong>${errorMessage}</strong></small>"
        }
    }

    /**
     * showing logged in member name and dropdown option to logout from the application
     */
    def userActionMenu = { attrs, body ->
        out << '<li class="nav-item dropdown show">'
        out << g.link(class: "nav-link dropdown-toggle", "data-toggle": "dropdown") {
            authenticationService.getUserName()
        }
        out << '<div class="dropdown-menu">'
        out << g.link(controller: "authentication", action: "logout", class: "dropdown-item") {
            g.message(code: "logout")
        }
        out << "</div></li>"
    }

    /**
     * showing navigation menu depends user type
     */
    def leftNavigation = { attrs, body ->
        /*List navigations = [
                [controller: "dashboard", action: "index", name: "dashboard"],
                [controller: "contactGroup", action: "index", name: "contact.group"],
                [controller: "contact", action: "index", name: "contact"],
        ]*/
        List navigations = []

        if (authenticationService.isAdminUser()) {
            navigations.add([controller: "user", action: "index", name: "user"])
        } else {
            navigations.add([controller: "user", action: "index", name: "profile.page"])
            navigations.add([controller: "user", action: "index", name: "change.password"])
        }

        navigations.each { menu ->
            out << '<li class="list-group-item">'
            out << g.link(controller: menu.controller, action: menu.action) { g.message(code: menu.name, args: ['']) }
            out << '</li>'
        }
    }

    /**
     * get application base URL
     */
    def appBaseURL = { attrs, body ->
        out << AppUtils.baseURL();
    }
}