package com.example.expense.helper;

import java.util.Objects;
import java.lang.reflect.Field;

public class Updater {
  public static <S, T> void updateByIdFieldChecker(S request, T target) {
    // request untuk data yang mau disimpan
    // target untuk data yang sudah tersimpan di database
    if (request == null || target == null) {
      return;
    }

    for (Field requestField : request.getClass().getDeclaredFields()) {
      requestField.setAccessible(true);
      try {
        Object newValue = requestField.get(request);

        // untuk mengecek apa field yang ada di request(request) tidak null
        if (newValue != null) {
          try {
            Field targetField = target.getClass().getDeclaredField(requestField.getName());
            targetField.setAccessible(true);
            Object oldValue = targetField.get(target);

            if (!Objects.equals(newValue, oldValue) && !targetField.equals("id")) {
              targetField.set(target, newValue);
            }
          } catch (NoSuchFieldException ignore) {
            // jika tidak field di target yang sama dari request maka akan di skip.
            // berdasarkan line 21
          }
        }
      } catch (IllegalAccessException e) {
        throw new RuntimeException("Error updating field: " + requestField.getName(), e);
      }
    }
  }
}
