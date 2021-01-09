package org.openrefine.preference;

import org.openrefine.RefineModel;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class PreferenceValueResolver extends TypeIdResolverBase {
	
	protected TypeFactory factory = TypeFactory.defaultInstance();

	@Override
	public String idFromValue(Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String idFromValueAndType(Object value, Class<?> suggestedType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Id getMechanism() {
		return Id.NAME;
	}

	@Override
    public JavaType typeFromId(DatabindContext context, String id) {
    	Class<?> klass;
		try {
			klass = RefineModel.getClass(id);
		} catch (ClassNotFoundException e) {
    		throw new IllegalArgumentException("Unknown preference value type: '"+id+"'");
    	}
    	return factory.constructSimpleType(klass, klass, new JavaType[0]);
    }
}
