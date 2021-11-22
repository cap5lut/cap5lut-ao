package net.cap5lut.ao.netty.ao;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import net.cap5lut.ao.entities.Server;
import net.cap5lut.ao.netty.ao.packet.client._ClientPacketEncoder;
import net.cap5lut.ao.netty.ao.packet.server._ServerPacketDecoder;

public class AoClient implements AutoCloseable {
    private final EventLoopGroup workers;

    public AoClient(Server server) {
        this.workers = new NioEventLoopGroup();
        new Bootstrap()
                .group(workers)
                .channel(NioSocketChannel.class)
                .remoteAddress(server.address())
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel channel) throws Exception {
                        channel.pipeline().addLast(
                                new _ServerPacketDecoder(),
                                new _ClientPacketEncoder(),
                                new AoClientHandler()
                        );
                    }
                })
                .connect()
                .syncUninterruptibly()
                .channel()
                .closeFuture()
                .syncUninterruptibly();
    }

    @Override
    public void close() throws Exception {
        workers.shutdownGracefully();
    }
}
