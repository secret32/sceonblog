function rewriteUrl(pageObjectName, page) {
    var result;
    var url = window.location.href;
    var reqParams;
    var i = url.indexOf("?");
    if (pageObjectName && pageObjectName.length > 0) {
        pageObjectName += ".";
    } else {
        pageObjectName = "";
    }
    if (i != -1) {
        reqParams = url.substring(i + 1);
        result = url.substring(0, i + 1);
    } else {
        result = url;
    }
    if (reqParams) {
        var params = reqParams.split("&");
        var p = false;
        for (s in params) {
            if (s != 0) {
                result += "&";
            }
            if (params[s].indexOf(pageObjectName + "pageNo=") != -1) {
                result += (pageObjectName + "pageNo=" + page);
                p = true;
            } else {
                result += params[s];
            }
        }
        if (!p) {
            result += ("&" + pageObjectName + "pageNo=" + page);
        }
    } else {
        result += "?" + pageObjectName + "pageNo=" + page;
    }
    return result;
}