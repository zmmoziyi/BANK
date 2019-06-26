package com.test.util;

/**
 * @author 张敏
 * @Title: JsonDateValueProcessor
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/3/513:59
 */
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JsonDateValueProcessor implements JsonValueProcessor {
    private String format ="yyyy-MM-dd ";

    public JsonDateValueProcessor() {
        super();
    }

    public JsonDateValueProcessor(String format) {
        super();
        this.format = format;
    }

    @Override
    public Object processArrayValue(Object paramObject,
                                    JsonConfig paramJsonConfig) {
        return process(paramObject);
    }

    @Override
    public Object processObjectValue(String paramString, Object paramObject,
                                     JsonConfig paramJsonConfig) {
        return process(paramObject);
    }


    private Object process(Object value){
        if(value instanceof Date){
            SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.CHINA);
            return sdf.format(value);
        }
        return value == null ? "" : value.toString();
    }

}