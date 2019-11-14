package com.acmedcare.framework.devops.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class JacksonHelper {

  private static ObjectMapper getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /** javaBean,list,array convert to json string */
  public static String objectToJson(Object obj) {
    try {
      return InstanceHolder.INSTANCE.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return "";
  }

  /** json string convert to javaBean */
  public static <T> T jsonToObject(String jsonStr, Class<T> clazz) {
    try {
      return InstanceHolder.INSTANCE.readValue(jsonStr, clazz);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /** json string convert to map */
  public static <T> Map<String, Object> jsonToMap(String jsonStr) {
    try {
      //noinspection unchecked
      return InstanceHolder.INSTANCE.readValue(jsonStr, Map.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /** json string convert to map with javaBean */
  public static <T> Map<String, T> jsonToMap(String jsonStr, Class<T> clazz) {
    try {
      Map<String, Map<String, Object>> map =
          InstanceHolder.INSTANCE.readValue(jsonStr, new TypeReference<Map<String, T>>() {});
      Map<String, T> result = new HashMap<String, T>();
      for (Entry<String, Map<String, Object>> entry : map.entrySet()) {
        result.put(entry.getKey(), mapToObject(entry.getValue(), clazz));
      }
      return result;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /** map convert to javaBean */
  public static <T> T mapToObject(Map map, Class<T> clazz) {
    return InstanceHolder.INSTANCE.convertValue(map, clazz);
  }

  /**
   * convert str to list
   * @param str
   * @param targetClass
   * @param <Target>
   * @return
   */
  public static <Target> List<Target> jsonToList(String str, Class<Target> targetClass) {

    List<Target> targets=null;
    try {
      targets = InstanceHolder.INSTANCE.readValue(str, getCollectionType(InstanceHolder.INSTANCE, List.class, targetClass));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return targets;
  }

  private static JavaType getCollectionType(ObjectMapper mapper,Class<?> collectionClass, Class<?>... elementClasses) {
    return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
  }

  private static class InstanceHolder {

    private static final ObjectMapper INSTANCE;

    static {
      INSTANCE = new ObjectMapper();
      INSTANCE.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
  }
}
