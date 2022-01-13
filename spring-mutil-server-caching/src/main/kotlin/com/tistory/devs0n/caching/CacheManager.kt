package com.tistory.devs0n.caching

import org.springframework.cache.Cache
import org.springframework.cache.support.AbstractCacheManager

class CacheManager : AbstractCacheManager() {
    override fun loadCaches(): MutableCollection<out Cache> {
        TODO("Not yet implemented")
    }
}
