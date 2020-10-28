package homeWork2.HttpClient.src.main.java;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by figuo on 10/27/20.
 */
public class FishHttpClient {

    private static final int CONNECTION_REQUEST_TIMEOUT = 1000; //wait 1s
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_XML = "application/xml";
    public static final String APPLICATION_FASTINFOSET = "application/fastinfoset";
    public static final String APPLICATION_FORMURLENCODED = "application/x-www-form-urlencoded";

    protected final CloseableHttpClient client;


    /**
     * Constructor.
     */
    public FishHttpClient(int connectionTimeout,
                          int readTimeout, int maxConnections) {

        client = HttpClients.custom()
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                .disableCookieManagement()
                .disableRedirectHandling()
                .setMaxConnTotal(maxConnections)
                .setMaxConnPerRoute(maxConnections)
                .setDefaultRequestConfig(RequestConfig.custom()
                        //to avoid too much waiting thread
                        .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                        .setConnectTimeout(connectionTimeout)
                        .setSocketTimeout(readTimeout).build())
                .build();
    }

    /**
     * get request.
     *
     * @param completeUrl complete url path
     * @param respType    response type
     * @param <P>         response object
     * @return response object
     * @throws IOException io exception.
     */
    public <P> P get(String completeUrl, Class<P> respType,
                     homeWork2.HttpClient.src.main.java.MarshalingType marshallerType)
            throws Exception {

        final HttpGet httpGet = new HttpGet(completeUrl);

        setHeader(httpGet, marshallerType);

        return executeRequest(httpGet, respType);
    }

    /**
     * Set default header by marshallerType.
     *
     * @param httpMethod     httpMethod
     * @param marshallerType marshallerType
     */
    private void setHeader(HttpRequestBase httpMethod, homeWork2.HttpClient.src.main.java.MarshalingType
            marshallerType) {
        if (null == marshallerType) {
            return;
        }
        switch (marshallerType) {
            case FI:
                httpMethod.setHeader(CONTENT_TYPE, APPLICATION_FASTINFOSET);
                break;
            case XML:
                httpMethod.setHeader(CONTENT_TYPE, APPLICATION_XML);
                break;
            case JSON:
                httpMethod.setHeader(CONTENT_TYPE, APPLICATION_JSON);
                break;
            case FORMURLENCODE:
                httpMethod.setHeader(CONTENT_TYPE, APPLICATION_FORMURLENCODED);
                break;
            default:
                httpMethod.setHeader(CONTENT_TYPE, APPLICATION_JSON);
                break;

        }
    }

    private <Q extends Serializable, P> P executeRequest(HttpRequestBase httpMethod,
                                                         Class<P> responseType)
            throws Exception {
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = this.client.execute(httpMethod);
            //there should add format responseType logic
            return formatResponse(httpResponse);
        } catch (IOException ex) {
            //handles httpClient IOException, transform to DataTransportException.
        } finally {
            if (httpResponse != null) {
                httpResponse.close();
            }
        }
        return null;
    }

    private <P> P formatResponse(CloseableHttpResponse response) throws IOException {
        String responseStr = "I am a test RS";
        try {
            //TODO: format Response.
            return unmarshal(responseStr);
        } catch (Exception ex) {
            return null;
        }
    }

    public static <T> T unmarshal(String xml) throws Exception {
        try {
            return (T) xml;
        } catch (Exception e) {
            //TODO;
        }
        return null;
    }
}



