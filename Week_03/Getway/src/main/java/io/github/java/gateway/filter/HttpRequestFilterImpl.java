package src.main.java.io.github.java.gateway.filter;

public class HttpRequestFilterImpl implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        //在此对http请求进行过滤
        String URL = fullRequest.getURL;
    }
}
