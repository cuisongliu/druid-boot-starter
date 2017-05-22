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
import org.springframework.context.annotation.ConditionContext;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * about condition util for aop types
 *
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2017-05-21 12:43
 */
class ConditionUtil {
    private static ConditionUtil instance = new ConditionUtil();

    static ConditionUtil getInstance() {
        if (instance == null)
            instance = new ConditionUtil();
        return instance;
    }

    private ConditionUtil() {
    }

    List getAopTypesValue(ConditionContext context){
        String aopTypesKey = DruidStatProperties.DRUID_STAT_PREFIX+".aop-types";
        Set<String> keySet = new LinkedHashSet<String>();
        for (int i = 0; i <3 ; i++) {
            String field = context.getEnvironment().getProperty(aopTypesKey+"["+i+"]", String.class);
            if (!StringUtils.isEmpty(field))
                keySet.add(field.toLowerCase());
        }
        if (keySet.size() > 0 ){
            return new ArrayList<String>(keySet);
        }else {
            return new ArrayList<String>();
        }

    }
}
