/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 cuisongliu@qq.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.cuisongliu.druid.autoconfigure.condition;

import com.cuisongliu.druid.autoconfigure.stat.DruidStatProperties;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.*;

/**
 * aop types init conditional
 *
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2017-05-21 11:32
 */
public  class AopTypesInitCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        List list = ConditionUtil.getInstance().getAopTypesValue(context);
        if (list.contains(DruidStatProperties.AopTypeValues.TYPE)||
                list.contains(DruidStatProperties.AopTypeValues.NAME) ) {
            return true;
        } else {
            throw new IllegalStateException(DruidStatProperties.DRUID_STAT_PREFIX + ".aop-types must has [" +
                    DruidStatProperties.AopTypeValues.TYPE + "," +
                    DruidStatProperties.AopTypeValues.NAME + "," +
                    "]");
        }
    }

}
