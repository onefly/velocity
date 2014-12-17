package com.jd.head.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

public class CustomObjectMapper extends ObjectMapper {
	public CustomObjectMapper() {
		CustomSerializerFactory factory = new CustomSerializerFactory();
		// 格式化日期
		factory.addGenericMapping(Date.class, new JsonSerializer<Date>() {
			@Override
			public void serialize(Date value, JsonGenerator jsonGenerator,
					SerializerProvider provider) throws IOException,
					JsonProcessingException {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				jsonGenerator.writeString(sdf.format(value));
			}
		});

		// Long转换为String
		factory.addGenericMapping(Long.class, new JsonSerializer<Long>() {
			@Override
			public void serialize(Long value, JsonGenerator jgen,
					SerializerProvider provider) throws IOException,
					JsonProcessingException {
				jgen.writeString(String.valueOf(value));
			}
		});

		// long转换为String
		factory.addGenericMapping(long.class, new JsonSerializer<Long>() {
			@Override
			public void serialize(Long value, JsonGenerator jgen,
					SerializerProvider provider) throws IOException,
					JsonProcessingException {
				jgen.writeString(String.valueOf(value));
			}
		});

		this.setSerializerFactory(factory);
	}
}
