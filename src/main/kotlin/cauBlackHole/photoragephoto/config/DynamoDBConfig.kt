package cauBlackHole.photoragephoto.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

@Configuration
@EnableDynamoDBRepositories(basePackages = ["cauBlackHole.photoragephoto.repository"])
class DynamoDBConfig {
    @Value("#spring.amazon.dynamodb.endpoint")
    lateinit var amazonDynamoDbEndPoint: String

    @Value("#spring.amazon.dynamodb.region")
    lateinit var amazonDynamoDbRegion: String

    @Value("#spring.amazon.aws.access-key")
    lateinit var amazonAwsAccessKey: String

    @Value("#spring.amazon.aws.secret-key")
    lateinit var amazonAwsSecretKey: String

    @Primary
    @Bean
    fun dynamoDbMapper(amazonDynamoDB: AmazonDynamoDB) = DynamoDBMapper(amazonDynamoDB, DynamoDBMapperConfig.DEFAULT)

    @Bean
    fun dynamoDBMapper(amazonDynamoDB: AmazonDynamoDB, config: DynamoDBMapperConfig) = DynamoDBMapper(amazonDynamoDB, config)

    @Bean(name= ["amazonDynamoDB"])
    fun amazonDynamoDB(): AmazonDynamoDB? {
        val credentialsProvider = AWSStaticCredentialsProvider(BasicAWSCredentials(amazonAwsAccessKey, amazonAwsSecretKey))
        val endpointConfiguration = EndpointConfiguration(amazonDynamoDbEndPoint, amazonDynamoDbRegion)

        return AmazonDynamoDBClientBuilder.standard()
            .withCredentials(credentialsProvider)
            .withEndpointConfiguration(endpointConfiguration)
            .build()
    }

    companion object{
        class LocalDateTimeConverter: DynamoDBTypeConverter<Date, LocalDateTime> {
            override fun convert(source: LocalDateTime) = Date.from(source.toInstant(ZoneOffset.UTC))
            override fun unconvert(source: Date) = source.toInstant().atZone(TimeZone.getDefault().toZoneId()).toLocalDateTime()
        }
    }
}