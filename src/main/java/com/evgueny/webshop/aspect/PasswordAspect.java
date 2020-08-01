package com.evgueny.webshop.aspect;

import com.evgueny.webshop.model.User;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.lang.reflect.Field;
import java.util.Collection;

@Component
@Aspect
public class PasswordAspect {

    @AfterReturning(value = "execution(* com.evgueny.webshop.service.*.*(..)))", returning = "result")
    public void secure(Object result) {
        if (result instanceof User) {
            User user = (User) result;
            user.setPassword("secured");
            // return;
        }
        if (result instanceof Collection) {
            Collection collection = (Collection) result;
            if (!collection.isEmpty() && collection.iterator().next() instanceof User) {
                for (Object o : collection) {
                    User user = (User) o;
                    user.setPassword("secured");
                }
            }
            //   return;
        }
        //TODO Извлекаем поля. Если среди них есть user или collec user то вызываем метод.
        if (result instanceof Collection){
            Collection collection=(Collection)result;
            for (Object o:collection){
                Field[] fields = o.getClass().getDeclaredFields();
                for (Field field:fields){
                    secure(field);
                }
            }
        }
        Field[] fields = result.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i]!=null){
                Class<?> type = fields[i].getType();
                secure(fields[i]);
            }
        }
    }
}
