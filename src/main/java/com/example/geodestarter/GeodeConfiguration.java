package com.example.geodestarter;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

/**
 * Spring {@link Configuration} class used to configure Apache Geode.
 *
 * @author John Blum
 * @see org.apache.geode.cache.client.ClientRegionShortcut
 * @see org.springframework.context.annotation.Configuration
 * @see org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions
 * @see org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration
 * @since 1.0.0
 */
//@SuppressWarnings("unused")
// tag::class[]
@Configuration
//@EnableLogging(logLevel = "error")
//@EnableCachingDefinedRegions(clientRegionShortcut = ClientRegionShortcut.LOCAL)
//@ClientCacheApplication
@EnableCachingDefinedRegions
@EnableGemfireRepositories
@EnableEntityDefinedRegions(basePackageClasses = Box.class)
@EnableClusterConfiguration(useHttp = true )
@EnablePdx(readSerialized = true)
public class GeodeConfiguration { }
// end::class[]

