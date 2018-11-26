package com.hui.wang.spring.cloud.source;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 *
 * @author hui.wang09
 * @since 25 November 2018
 */
@Component
public class SimpleSourceBean {

	private final Logger LOGGER = Logger.getLogger(SimpleSourceBean.class);

	private Source source;

	@Autowired

	public SimpleSourceBean(Source source) {
		this.source = source;
	}

	public void publish() {
		Map<String, Object> map = Maps.newHashMap();
		List<String> list = Lists.newArrayList();

		list.add("test");
		map.put("A", list);
		map.put("B","123");

		source
				.output()
				.send(MessageBuilder.withPayload(map).build());
	}
}
