package config

import models.{HostSession, User}
import org.apache.ignite.cache.CacheAtomicityMode
import org.apache.ignite.configuration.{CacheConfiguration, IgniteConfiguration}
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder
import org.hibernate.ogm.datastore.ignite.IgniteConfigurationBuilder

import java.util.Arrays.asList
import scala.collection.mutable.ListBuffer

class ConfigurationBuilder extends IgniteConfigurationBuilder {
  override def build(): IgniteConfiguration = {
    val config = new IgniteConfiguration;

//    config.setPeerClassLoadingEnabled(true);
    config.setClientMode(false);

    val cacheConfig = new CacheConfiguration()
            .setName("main")
            .setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL)
            .setIndexedTypes(classOf[User], classOf[HostSession])

    config.setCacheConfiguration(cacheConfig)
  }
}