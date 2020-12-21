package com.stock.validator;


import com.stock.annotation.Phone;
import com.stock.enums.ResponseEnum;
import com.stock.util.PhoneUtil;
import io.micrometer.core.instrument.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * @Author:wenhai
 * @Description: {@link Phone} 约束验证器
 * @Date:2020/4/9
 */
public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

    private static final int PHONE_LENGTH = 11;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value) || value.length() != PHONE_LENGTH) {
            context.buildConstraintViolationWithTemplate("手机号码长度必须为11位")
                    .addConstraintViolation();
            return false;
        }
        if (!PhoneUtil.checkPhoneNumber(value)) {
            context.buildConstraintViolationWithTemplate(ResponseEnum.MOBILE_ERROR.getDesc())
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
