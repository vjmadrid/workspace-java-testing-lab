package com.acme.testing.api.controller.bdd;

import static java.util.Locale.ENGLISH;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class CucumberTypeRegistryConfigurer implements TypeRegistryConfigurer {

	private ObjectMapper mapper;
	
	public CucumberTypeRegistryConfigurer() {
	    mapper = new ObjectMapper();

	    // To serialize and deserialize java.time.LocalDate, LocalDateTime etc.
	    mapper.registerModule(new JavaTimeModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

	    mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
	  }

	  @Override
	  public Locale locale() {
	    return ENGLISH;
	  }

	  @Override
	  public void configureTypeRegistry(cucumber.api.TypeRegistry typeRegistry) {
	    Transformer transformer = new Transformer();
	    typeRegistry.setDefaultDataTableCellTransformer(transformer);
	    typeRegistry.setDefaultDataTableEntryTransformer(transformer);
	    typeRegistry.setDefaultParameterTransformer(transformer);
	  }

	  private class Transformer implements ParameterByTypeTransformer, TableEntryByTypeTransformer,
	      TableCellByTypeTransformer {

	    @Override
	    public Object transform(String s, Type type) {
	      return mapper.convertValue(s, mapper.constructType(type));
	    }

	    @Override
	    public <T> T transform(Map<String, String> map, Class<T> aClass,
	        TableCellByTypeTransformer tableCellByTypeTransformer) {
	      
	      return mapper.convertValue(map, aClass);
	    }

	    @Override
	    public <T> T transform(String s, Class<T> aClass) {
	      return mapper.convertValue(s, aClass);
	    }
	  }

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		// TODO Auto-generated method stub
		
	}

}
