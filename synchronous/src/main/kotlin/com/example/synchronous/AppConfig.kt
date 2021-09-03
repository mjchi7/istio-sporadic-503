package com.example.synchronous

import org.apache.catalina.connector.Connector
import org.apache.coyote.http11.AbstractHttp11Protocol
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory

import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.context.annotation.Configuration

@Configuration
class TomcatCustomizer : WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
    override fun customize(factory: TomcatServletWebServerFactory) {
        factory.addConnectorCustomizers(TomcatConnectorCustomizer { connector: Connector ->
            val protocol = connector.protocolHandler as AbstractHttp11Protocol<*>
            val originMaxKeepAliveRequests = protocol.maxKeepAliveRequests
            val originKeepAliveTimeout = protocol.keepAliveTimeout
            println(
                "####################################################################################"
            )
            println("#")
            println("# TomcatCustomizer")
            println("#")
            println("# origin maxKeepAliveRequests $originMaxKeepAliveRequests")
            println("# origin keepalive timeout: $originKeepAliveTimeout ms")
            println("# keepalive timeout: ${protocol.keepAliveTimeout} ms")
            println("# connection timeout: ${protocol.connectionTimeout} ms")
            println("# max connections: ${protocol.maxConnections}")
            println("#")
            println(
                "####################################################################################"
            )
        })
    }
}