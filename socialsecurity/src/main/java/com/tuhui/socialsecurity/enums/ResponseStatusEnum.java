package com.tuhui.socialsecurity.enums;

public enum ResponseStatusEnum {
    RESULT_STATUS_100(100,"继续","请求者应当继续提出请求,服务器返回此代码表示已收到请求的第一部分，正在等待其余部分"),
    RESULT_STATUS_101(101,"切换协议","请求者已要求服务器切换协议，服务器已确认并准备切换"),

    RESULT_STATUS_200(200,"成功","服务器已成功处理了请求,通常这表示服务器提供了请求的网页"),
    RESULT_STATUS_201(201,"已创建","请求成功并且服务器创建了新的资源"),
    RESULT_STATUS_202(202,"已接受","服务器已接受请求，但尚未处理"),
    RESULT_STATUS_203(203,"非授权信息","服务器已成功处理了请求，但返回的信息可能来自另一来源"),
    RESULT_STATUS_204(204,"无内容","服务器成功处理了请求，但没有返回任何内容"),
    RESULT_STATUS_205(205,"重置内容","服务器成功处理了请求，但没有返回任何内容"),
    RESULT_STATUS_206(206,"部分内容","服务器成功处理了部分 GET 请求"),

    RESULT_STATUS_300(300,"多种选择","针对请求，服务器可执行多种操作,服务器可根据请求者 (user agent) 选择一项操作，或提供操作列表供请求者选择"),
    RESULT_STATUS_301(301,"永久移动","请求的网页已永久移动到新位置,服务器返回此响应(对 GET 或 HEAD 请求的响应时，会自动将请求者转到新位置" ),
    RESULT_STATUS_302(302,"临时移动","服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求"),
    RESULT_STATUS_303(303,"查看其他位置","请求者应当对不同的位置使用单独的 GET 请求来检索响应时，服务器返回此代码"),
    RESULT_STATUS_304(304,"未修改","自从上次请求后，请求的网页未修改过,服务器返回此响应时，不会返回网页内容"),
    RESULT_STATUS_305(305,"使用代理","请求者只能使用代理访问请求的网页,如果服务器返回此响应，还表示请求者应使用代理"),
    RESULT_STATUS_307(307,"临时重定向","服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求"),

    RESULT_STATUS_400(400,"错误请求","服务器不理解请求的语法"),
    RESULT_STATUS_401(401,"未授权","请求要求身份验证,对于需要登录的网页，服务器可能返回此响应"),
    RESULT_STATUS_403(403,"禁止","服务器拒绝请求"),
    RESULT_STATUS_404(404,"未找到","服务器找不到请求的网页"),
    RESULT_STATUS_405(405,"方法禁用","禁用请求中指定的方法"),
    RESULT_STATUS_406(406,"不接受","无法使用请求的内容特性响应请求的网页"),
    RESULT_STATUS_407(407,"需要代理授权","此状态代码与 401(未授权(类似，但指定请求者应当授权使用代理"),
    RESULT_STATUS_408(408,"请求超时","服务器等候请求时发生超时"),
    RESULT_STATUS_409(409,"冲突","服务器在完成请求时发生冲突,服务器必须在响应中包含有关冲突的信息"),
    RESULT_STATUS_410(410,"已删除","如果请求的资源已永久删除，服务器就会返回此响应"),
    RESULT_STATUS_411(411,"需要有效长度","服务器不接受不含有效内容长度标头字段的请求"),
    RESULT_STATUS_412(412,"未满足前提条件","服务器未满足请求者在请求中设置的其中一个前提条件"),
    RESULT_STATUS_413(413,"请求实体过大","服务器无法处理请求，因为请求实体过大，超出服务器的处理能力"),
    RESULT_STATUS_414(414,"请求的 URI 过长","请求的 URI(通常为网址(过长，服务器无法处理"),
    RESULT_STATUS_415(415,"不支持的媒体类型","请求的格式不受请求页面的支持"),
    RESULT_STATUS_416(416,"请求范围不符合要求","如果页面无法提供请求的范围，则服务器会返回此状态代码"),
    RESULT_STATUS_417(417,"未满足期望值","服务器未满足”期望”请求标头字段的要求"),

    RESULT_STATUS_500(500,"服务器内部错误","服务器遇到错误，无法完成请求"),
    RESULT_STATUS_501(501,"尚未实施","服务器不具备完成请求的功能,例如，服务器无法识别请求方法时可能会返回此代码"),
    RESULT_STATUS_502(502,"错误网关","服务器作为网关或代理，从上游服务器收到无效响应"),
    RESULT_STATUS_503(503,"服务不可用","服务器目前无法使用,由于超载或停机维护,通常，这只是暂时状态"),
    RESULT_STATUS_504(504,"网关超时","服务器作为网关或代理，但是没有及时从上游服务器收到请求"),
    RESULT_STATUS_505(505,"HTTP 版本不受支持","服务器不支持请求中所用的 HTTP 协议版本"),

    RESULT_STATUS_601(601,"用户名和密码不能为空！","用户名和密码不能为空！"),
    RESULT_STATUS_602(602,"此用户不存在！","此用户不存在！"),
    RESULT_STATUS_603(603,"用户密码不正确！","用户密码不正确！");

    private int code;
    private String desc;
    private String detailDesc;


    ResponseStatusEnum(int code, String desc, String detailDesc) {
        this.code = code;
        this.desc = desc;
        this.detailDesc = detailDesc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getDetailDesc() {
        return detailDesc;
    }
}
