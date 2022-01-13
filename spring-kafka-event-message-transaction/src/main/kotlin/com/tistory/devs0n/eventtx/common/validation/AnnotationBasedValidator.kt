package com.tistory.devs0n.eventtx.common.validation

import javax.validation.Validation
import javax.validation.ValidatorFactory

class AnnotationBasedValidator {
    private val factory: ValidatorFactory = Validation.buildDefaultValidatorFactory()
    private val validator = factory.validator

    fun validate(target: Any) {
        val violations = this.validator.validate(target)

        if (violations.isEmpty()) {
            return
        }

        val violation = violations.first()
        val violatedObjectClassName = violation.rootBeanClass.name
        val violatedPropertyName = violation.propertyPath
        val violatedPropertyValue = violation.invalidValue
        val validationMessage = violation.message

        println("$validationMessage - ${violatedObjectClassName}.${violatedPropertyName} is '$violatedPropertyValue'")
    }
}
