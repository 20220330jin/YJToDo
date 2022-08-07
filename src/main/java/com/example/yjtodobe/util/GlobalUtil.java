package com.example.yjtodobe.util;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GlobalUtil {

    public static <T> boolean nullCheck(T obj){
        if(Optional.ofNullable(obj).isPresent()){
            /**
             * List
             */
            if(obj instanceof List){
                List col = (List) obj;

                return col.isEmpty();
            }

            /**
             *  String
             */
            else if(obj instanceof String){
                String str = obj.toString();

                return StringUtils.isEmpty(str);
            }

            /**
             *  Map
             */
            else if(obj instanceof Map){
                Map map = (Map) obj;

                return map.size() == 0;
            }

            /**
             *  Optional
             */
            else if(obj instanceof Optional){
                Optional otp = (Optional) obj;

                return !otp.isPresent();
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
