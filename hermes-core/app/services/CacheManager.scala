package services

import jdk.internal.org.jline.reader.Editor
import models.User
import org.apache.ignite.cache.CacheMode
import org.apache.ignite.configuration.{CacheConfiguration, IgniteConfiguration}
import org.apache.ignite.{Ignite, IgniteCache, Ignition}
import play.api.inject.ApplicationLifecycle

import java.util.concurrent.CompletableFuture
import javax.inject.Inject
import scala.jdk.FutureConverters._
import javax.inject.Singleton
import javax.persistence.EntityManagerFactory

@Singleton
class CacheManager @Inject() private (val applicationLifecycle: ApplicationLifecycle) {
  // TODO
  // Ignition.setClientMode(true)

  var igniteConfiguration = new IgniteConfiguration()
  igniteConfiguration.setPeerClassLoadingEnabled(false);
  var ignite : Ignite = Ignition.getOrStart(igniteConfiguration);
  val userCacheConfig: CacheConfiguration[String, Int] = new CacheConfiguration[String, Int]("_core")
                                                                            .setCacheMode(CacheMode.PARTITIONED)

  var cache: IgniteCache[String, Int] = ignite.getOrCreateCache(userCacheConfig)

  applicationLifecycle.addStopHook(() => {
    ignite.close()
    CompletableFuture.completedFuture(null).asScala
  })

  def persistUser(entityManagerFactory: EntityManagerFactory, user: User): Unit = {
    val transactionManager = com.arjuna.ats.jta.TransactionManager.transactionManager()

    transactionManager.begin()
    val entityManager = entityManagerFactory.createEntityManager()
    entityManager.persist(user);
    val testUser = entityManager.find(classOf[User], user.userId);
    println(testUser);
    entityManager.close();
    transactionManager.commit();
  }

  println("Instantiated")
}
