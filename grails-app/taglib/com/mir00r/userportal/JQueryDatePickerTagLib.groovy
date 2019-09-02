package com.mir00r.userportal

class JQueryDatePickerTagLib {
    def jqDatePicker = {attrs, body ->
        def out = out
        def name = attrs.name    //The name attribute is required for the tag to work seamlessly with grails
        def id = attrs.id ?: name
        def minDate = attrs.minDate
        def showDay = attrs.showDay
        def val = attrs.value ?: ''

        //Create date text field and supporting hidden text fields need by grails
        out.println "<input type=\"text\" name=\"${name}\" id=\"${id}\" value=\"${val}\" class=\"datepicker input-small\"/>"
        out.println "<input type=\"hidden\" name=\"${name}_day\" id=\"${id}_day\" />"
        out.println "<input type=\"hidden\" name=\"${name}_month\" id=\"${id}_month\" />"
        out.println "<input type=\"hidden\" name=\"${name}_year\" id=\"${id}_year\" />"

        //Code to parse selected date into hidden fields required by grails
        out.println "<script type=\"text/javascript\"> \$(document).ready(function(){"
        out.println "\$(\"input[name='${name}']\").datepicker({"
        out.println "onClose: function(dateText, inst) {"
        out.println "\$(\"input[name='${name}']\").attr(\"value\",dateText);"
        out.println "\$(\"input[name='${name}_month']\").attr(\"value\",new Date(dateText).getMonth() +1);"
        out.println "\$(\"input[name='${name}_day']\").attr(\"value\",new Date(dateText).getDate());"
        out.println "\$(\"input[name='${name}_year']\").attr(\"value\",new Date(dateText).getFullYear());"
        out.println "}"

        //If you want to customize using the jQuery UI events add an if block an attribute as follows
        if(minDate != null){
            out.println ","
            out.println "minDate: ${minDate}"
        }

        if(showDay != null){
            out.println ","
            out.println "beforeShowDay: function(date){"
            out.println "var day = date.getDay();"
            out.println "return [day == ${showDay},\"\"];"
            out.println "}"
        }

        out.println "});"

        if (val != '') {
            out.println("\n")
            out.println "\$(\"input[name='${name}_month']\").attr(\"value\",new Date('${val}').getMonth() +1);"
            out.println "\$(\"input[name='${name}_day']\").attr(\"value\",new Date('${val}').getDate());"
            out.println "\$(\"input[name='${name}_year']\").attr(\"value\",new Date('${val}').getFullYear());"
        }

        out.println "})</script>"

    }

    /*static defaultEncodeAs = [taglib:'html']
    static encodeAsForTags = [jqDatePicker: 'raw']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def jqDatePicker = {attrs, body ->
        def out = out
        def name = attrs.name //The name attribute is required for the tag to work seamlessly with grails
        def id = attrs.id ?: name
        def value = attrs.value
        def displayFormat = attrs.displayFormat
        def datepickerFormat = attrs.datepickerFormat

        //def displayFormatString = displayFormat ? displayFormat : "MM.dd.yyyy"
        def datepickerFormatString = datepickerFormat ? datepickerFormat : "dd.mm.yy"
        def dateString = value ? value.format("dd.MM.yyyy") : ""
        def dayString = value ? value.format('dd') : ""
        def monthString = value ? value.format('MM') : ""
        def yearString = value ? value.format('yyyy') : ""

        //Create date text field and supporting hidden text fields need by grails
        out.println "<input type=\"text\" name=\"${name}_dp\" id=\"${id}_dp\" value=\"${dateString}\" "
        out.println " class=\"form-control datepicker\" data-dateformat=\"${datepickerFormatString}\" "
        if (attrs.placeholder != null) {
            out.println "placeholder=\"${attrs.placeholder}\" "
        }
        if (attrs.disabled != null) {
            out.println "disabled=\"${attrs.disabled}\" "
        }
        out.println " onchange=\"${name}_dp_droesel();\" "
        out.println "/>"
        out.println "<input type=\"hidden\" name=\"${name}\" id=\"${id}\" value=\"date.struct\" />"
        out.println "<input type=\"hidden\" name=\"${name}_day\" id=\"${id}_day\" value=\"${dayString}\" />"
        out.println "<input type=\"hidden\" name=\"${name}_month\" id=\"${id}_month\" value=\"${monthString}\" />"
        out.println "<input type=\"hidden\" name=\"${name}_year\" id=\"${id}_year\" value=\"${yearString}\" />"

        //Code to parse selected date into hidden fields required by grails
        out.println "<script type=\"text/javascript\">"
        out.println "function ${name}_dp_droesel() {"
        out.println "    if (\$(\"#${id}_dp\").val().length > 0) {"
        out.println "        try {"
        out.println "            var selDate = \$.datepicker.parseDate('${datepickerFormatString}', \$(\"#${name}_dp\").val());"
        out.println "            \$(\"#${name}_month\").attr(\"value\",selDate.getMonth() +1);"
        out.println "            \$(\"#${name}_day\").attr(\"value\",selDate.getDate());"
        out.println "            \$(\"#${name}_year\").attr(\"value\",selDate.getFullYear());"
        out.println "            \$(\"#${id}_dp\").css({'color': ''});"
        out.println "        } catch(e) {"
        out.println "            \$(\"#${id}_dp\").css({'color': '#FF0000'});"
        out.println "            \$(\"#${id}_dp\").focus();"
        out.println "            alert(e);"
        out.println "        }"
        out.println "    } else {"
        out.println "        \$(\"#${id}_dp\").css({'color': ''});"
        out.println "        \$(\"#${name}_month\").attr(\"value\",\"\");"
        out.println "        \$(\"#${name}_day\").attr(\"value\",\"\");"
        out.println "        \$(\"#${name}_year\").attr(\"value\",\"\");"
        out.println "    }"
        out.println "}"
        out.println "</script>"

    }*/
}
