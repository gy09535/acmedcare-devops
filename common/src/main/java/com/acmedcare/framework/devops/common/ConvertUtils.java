package com.acmedcare.framework.devops.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

public class ConvertUtils {

  public static <T> MyPage<T> convertPage(IPage<T> list) {

    MyPage<T> page = new MyPage<T>((int) list.getSize(), (int) list.getCurrent(),
        (int) list.getTotal());
    page.setList(list.getRecords());
    return page;
  }

  public static <Target, Source> Target convertType(Source source, Class<Target> targetClass) {
    java.lang.String str = JacksonHelper
        .objectToJson(source);
    Target target = JacksonHelper
        .jsonToObject(str, targetClass);
    return target;
  }

  public static <Target, Source extends List> List<Target> convertToList(Source source,
      Class<Target> targetClass) {
    java.lang.String str = JacksonHelper
        .objectToJson(source);
    return JacksonHelper
        .jsonToList(str, targetClass);
  }
}
