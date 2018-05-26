package com.don.beans;

import java.io.IOException;
import java.util.List;

public class CacheManager {
	private Cache cache;
	private List<IAccessor> accessors;

	public CacheManager(Cache cache, List<IAccessor> accessors) throws IOException {
		this.cache = cache;
		this.accessors = accessors;

		// initialize the cache by loading the data
		load();
	}

	public void load() throws IOException {
		for (IAccessor accessor : accessors) {
			cache.put(accessor.getKey(), accessor.getData());
		}
	}
}
