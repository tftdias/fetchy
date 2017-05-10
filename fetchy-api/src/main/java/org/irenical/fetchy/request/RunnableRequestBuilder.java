package org.irenical.fetchy.request;

import org.irenical.fetchy.Fetchy;

public class RunnableRequestBuilder<API, ERROR extends Exception> {
	
	private Fetchy fetchy;

	private String serviceId;

	private Integer timeoutMillis;
	
	private String name;

	private Run<API, ERROR> runnable;

	private RunFallback fallback;

	public RunnableRequestBuilder(Fetchy fetchy) {
		this.fetchy = fetchy;
	}

	public RunnableRequestBuilder<API, ERROR> service(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}

	public RunnableRequestBuilder<API, ERROR> timeout(Integer timeoutMillis) {
		this.timeoutMillis = timeoutMillis;
		return this;
	}
	
	public RunnableRequestBuilder<API, ERROR> name(String name) {
		this.name = name;
		return this;
	}

	public RunnableRequestBuilder<API, ERROR> runnable(Run<API, ERROR> lambda) {
		this.runnable = lambda;
		return this;
	}

	public RunnableRequestBuilder<API, ERROR> fallback(RunFallback fallback) {
		this.fallback = fallback;
		return this;
	}

	public RunnableRequest<ERROR> build() {
		return new ImmutableRunnableRequest<>(name, fetchy, serviceId, timeoutMillis, runnable, fallback);
	}

}