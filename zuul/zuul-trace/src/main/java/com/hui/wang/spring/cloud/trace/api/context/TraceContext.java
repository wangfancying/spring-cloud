package com.hui.wang.spring.cloud.trace.api.context;

import com.hui.wang.spring.cloud.trace.api.model.Trace;

import org.springframework.util.Assert;

/**
 *
 * @author hui.wang09
 * @since 19 November 2018
 */
public class TraceContext {

	private static final ThreadLocal<Trace> TRACE_CONTEXT = new ThreadLocal<Trace>();

	public static Trace getTraceContext() {
		return TRACE_CONTEXT.get();
	}

	public static void setTraceContext(Trace traceContext) {
		Assert.notNull(traceContext, "Only non-null traceContext instances are permitted");
		TRACE_CONTEXT.set(traceContext);
	}

	public static void clean() {
		TRACE_CONTEXT.remove();
	}
}
