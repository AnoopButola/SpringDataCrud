/**
 * 
 */
package com.example.accessingdatamysql;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.id.enhanced.TableGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

/**
 * @author Anoop Butola
 *
 */
//public class CustomSequenceGenrator extends SequenceStyleGenerator {
    
public class CustomSequenceGenrator extends TableGenerator{
	 public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
	    public static final String VALUE_PREFIX_DEFAULT = "";
	 
	   /* @Override
	    public Serializable generate(SharedSessionContractImplementor session,
	            Object object) throws HibernateException {
	    	return (Long)super.generate(session, object);
	    }
	    
	 
	    @Override
	    public void configure(Type type, Properties params,
	            ServiceRegistry serviceRegistry) throws MappingException {
	        super.configure(LongType.INSTANCE, params, serviceRegistry);
	    }
	    */

	    @Override
	    protected int determineIncrementSize(Properties params) {
			return super.determineIncrementSize(params)+1;
		}
	    
	 
}