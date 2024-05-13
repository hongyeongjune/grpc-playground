package com.example.grpc.config.armeria

import com.example.grpc.interceptor.GlobalExceptionInterceptor
import com.example.grpc.interceptor.SimpleLoggingInterceptor
import com.linecorp.armeria.server.docs.DocService
import com.linecorp.armeria.server.grpc.GrpcService
import com.linecorp.armeria.spring.ArmeriaServerConfigurator
import io.asyncer.r2dbc.mysql.client.Client
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import io.grpc.kotlin.AbstractCoroutineServerImpl

@Configuration
class ArmeriaConfig {
    @Bean
    fun grpcService(allServiceBean: List<AbstractCoroutineServerImpl>): GrpcService {
        val grpcServiceBuilder = GrpcService.builder()
            .enableUnframedRequests(true)
            .intercept(SimpleLoggingInterceptor(), GlobalExceptionInterceptor())

        allServiceBean.forEach {
            Client.logger.info("Register Grpc Bean : {}", it.javaClass.name)
            grpcServiceBuilder.addService(it)
        }

        return grpcServiceBuilder.build()
    }

    @Bean
    fun armeriaServerConfigurator(grpcService: GrpcService): ArmeriaServerConfigurator {
        return ArmeriaServerConfigurator {
            /**
             * Max Request Length 증설
             */
            it.maxRequestLength(32 * 1024 * 1024)

            /**
             * Grpc 사용을 위한 서비스 등록
             */
            it.service(grpcService)

            /**
             * Docs 생성을 위한 서비스 등록
             */
            it.serviceUnder("/docs", DocService())
        }
    }
}