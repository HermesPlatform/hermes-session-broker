package services

import org.apache.ignite.cache.CacheMode
import org.apache.ignite.configuration.{CacheConfiguration, IgniteConfiguration}
import org.apache.ignite.{Ignite, IgniteCache, Ignition}
import play.api.inject.ApplicationLifecycle

import java.util.concurrent.CompletableFuture
import javax.inject.Inject
import scala.jdk.FutureConverters._
import javax.inject.Singleton

@Singleton
class CacheManager @Inject() private (val applicationLifecycle: ApplicationLifecycle) {
  // TODO
  //  Ignition.setClientMode(true)

  var igniteConfiguration = new IgniteConfiguration()
  igniteConfiguration.setPeerClassLoadingEnabled(true);

  var ignite : Ignite = Ignition.getOrStart(igniteConfiguration);
  val userCacheConfig: CacheConfiguration[String, Int] = new CacheConfiguration[String, Int]("_core")
                                                                            .setCacheMode(CacheMode.PARTITIONED)

  var cache: IgniteCache[String, Int] = ignite.getOrCreateCache(userCacheConfig)

  applicationLifecycle.addStopHook(() => {
    ignite.close()
    CompletableFuture.completedFuture(null).asScala
  })

  println("Instantiated")
}
