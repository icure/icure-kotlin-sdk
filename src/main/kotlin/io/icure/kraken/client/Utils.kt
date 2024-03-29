package io.icure.kraken.client

import com.github.benmanes.caffeine.cache.Cache
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import java.util.*

suspend fun <K, V> Cache<K, Deferred<Optional<V & Any>>>.defGet(key: K & Any, loader: suspend (K) -> V?): V? =
    get(key) { CoroutineScope(Dispatchers.IO).async { Optional.ofNullable(loader(key)) } }?.await()?.orElse(null)

suspend fun <K, V> Cache<K, Deferred<Optional<V & Any>>>.defPut(key: K & Any, loader: suspend (K) -> V?) =
    this.put(key, CoroutineScope(Dispatchers.IO).async { Optional.ofNullable(loader(key)) })

suspend fun <K, V> Cache<K, Deferred<Optional<V & Any>>>.defPutGet(key: K & Any, loader: suspend (K) -> V?): Deferred<Optional<V & Any>> =
    CoroutineScope(Dispatchers.IO).async { Optional.ofNullable(loader(key)) }.also { this.put(key, it) }

fun <T> T.applyIf(predicate: (T) -> Boolean, action: (T) -> T): T {
    return if (predicate.invoke(this)) action.invoke(this) else this
}
