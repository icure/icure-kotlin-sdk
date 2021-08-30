package io.icure.kraken.client

import com.github.benmanes.caffeine.cache.Cache
import kotlinx.coroutines.*
import java.util.*

@DelicateCoroutinesApi
suspend fun <K, V> Cache<K, Deferred<Optional<V>>>.defGet(key: K, loader: suspend (K) -> V?): V? = this.get(key) { GlobalScope.async { Optional.ofNullable(loader(key)) } }.await().orElse(null)
@DelicateCoroutinesApi
suspend fun <K, V> Cache<K, Deferred<Optional<V>>>.defPut(key: K, loader: suspend (K) -> V?) = this.put(key, GlobalScope.async { Optional.ofNullable(loader(key)) } )