package net.cap5lut.ao.netty.ao;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AoClientHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.atDebug().log(
                "Connection established. {}->{}", ctx.channel().localAddress(), ctx.channel().remoteAddress()
        );
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.atDebug().log(
                "Connection closed. {}->{}", ctx.channel().localAddress(), ctx.channel().remoteAddress()
        );
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.atTrace().log(
                "Packet: {} {}->{}", msg, ctx.channel().localAddress(), ctx.channel().remoteAddress()
        );
    }
}
