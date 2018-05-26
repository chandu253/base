package com.ehcache.test;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class EHCacheTest {
	public static void main(String[] args) {
		CacheManager cManager = new CacheManager();
		Ehcache jobsheetRegionCache = cManager.getEhcache("jobsheetRegion");

		jobsheetRegionCache.put(new Element(1, "john"));
		Element e = jobsheetRegionCache.get(1);
		System.out.println(e.getValue());
	}
}





