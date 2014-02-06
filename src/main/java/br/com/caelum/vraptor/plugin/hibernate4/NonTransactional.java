/**
 * Prevents the {@link HibernateTransactionInterceptor} from creating a transaction to the request method.
 * 
 * @author dtelaroli
 */
package br.com.caelum.vraptor.plugin.hibernate4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NonTransactional {
	
}