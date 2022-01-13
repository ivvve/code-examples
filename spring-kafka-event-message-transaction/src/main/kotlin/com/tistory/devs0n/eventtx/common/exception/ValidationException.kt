package com.tistory.devs0n.eventtx.common.exception

abstract class ValidationException(
    context: String, code: String, description: String,
    className: String, fieldName: String, fieldValue: String, violationMessage: String
) :
    BaseException(context, code, description)
