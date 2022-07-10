package c99.ams.userservice.utils.mappers.annotation;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(value = RetentionPolicy.CLASS)
public @interface EncodeStringMapping {
}
